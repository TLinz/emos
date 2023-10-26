package com.linzzxz.emos.db.dao;

import com.linzzxz.emos.db.pojo.TbAction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbActionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAction record);

    int insertSelective(TbAction record);

    TbAction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAction record);

    int updateByPrimaryKey(TbAction record);
}