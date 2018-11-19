package com.phongtoanhuu.hhh.imicmo3.Views.RegisterUserActivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.phongtoanhuu.hhh.imicmo3.Presenters.RegisterUserActivityPresenter;
import com.phongtoanhuu.hhh.imicmo3.R;

public class RegisterUserActivity extends AppCompatActivity implements CallBackRegisterUserActivity {
    private EditText user_register,
            pass_register,
            email_register,
            fullname_register,
            mobile_register;

    private Button register_btn;
    private RegisterUserActivityPresenter registerUserActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        user_register = findViewById(R.id.user_register);
        pass_register = findViewById(R.id.pass_register);
        email_register = findViewById(R.id.email_register);
        fullname_register = findViewById(R.id.fullname_register);
        mobile_register = findViewById(R.id.mobile_register);
        register_btn = findViewById(R.id.register_btn);
        registerUserActivityPresenter = new RegisterUserActivityPresenter(this);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user_register.getText().toString();
                String pass = pass_register.getText().toString();
                String email = email_register.getText().toString();
                String fullname = fullname_register.getText().toString();
                String mobile = mobile_register.getText().toString();
                if (user.isEmpty()) {
                    user_register.setHint("Vui lòng nhập user");
                    user_register.setHintTextColor(Color.RED);
                    Toast.makeText(RegisterUserActivity.this, "Vui lòng nhập vào user", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.isEmpty()) {
                        pass_register.setHint("Vui lòng nhập password");
                        pass_register.setHintTextColor(Color.RED);
                        Toast.makeText(RegisterUserActivity.this, "Vui lòng nhập vào password", Toast.LENGTH_SHORT).show();
                    } else {
                        if (email.isEmpty()) {
                            email_register.setHint("Vui lòng nhập email");
                            email_register.setHintTextColor(Color.RED);
                            Toast.makeText(RegisterUserActivity.this, "Vui lòng nhập vào email", Toast.LENGTH_SHORT).show();
                        } else {
                    registerUserActivityPresenter.registerUser(user,pass,email,fullname,mobile);
                        }
                    }
                }

            }
        });
    }

    @Override
    public void registerUserThanhCong(String sThanhCong) {
       Toast.makeText(this,sThanhCong,Toast.LENGTH_SHORT).show();
       finish();
    }

    @Override
    public void registerUserThatBai(String sThongBao) {
        Toast.makeText(this,sThongBao,Toast.LENGTH_SHORT).show();
    }
}
