package com.kang.dao.user;

import com.kang.pojo.User;
import com.kang.pojo.UserDiary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int addDairy(UserDiary dairy);                      // 新增一个动态
    List<UserDiary> queryAlldiary(String userId);       // 查询全部日志,返回list集合
    User userLogin(@Param("account") String account, @Param("password") String password);    // 用户登录查询
}
