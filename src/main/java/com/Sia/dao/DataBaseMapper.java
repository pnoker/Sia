package com.Sia.dao;

import com.Sia.model.DataBase;
import com.Sia.model.DataBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataBaseMapper {
    int countByExample(DataBaseExample example);

    int deleteByExample(DataBaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataBase record);

    int insertSelective(DataBase record);

    List<DataBase> selectByExample(DataBaseExample example);

    DataBase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataBase record, @Param("example") DataBaseExample example);

    int updateByExample(@Param("record") DataBase record, @Param("example") DataBaseExample example);

    int updateByPrimaryKeySelective(DataBase record);

    int updateByPrimaryKey(DataBase record);
}