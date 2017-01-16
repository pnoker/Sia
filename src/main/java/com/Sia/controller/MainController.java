package com.Sia.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Sia.model.Users;
import com.Sia.model.Weather;
import com.Sia.pojo.DockedItems;
import com.Sia.pojo.MenuPlus;
import com.Sia.service.MenuService;
import com.Sia.service.UserService;
import com.Sia.service.WeatherService;
import com.Sia.util.tools.WeathUtil;
import com.alibaba.fastjson.JSON;
import com.annotation.AuthPassport;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

@Controller
@RequestMapping("/")
public class MainController extends BaseController {
	static final Logger logger = LogManager.getLogger(MainController.class);// 日志
	@Autowired
	private MenuService menuService;
	@Autowired
	private UserService userService;
	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		logger.info("登陆首页");
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "/login";
		}
		/* 返回登录页面之后清空全部session */
		Enumeration em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		return "/login";
	}

	@ResponseBody
	@RequestMapping(value = "/loginIn", produces = "text/html;charset=UTF-8")
	public String loginIn(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @RequestParam String password, @RequestParam String validate,
			@RequestParam String remember) throws IOException {
		String message = "";
		username = decoderURL(username).trim();
		password = decoderURL(password).trim();
		validate = decoderURL(validate).trim();
		String verifyCode = (String) request.getSession().getAttribute("verifyCode");
		if (verifyCode.equalsIgnoreCase(validate)) {
			logger.info("验证码正确");
			Users user = userService.selectUserNPM(username);
			if (user != null) {
				logger.info("用户名正确");
				if (user.getPassword().equals(password)) {
					logger.info("密码正确");
					request.getSession().setAttribute("verifyCode", UUID.randomUUID().toString());
					request.getSession().setAttribute("userId", user.getId());
					request.getSession().setAttribute("userName", user.getUsername());
					request.getSession().setAttribute("authoIdr", user.getAuthorId());
					user.setLastTime(new Date());
					user.setLoginNum(user.getLoginNum() + 1);
					if (userService.updateByPrimaryKeySelective(user) > 0) {
						logger.info("修改成功");
						message = "登陆成功！";
					}
				} else {
					return createSimpleFailureJson("密码输入错误，请重新输入密码，区分大小写！");
				}
			} else {
				return createSimpleFailureJson("用户不存在，检查用户名输入是否有误！");
			}
		} else {
			return createSimpleFailureJson("验证码输入有误，请重新刷新验证码！");
		}
		return createSimpleSuccessJson(message);
	}

	@RequestMapping("/error")
	public String error(ModelMap modelMap) {
		logger.info("错误页面");
		return "/error";
	}

	@RequestMapping("/loginOut")
	@SuppressWarnings("rawtypes")
	public void loginOut(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		logger.info("退出登陆，并返回到登陆页面");
		HttpSession session = request.getSession(false);
		String path = request.getContextPath();
		if (session == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		Enumeration em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<script>");
		out.println("window.open ('" + path + "','_top')");
		out.println("</script>");
		out.println("</html>");
	}

	@ResponseBody
	@RequestMapping("/validate")
	public void validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedImage bi = new BufferedImage(284, 40, BufferedImage.TYPE_INT_RGB);
		Graphics grap = bi.getGraphics();
		Font f = new Font("Arial Black", Font.ITALIC, 30);
		grap.setFont(f);
		Color color = new Color(255, 255, 255);
		grap.setColor(color);
		grap.fillRect(0, 0, 284, 40);// 坐标 绘制图片宽、高
		char[] content = "abcdefghijkmnprstuvwxyzABCDEFGHIJKMNPQRSTUVWXY345678".toCharArray();
		Random ran = new Random();// 根据随机数来取组合验证码内容
		int len = content.length, index;
		StringBuffer generateCode = new StringBuffer();// 存储随机生成的验证码
		// 生成4位的验证码
		for (int i = 0; i < 4; i++) {
			index = ran.nextInt(len);
			// 设置验证码颜色
			grap.setColor(new Color(ran.nextInt(100), ran.nextInt(150), ran.nextInt(200)));
			// 将字符画在画板上
			grap.drawString(content[index] + "", i * 26 + 90, 30);
			generateCode.append(content[index]);
		}
		// 将生成的验证码放在session中以便之后验证用到
		request.getSession().setAttribute("verifyCode", generateCode.toString());
		logger.info(generateCode.toString());
		// 将生成的验证码图片输出
		ImageIO.write(bi, "PNG", response.getOutputStream());
	}

	@ResponseBody
	@RequestMapping("/qrImage")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void qrImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		int BLACK = 0xFF000000;
		int WHITE = 0xFFFFFFFF;
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			String content = "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath();
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
			for (int x = 0; x < 400; x++) {
				for (int y = 0; y < 400; y++) {
					image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
				}
			}
			logger.info(content);
			ImageIO.write(image, "PNG", response.getOutputStream());
		} catch (WriterException e) {
			logger.error(e.getMessage());
		}
	}

	@AuthPassport
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		logger.info("加载首页");
		DockedItems dockedItems = new DockedItems();
		String items = dockedItems.getDockedItems(request, "标记", "tick", "onConfirmClick");
		items += dockedItems.getDockedItems(request, "添加", "time_add", "onConfirmClick");
		items += dockedItems.getDockedItems(request, "删除", "time_delete", "onConfirmClick");
		items += dockedItems.getDockedItems(request, "刷新", "arrow_refresh", "onConfirmClick");
		items = items.substring(0, items.lastIndexOf(","));
		modelMap.addAttribute("dockedItems", items);
		return "/index";
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/menu", produces = "text/html;charset=UTF-8")
	public String menu(ModelMap modelMap, HttpServletRequest request) {
		int userId = 1;
		try {
			userId = (int) request.getSession().getAttribute("userId");
			logger.info("用户ID为：" + userId);
		} catch (Exception e) {
		}
		Map<String, List<MenuPlus>> map = new HashMap<String, List<MenuPlus>>();
		List<MenuPlus> menus = menuService.selectByEnable(1, userId);
		map.put("menus", menus);
		return JSON.toJSONString(map);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/name", produces = "text/html;charset=UTF-8")
	public String name(HttpServletResponse response, ModelMap modelMap, @RequestParam String name) {
		Map<String, String> map = new HashMap<String, String>();
		name = " <b style='color:red;'>" + name + "</b>";
		map.put("name", name);
		map.put("url", "/index.do");
		return JSON.toJSONString(map);
	}

	@AuthPassport
	@RequestMapping(value = "/calendar", produces = "text/html;charset=UTF-8")
	public String calendar(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @RequestParam String location) throws Exception {
		logger.info("请求的地理位置为：" + location);
		WeathUtil signatuUtil = new WeathUtil();
		String jsonString = signatuUtil.getWeatherJson(location);
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray results = jsonObject.getJSONArray("results");
			JSONObject city = results.getJSONObject(0).getJSONObject("location");
			JSONObject now = results.getJSONObject(0).getJSONObject("now");
			String weather = "" + now.get("text");
			String code = "" + now.get("code");
			Weather item = weatherService.selectByCode(Integer.parseInt(code));
			modelMap.addAttribute("city", "" + city.get("name"));
			modelMap.addAttribute("weather", weather);
			modelMap.addAttribute("temperature", "" + now.get("temperature"));
			modelMap.addAttribute("pic", item.getPicture());
			logger.info(city.get("name") + " " + weather + " " + now.get("temperature") + "℃");
		} catch (Exception e) {
			modelMap.addAttribute("pic", "99.png");
			logger.info("天气状况未知……");
		}
		return "/part/weather";
	}
}