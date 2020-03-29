package com.kang.service.user;

import com.kang.pojo.User;
import com.kang.pojo.UserDiary;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/26 10:29
 * @version: 1.0
 */
public interface UserService {
    int addDairy(UserDiary userDiary);
    List<UserDiary> queryAlldiary(String userId);    // 查询全部日志,返回list集合
    User userLogin(String account, String password); // 用户登录查询
    int checkAccount(String account);                // 检测是否注册过
    int register(User user);                         // 注册新用户
}
