package com.rachel.mvpdemo.view;

/**
 * Created by zhengshaorui on 2017/4/9.
 */

public interface IUserView {

    void setUserName(String userName);
    void setPassword(String password);
    void error(String errormsg);
}
