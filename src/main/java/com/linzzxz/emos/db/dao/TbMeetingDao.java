package com.linzzxz.emos.db.dao;

import com.linzzxz.emos.db.pojo.TbMeeting;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbMeetingDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbMeeting record);

    int insertSelective(TbMeeting record);

    TbMeeting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbMeeting record);

    int updateByPrimaryKey(TbMeeting record);
}