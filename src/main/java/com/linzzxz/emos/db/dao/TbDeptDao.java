package com.linzzxz.emos.db.dao;

import com.linzzxz.emos.db.pojo.TbDept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbDeptDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbDept record);

    int insertSelective(TbDept record);

    TbDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbDept record);

    int updateByPrimaryKey(TbDept record);
}