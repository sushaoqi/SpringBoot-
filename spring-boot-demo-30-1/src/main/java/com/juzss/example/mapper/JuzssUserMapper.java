package com.juzss.example.mapper;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.bean.JuzssUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JuzssUserMapper {
    int countByExample(JuzssUserExample example);

    int deleteByExample(JuzssUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JuzssUser record);

    int insertSelective(JuzssUser record);

    List<JuzssUser> selectByExample(JuzssUserExample example);

    JuzssUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JuzssUser record, @Param("example") JuzssUserExample example);

    int updateByExample(@Param("record") JuzssUser record, @Param("example") JuzssUserExample example);

    int updateByPrimaryKeySelective(JuzssUser record);

    int updateByPrimaryKey(JuzssUser record);
}