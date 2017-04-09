package com.rachel.mvpdemo.model;

import com.rachel.mvpdemo.bean.User;

/**
 * Created by zhengshaorui on 2017/4/9.
 */

public interface IUserModel {
    void saveUserData(User user);
    User readUserData(String name);
}
