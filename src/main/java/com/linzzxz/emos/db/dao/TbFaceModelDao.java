package com.linzzxz.emos.db.dao;

import com.linzzxz.emos.db.pojo.TbFaceModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbFaceModelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbFaceModel record);

    int insertSelective(TbFaceModel record);

    TbFaceModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbFaceModel record);

    int updateByPrimaryKey(TbFaceModel record);
}