package polyu.comp.hackathon.medicalrecorder.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.domain.Patient;
import polyu.comp.hackathon.medicalrecorder.service.ApiService;
import polyu.comp.hackathon.medicalrecorder.service.LoginResponse;
import polyu.comp.hackathon.medicalrecorder.utils.MyUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by liushanchen on 16/2/20.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    EditText phone;
    EditText psw;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.login);

        initView();
    }

    private void initView() {
        phone = (EditText) findViewById(R.id.login_phone_edit);
        psw = (EditText) findViewById(R.id.login_password_edit);
        Button loginBtn = (Button) findViewById(R.id.login_btn);
        Button registerBtn = (Button) findViewById(R.id.register_btn);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                loginApi(phone.getText().toString(), psw.getText().toString());
                break;
            case R.id.register_btn:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }

    private void loginApi(String phone, String psw) {
        Map<String, String> options = new HashMap<String, String>();
        options.put("phone", phone);
        options.put("password", psw);
        ApiService.Creator.create(getApplication()).getTest(options, new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                Patient p = loginResponse.getPatient();
                polyu.comp.hackathon.medicalrecorder.service.Error error = loginResponse.getError();
                System.out.println("re_success,error:" + error.getError());
                System.out.println("pid:" + p.getpId());
                System.out.println("getPatientName:" + p.getPatientName());

                if (error.getError() == null || error.getError().equals("null")) {
                    MyUtils.setPatient(getApplication(), p);
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    MyUtils.show(getApplication(), error.getError());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("error:" + error);
            }
        });

    }
}
