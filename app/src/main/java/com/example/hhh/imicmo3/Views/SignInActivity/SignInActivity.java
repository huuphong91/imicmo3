package com.example.hhh.imicmo3.Views.SignInActivity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hhh.imicmo3.Entities.AccountEntity;
import com.example.hhh.imicmo3.Presenters.SignInActivityPresenter;
import com.example.hhh.imicmo3.R;
import com.example.hhh.imicmo3.Utilities.Commons;
import com.example.hhh.imicmo3.Views.RegisterUserActivity.RegisterUserActivity;

public class SignInActivity extends AppCompatActivity implements CallBackSignInActivity{
    private Button dang_ky_Btn,dang_nhap_Btn;
    private SignInActivityPresenter signInActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        final TextInputEditText user_Txt = findViewById(R.id.user_Txt);
        final TextInputEditText pass_Txt = findViewById(R.id.pass_Txt);
        dang_ky_Btn = findViewById(R.id.dang_ky_Btn);
        dang_nhap_Btn = findViewById(R.id.dang_nhap_Btn);
        signInActivityPresenter = new SignInActivityPresenter(this);

        dang_nhap_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_Txt.getText().toString();
                String password = pass_Txt.getText().toString();
                signInActivityPresenter.getApiUserInfo(username,password);

            }
        });

        dang_ky_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, RegisterUserActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void getApiUserInFoThanhCong(AccountEntity accountEntity) {
        Intent intent = new Intent();
        intent.putExtra("Account", accountEntity);
        setResult(RESULT_OK, intent);
        Commons.checkLogin = true;
        Commons.PROFILEID = accountEntity.getProfileId();
        finish();

    }

    @Override
    public void getApiUserInFoThatBai(String sThongBao) {
        Toast.makeText(SignInActivity.this,sThongBao,Toast.LENGTH_SHORT).show();
    }
}
