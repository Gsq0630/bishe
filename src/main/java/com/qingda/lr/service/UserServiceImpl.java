package com.qingda.lr.service;

import com.qingda.lr.entity.User;
import com.qingda.lr.mapper.UserMapper;
import com.qingda.lr.until.FileUploadGsq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int changeUserPass(User user) {
        return userMapper.changeUserPass(user);
    }

    @Override
    public String getUserPic(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user.getUserPic();
    }

    @Override
    public int changeUserData(User user, MultipartFile file) {
        int result = 0;
        try {
            user.setUserBirthday(getBirthday(user.getUserBirStr()));
            if (!file.isEmpty()){
                user.setUserPic(new FileUploadGsq().uploadToDisk(file));
            }
            result = userMapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    @Override
    public User getUserData(Integer userId) {
        if (userId == null || userId == 0){
            return null;
        }
        User user = userMapper.selectByPrimaryKey(userId);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if (user.getUserBirthday() != null){
            user.setUserBirStr(sdf.format(user.getUserBirthday()));
        }
        return user;
    }

    @Override
    public int login(User user) {
        User user1 = userMapper.login(user);
        return user1 == null ? 0 : user1.getUserId();
    }

    @Override
    public int insertUser(User user) {
        //通过随机数生成账号，赋值到user对象中
        int max = 10000000;
        int min = 1000000;
        Random random = new Random();
        int account = random.nextInt(max) % (max - min + 1) + min;
        user.setUserAccount(account);
        //设置默认头像
        user.setUserPic("images/userPic.png");
        //将日期字符串转成日期格式并赋值刀user对象中
        //将user在mapper层通过MyBatis插入数据库中
        try {
            user.setUserBirthday(getBirthday(user.getUserBirStr()));
            userMapper.insertSelective(user);
        } catch (Exception e) {
            e.printStackTrace();
            //若出现异常，如信息冲突等，则注册失败，返回账号为零
            account = 0;
        }
        return account;
    }

    private Date getBirthday(String birStr) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(birStr);
    }

    @Override
    public int updateHobby(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
