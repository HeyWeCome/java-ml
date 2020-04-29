package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.User;
import com.kang.pojo.UserDiary;
import com.kang.service.user.UserService;
import com.kang.service.user.UserServiceImpl;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 用户的控制类
 * @author: HeyWeCome
 * @createDate: 2020/3/25 21:45
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService =  new UserServiceImpl();

    // 修改用户的信息
    @RequestMapping(value = "/modifyUser",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUser(String id,String name,String account, String password, String email, String phoneNumber, String address){
        return JSONObject.toJSONString(userService.modifyUser(id,name,account,password,email,phoneNumber,address));
    }

    // 删除用户
    @RequestMapping(value = "/deleteUser",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteUser(String id){
        return JSONObject.toJSONString(userService.deleteUser(id));
    }

    // 用户登录
    @RequestMapping(value = "/userLogin",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String userLogin(String account,String password){
        User user = userService.userLogin(account, password);

        if(user != null){
            System.out.println(user.toString());
            return JSONObject.toJSONString(user);
        }else{
            // 查不到就给个0
            return "0";
        }
    }

    // 用户登录
    @RequestMapping(value = "/userLoginById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String userLoginById(String id){
        User user = userService.userLoginById(id);

        if(user != null){
            System.out.println(user.toString());
            return JSONObject.toJSONString(user);
        }else{
            // 查不到就给个0
            System.out.println("0");
            return "0";
        }
    }

    // 用户注册
    @RequestMapping(value = "/register",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String register(String account,String password,String name){
        User user = new User();
        // 设置ID,内置UUID
        user.setId();
        user.setAccount(account);
        user.setPassword(password);
        user.setName(name);
        user.setCreateTime();

        return JSONObject.toJSONString(userService.register(user));
    }

    // 检测用户账号是否存在
    @RequestMapping(value = "/checkAccount",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkAccount(String account){
        // 返回0没注册，返回1注册过了
        return JSONObject.toJSONString(userService.checkAccount(account));
    }

    // 通过用户的ID来修改用户的昵称
    @RequestMapping(value = "/modifyUserName",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserNameById(String id,String name){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserNameById(id,name));
    }

    // 通过用户的ID来修改用户的个性签名
    @RequestMapping(value = "/modifyUserIntro",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserIntroById(String id,String introduction){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserIntroById(id,introduction));
    }

    // 通过用户的ID来修改用户的密码
    @RequestMapping(value = "/modifyUserPassword",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserPassword(String id,String password){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserPasswordById(id,password));
    }

    // 通过用户的ID来修改用户的电子邮箱
    @RequestMapping(value = "/modifyUserEmail",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserEmail(String id,String email){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserEmailById(id,email));
    }

    // 通过用户的ID来修改用户的手机号码
    @RequestMapping(value = "/modifyUserPhone",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserPhone(String id,String phoneNumber){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserPhoneById(id,phoneNumber));
    }

    // 通过用户的ID来修改用户的性别
    @RequestMapping(value = "/modifyUserSex",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserSex(String id,String sex){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserSexById(id,sex));
    }

    // 通过用户的ID来修改用户的地址
    @RequestMapping(value = "/modifyUserAddress",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserAddress(String id,String address){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserAddressById(id,address));
    }

    // 通过用户的ID来修改用户的志愿学校
    @RequestMapping(value = "/modifyUserSchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserSchool(String id,String voluntarySchool){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserSchoolById(id,voluntarySchool));
    }

    // 通过用户的ID来修改用户的出生日期
    @RequestMapping(value = "/modifyUserBirthDay",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyUserBirthDay(String id,String birthday){
        // 返回1修改成功，返回0修改失败
        return JSONObject.toJSONString(userService.modifyUserBirthdayById(id,birthday));
    }

    // 发布用户的个人日志
    @RequestMapping(value = "/postDairy",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postDairy(String userId,String content){
        // UUID生成ID,同时去掉"-"
        String id = UUID.randomUUID().toString().replace("-","");
        //设置日期格式 并转化为字符串
        SimpleDateFormat datetime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String createTime = datetime.format((new Date()));

        UserDiary userDiary = new UserDiary(id,userId,content,createTime);

        // 执行新增日志的操作
        userService.addDairy(userDiary);

        return JSONObject.toJSONString(userDiary.getId());
    }

    // 加载用户的个人日志
    @RequestMapping(value = "/loadDairy",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadDairy(String userId){
        List<UserDiary> userDiaries = userService.queryAlldiary(userId);

        return JSONObject.toJSONString(userDiaries);
    }

    // 删除用户的个人日志
    @RequestMapping(value = "/deleteDiary",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteDiary(String userId,String diaryId){
        // 返回1成功，返回0删除失败
        return JSONObject.toJSONString(userService.deleteDiary(userId,diaryId));
    }

    // 上传头像
    @RequestMapping(value ="/uploadHead",method = RequestMethod.POST)
    public String addUser(HttpServletRequest req,String userId, MultipartFile pictureFile) throws Exception{
        System.out.println("上传进来了");
        System.out.println("用户ID："+userId);
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        System.out.println("文件拓展名："+ext);

        //设置图片上传路径
        String url = "E:/Workspace/IDEAWorkspace/wecode/web/upload/photo";
        System.out.println("保存路径"+url);

        //以绝对路径保存重名命后的图片
        pictureFile.transferTo(new File(url+"/"+name + "." + ext));

        //把图片存储路径保存到数据库
        String relativeUrl ="upload/photo/"+name + "." + ext;

        userService.modifyUserPhotoById(userId,relativeUrl);

//        user.setImageURL("upload/"+name + "." + ext);
//
//        userService.addUser(user);
//        //重定向到查询所有用户的Controller，测试图片回显
        return "redirect:/profile.html";
    }


    // 查询所有的用户
    @RequestMapping(value = "/loadAllUser",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllUser(){
        return JSONObject.toJSONString(userService.loadAllUser());
    }
}
