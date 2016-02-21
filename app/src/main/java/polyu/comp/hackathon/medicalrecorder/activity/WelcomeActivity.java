package polyu.comp.hackathon.medicalrecorder.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.domain.Patient;
import polyu.comp.hackathon.medicalrecorder.utils.MyUtils;

/**
 * Created by liushanchen on 16/2/20.
 */
public class WelcomeActivity extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.welcome);
        setTitle("WELCOME");
        final Patient patient= MyUtils.getPatient(getApplication());
        
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                
                Intent intent = new Intent();
                
                System.out.print("pid"+patient.getpId());
                if(patient.getpId()>0){
                    intent.setClass(WelcomeActivity.this, MainActivity.class);
                }else{
                    intent.setClass(WelcomeActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }.start();
    }
}
