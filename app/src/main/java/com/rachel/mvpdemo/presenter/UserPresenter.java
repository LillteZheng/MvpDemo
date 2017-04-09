package com.rachel.mvpdemo.presenter;

import com.rachel.mvpdemo.bean.User;
import com.rachel.mvpdemo.bean.lg;
import com.rachel.mvpdemo.model.IUserModel;
import com.rachel.mvpdemo.model.UserModel;
import com.rachel.mvpdemo.view.IUserView;

/**
 * Created by zhengshaorui on 2017/4/9.
 */

public class UserPresenter {

    private IUserView mIUserView;
    private IUserModel mIUserModel;

    public UserPresenter(IUserView mIUserView) {
        this.mIUserView = mIUserView;
        mIUserModel = new UserModel();
    }

    /**
     * 数据保存
     * @param user
     */
    public void saveUser(User user){

        mIUserModel.saveUserData(user);
    }

    /**
     * 读取数据
     * @param name
     */
    public void readUser(String name){
        User user =  mIUserModel.readUserData(name);
        lg.d("getread: "+user);
        if (user != null) {
            mIUserView.setUserName(user.getUsername());
            mIUserView.setPassword(user.getPassword());
        }else{
            mIUserView.error("没有找到");
        }
    }
}
