package com.kang.service.user;

import com.kang.pojo.User;
import com.kang.pojo.UserDiary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/26 10:29
 * @version: 1.0
 */
public interface UserService {
    List<User> loadAllUser();                                    // 查询所有的用户
    int addDairy(UserDiary userDiary);
    List<String> loadModule(String id);                                                                     // 加载用户的权限
    int modifyUser(String id,String name,String account,String password,String email,String phoneNumber,String address);    // 修改用户
    int deleteUser(String id);                                   // 删除用户
    List<UserDiary> queryAlldiary(String userId);                // 查询全部日志,返回list集合
    User userLogin(String account, String password);             // 用户登录查询
    User userLoginById(String id);                               // 通过用户的ID查询
    int checkAccount(String account);                            // 检测是否注册过
    int register(User user);                                     // 注册新用户
    int deleteDiary(String userId, String diaryId);              // 删除用户的日志
    int modifyUserNameById(String id,String name);               // 通过用户的ID来修改用户的昵称
    int modifyUserIntroById(String id,String introduction);      // 通过用户的ID来修改用户的个性签名
    int modifyUserPasswordById(String id,String password);       // 通过用户的ID来修改用户的密码
    int modifyUserEmailById(String id,String email);             // 通过用户的ID来修改用户的电子邮箱
    int modifyUserPhoneById(String id,String phoneNumber);       // 通过用户的ID来修改用户的电话号码
    int modifyUserAddressById(String id,String address);         // 通过用户的ID来修改用户的地址
    int modifyUserSexById(String id,String sex);                 // 通过用户的ID来修改用户的性别
    int modifyUserSchoolById(String id,String voluntarySchool);  // 通过用户的ID来修改用户的院校
    int modifyUserBirthdayById(String id,String birthday);       // 通过用户的ID来修改用户的出生日期
    int modifyUserPhotoById(String id,String url);               // 通过用户的ID来修改用户的头像
}
