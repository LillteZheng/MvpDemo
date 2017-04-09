package com.rachel.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rachel.mvpdemo.bean.User;
import com.rachel.mvpdemo.presenter.UserPresenter;
import com.rachel.mvpdemo.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView{


    private EditText mUserEditText,mPassEditText,mReadEditText;
    private UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserEditText = (EditText) findViewById(R.id.edit1);
        mPassEditText = (EditText) findViewById(R.id.edit2);
        mReadEditText = (EditText) findViewById(R.id.edit3);

        mUserPresenter = new UserPresenter(this);
    }

    //保存
    public void save(View view){
        User user = new User();
        user.setUsername(mUserEditText.getText().toString());
        user.setPassword(mPassEditText.getText().toString());
        mUserPresenter.saveUser(user);
    }
    //清空 edittext
    public void clear(View view){
        mUserEditText.setText("");
        mPassEditText.setText("");
    }
    //读数据
    public void read(View view){
        mUserPresenter.readUser(mReadEditText.getText().toString());
    }



    @Override
    public void setUserName(String userName) {
        mUserEditText.setText(userName);
    }

    @Override
    public void setPassword(String password) {
        mPassEditText.setText(password);
    }

    @Override
    public void error(String errormsg) {
        Toast.makeText(this, errormsg, Toast.LENGTH_SHORT).show();
    }
}
