package com.kang.dao.user;

import com.kang.pojo.UserDiary;

import java.util.List;

public interface UserMapper {
    int addDairy(UserDiary dairy);                   // 新增一个动态
    List<UserDiary> queryAlldiary(String userId);    //查询全部日志,返回list集合
}
