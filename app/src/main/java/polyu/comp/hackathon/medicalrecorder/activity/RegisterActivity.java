package polyu.comp.hackathon.medicalrecorder.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
public class RegisterActivity extends Activity implements View.OnClickListener {
    private EditText phone;
    private EditText name;
    private EditText psw;
    private EditText rePsw;
    private EditText age;
    private EditText blood;
    private EditText allergies;
    private EditText address;

    private RadioGroup gender;
    private String gender_s;
//    private RadioButton female;
//    private RadioButton male;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.register);
        initView();
    }

    private void initView() {
        phone = (EditText) findViewById(R.id.r_phone);
        name = (EditText) findViewById(R.id.r_name);
        psw = (EditText) findViewById(R.id.r_password);
        rePsw = (EditText) findViewById(R.id.r_r_password);
        age = (EditText) findViewById(R.id.r_r_age);
        blood = (EditText) findViewById(R.id.r_blood);
        allergies = (EditText) findViewById(R.id.r_allergies);
        address = (EditText) findViewById(R.id.r_address);

        gender = (RadioGroup) findViewById(R.id.radiogroup);
//        female = (RadioButton) findViewById(R.id.female);
//        male = (RadioButton) findViewById(R.id.male);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.female) {
                    gender_s="female";
                } else if (checkedId == R.id.male) {
                    gender_s="male";
                }
            }
        });
        Button submitBtn = (Button) findViewById(R.id.r_submit);
        submitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.r_submit:
                if(Integer.parseInt(age.getText().toString())<0){
                    age.requestFocus();
                } else if (!psw.getText().toString().equals(rePsw.getText().toString())) {
                    psw.requestFocus();
                    MyUtils.show(this, "Password do not match.");
                } else {
                    registerApi(phone.getText().toString(), psw.getText().toString(), name.getText().toString(), age.getText().toString()
                   , blood.getText().toString(),allergies.getText().toString(),address.getText().toString());
                }
                break;

            default:
                break;

        }
    }

    private void registerApi(String phone, String psw, String name, String age,String blood,String allergies,String address) {
        Map<String, String> options = new HashMap<String, String>();
        options.put("phone", phone);
        options.put("password", psw);
        options.put("patientName", name);
        options.put("age", age);
        options.put("blood", blood);
        options.put("allergies", allergies);
        options.put("address", address);
        options.put("gender", gender_s);
        ApiService.Creator.create(getApplication()).patientRegister(options, new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                Patient p = loginResponse.getPatient();
                polyu.comp.hackathon.medicalrecorder.service.Error error = loginResponse.getError();
                System.out.println("re_success,error:" + error.getError());
                System.out.println("pid:" + p.getpId());
                System.out.println("pid:" + p.getpId());

                if (error.getError() == null || error.getError().equals("null")) {
                    MyUtils.setPatient(getApplication(), p);
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    MyUtils.show(getApplication(),error.getError());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("error:" + error);
            }
        });

//        Patient patient = new Patient(name, phone, psw);
//        Patient patient = new Patient(phone, psw);
//        ApiService.Creator.create(getApplication()).patientRegister(patient, new Callback<LoginResponse>() {
//            @Override
//            public void success(LoginResponse loginResponse, Response response) {
//                Patient p=loginResponse.getPatient();
//                polyu.comp.hackathon.medicalrecorder.service.Error error=loginResponse.getError();
//                System.out.println("re_success,error:" + error.getError());
//                System.out.println("re_pid:" + p.getpId());
//                System.out.println("re_name:" + p.getPatientName());
//
//                if (error.getError() == null || error.getError() .equals("null")) {
//                    MyUtils.setPatient(getApplication(), p);
//                    Intent intent = new Intent();
//                    intent.setClass(RegisterActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else {
//                    MyUtils.show(RegisterActivity.this,error.getError());
//                }
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                System.out.println("error:" + error);
//            }
//        });


    }
}
