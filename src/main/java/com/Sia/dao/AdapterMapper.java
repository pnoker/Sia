package com.Sia.dao;

import com.Sia.model.Adapter;
import com.Sia.model.AdapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdapterMapper {
    int countByExample(AdapterExample example);

    int deleteByExample(AdapterExample example);

    int deleteByPrimaryKey(Integer nodeId);

    int insert(Adapter record);

    int insertSelective(Adapter record);

    List<Adapter> selectByExample(AdapterExample example);

    Adapter selectByPrimaryKey(Integer nodeId);

    int updateByExampleSelective(@Param("record") Adapter record, @Param("example") AdapterExample example);

    int updateByExample(@Param("record") Adapter record, @Param("example") AdapterExample example);

    int updateByPrimaryKeySelective(Adapter record);

    int updateByPrimaryKey(Adapter record);
}