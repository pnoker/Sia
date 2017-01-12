package com.Sia.dao;

import com.Sia.model.ConfigProtocol;
import com.Sia.model.ConfigProtocolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigProtocolMapper {
    int countByExample(ConfigProtocolExample example);

    int deleteByExample(ConfigProtocolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigProtocol record);

    int insertSelective(ConfigProtocol record);

    List<ConfigProtocol> selectByExample(ConfigProtocolExample example);

    ConfigProtocol selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigProtocol record, @Param("example") ConfigProtocolExample example);

    int updateByExample(@Param("record") ConfigProtocol record, @Param("example") ConfigProtocolExample example);

    int updateByPrimaryKeySelective(ConfigProtocol record);

    int updateByPrimaryKey(ConfigProtocol record);

	ConfigProtocol selectByDataRealId(int dataRealId);
}