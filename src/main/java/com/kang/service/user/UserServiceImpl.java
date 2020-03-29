package com.kang.service.user;

import com.kang.dao.provincial.ProvincialMapper;
import com.kang.dao.user.UserMapper;
import com.kang.pojo.Provincial;
import com.kang.pojo.User;
import com.kang.pojo.UserDiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/26 10:30
 * @version: 1.0
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper(){
        return userMapper;
    }

    public int addDairy(UserDiary userDiary) {
        return userMapper.addDairy(userDiary);
    }

    public List<UserDiary> queryAlldiary(String userId) {
        return userMapper.queryAlldiary(userId);
    }

    public User userLogin(String account, String password) {
        return userMapper.userLogin(account,password);
    }

    public int checkAccount(String account) {
        return userMapper.checkAccount(account);
    }

    public int register(User user) {
        return userMapper.register(user);
    }
}
