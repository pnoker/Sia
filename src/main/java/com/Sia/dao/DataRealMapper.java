package com.Sia.dao;

import com.Sia.model.DataReal;
import com.Sia.model.DataRealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataRealMapper {
    int countByExample(DataRealExample example);

    int deleteByExample(DataRealExample example);

    int deleteByPrimaryKey(Integer nodeId);

    int insert(DataReal record);

    int insertSelective(DataReal record);

    List<DataReal> selectByExample(DataRealExample example);

    DataReal selectByPrimaryKey(Integer nodeId);

    int updateByExampleSelective(@Param("record") DataReal record, @Param("example") DataRealExample example);

    int updateByExample(@Param("record") DataReal record, @Param("example") DataRealExample example);

    int updateByPrimaryKeySelective(DataReal record);

    int updateByPrimaryKey(DataReal record);
}