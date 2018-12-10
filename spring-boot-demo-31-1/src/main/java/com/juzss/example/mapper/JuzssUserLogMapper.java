package com.juzss.example.mapper;

import com.juzss.example.bean.JuzssUserLog;
import com.juzss.example.bean.JuzssUserLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JuzssUserLogMapper {
    int countByExample(JuzssUserLogExample example);

    int deleteByExample(JuzssUserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JuzssUserLog record);

    int insertSelective(JuzssUserLog record);

    List<JuzssUserLog> selectByExample(JuzssUserLogExample example);

    JuzssUserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JuzssUserLog record, @Param("example") JuzssUserLogExample example);

    int updateByExample(@Param("record") JuzssUserLog record, @Param("example") JuzssUserLogExample example);

    int updateByPrimaryKeySelective(JuzssUserLog record);

    int updateByPrimaryKey(JuzssUserLog record);
}