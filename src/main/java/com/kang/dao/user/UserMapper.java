package com.kang.dao.user;

import com.kang.pojo.User;
import com.kang.pojo.UserDiary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> loadAllUser();                                                                               // 查询所有的用户
    int modifyUser(User user);
    List<String> loadModule(String id);                                                                     // 加载用户的权限
    int deleteUser(String id);                                                                              // 删除用户
    int addDairy(UserDiary dairy);                                                                          // 新增一个动态
    List<UserDiary> queryAlldiary(String userId);                                                           // 查询全部日志,返回list集合
    User userLogin(@Param("account") String account, @Param("password") String password);                   // 用户登录查询
    User userLoginById(String id);                                                                          // 通过用户的ID查询
    int checkAccount(String account);                                                                       // 检测账号
    int register(User user);                                                                                // 用户注册
    int deleteDiary(@Param("userId") String userId,@Param("diaryId") String diaryId);                       // 删除用户的日志
    int modifyUserNameById(@Param("userId") String id, @Param("userName") String name);                     // 通过用户的ID来修改用户的昵称
    int modifyUserIntroById(@Param("userId") String id, @Param("userIntro") String introduction);           // 通过用户的ID来修改用户的个性签名
    int modifyUserPasswordById(@Param("userId") String id, @Param("password") String password);             // 通过用户的ID来修改用户的密码
    int modifyUserEmailById(@Param("userId") String id, @Param("email") String email);                      // 通过用户的ID来修改用户的电子邮箱
    int modifyUserPhoneById(@Param("userId") String id, @Param("phoneNumber") String phoneNumber);          // 通过用户的ID来修改用户的电话号码
    int modifyUserAddressById(@Param("userId") String id, @Param("address") String address);                // 通过用户的ID来修改用户的地址
    int modifyUserSexById(@Param("userId") String id, @Param("sex") String sex);                            // 通过用户的ID来修改用户的性别
    int modifyUserSchoolById(@Param("userId") String id, @Param("voluntarySchool") String voluntarySchool); // 通过用户的ID来修改用户的院校
    int modifyUserBirthdayById(@Param("userId") String id, @Param("birthday") String birthday);             // 通过用户的ID来修改用户的出生日期
    int modifyUserPhotoById(@Param("userId") String id,@Param("photo") String url);                         // 通过用户的ID来修改用户的头像
}
