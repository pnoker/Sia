package com.Sia.dao;

import com.Sia.model.OrderDisp;
import com.Sia.model.OrderDispExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDispMapper {
    int countByExample(OrderDispExample example);

    int deleteByExample(OrderDispExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDisp record);

    int insertSelective(OrderDisp record);

    List<OrderDisp> selectByExample(OrderDispExample example);

    OrderDisp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderDisp record, @Param("example") OrderDispExample example);

    int updateByExample(@Param("record") OrderDisp record, @Param("example") OrderDispExample example);

    int updateByPrimaryKeySelective(OrderDisp record);

    int updateByPrimaryKey(OrderDisp record);
}