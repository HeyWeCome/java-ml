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

    public List<User> loadAllUser() {
        return userMapper.loadAllUser();
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

    public User userLoginById(String id) {
        return userMapper.userLoginById(id);
    }

    public int checkAccount(String account) {
        return userMapper.checkAccount(account);
    }

    public int register(User user) {
        return userMapper.register(user);
    }

    public int deleteDiary(String userId, String diaryId) {
        return userMapper.deleteDiary(userId,diaryId);
    }

    public int modifyUserNameById(String id, String name) {
        return userMapper.modifyUserNameById(id,name);
    }

    public int modifyUserIntroById(String id, String introduction) {
        return userMapper.modifyUserIntroById(id,introduction);
    }

    public int modifyUserPasswordById(String id, String password) {
        return userMapper.modifyUserPasswordById(id,password);
    }

    public int modifyUserEmailById(String id, String email) {
        return userMapper.modifyUserEmailById(id,email);
    }

    public int modifyUserPhoneById(String id, String phoneNumber) {
        return userMapper.modifyUserPhoneById(id,phoneNumber);
    }

    public int modifyUserAddressById(String id, String address) {
        return userMapper.modifyUserAddressById(id,address);
    }

    public int modifyUserSexById(String id, String sex) {
        return userMapper.modifyUserSexById(id,sex);
    }

    public int modifyUserSchoolById(String id, String voluntarySchool) {
        return userMapper.modifyUserSchoolById(id,voluntarySchool);
    }

    public int modifyUserBirthdayById(String id, String birthday) {
        return userMapper.modifyUserBirthdayById(id,birthday);
    }

    public int modifyUserPhotoById(String id, String url) {
        // url存储的是用户的头像地址
        // id 存储的是用户的ID
        return userMapper.modifyUserPhotoById(id,url);
    }
}
