package com.rachel.mvpdemo.model;

import com.rachel.mvpdemo.bean.User;
import com.rachel.mvpdemo.bean.lg;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by zhengshaorui on 2017/4/9.
 */

public class UserModel implements IUserModel {
    public UserModel() {

    }
    /**
     * 使用Litepal保存数据
     * @return
     */
    @Override
    public void saveUserData(User user) {
        user.save();
        lg.d("user: "+user);
    }

    /**
     * 通过 name从数据库读取数据
     * @param name
     * @return
     */
    @Override
    public User readUserData(String name) {
        List<User> userList = DataSupport.where("username = ?",name).find(User.class);

        if (userList.size() > 0)
            return userList.get(0);
        return null;
    }
}
