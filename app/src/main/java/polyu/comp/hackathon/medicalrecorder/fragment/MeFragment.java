package polyu.comp.hackathon.medicalrecorder.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.activity.LoginActivity;
import polyu.comp.hackathon.medicalrecorder.activity.MainActivity;
import polyu.comp.hackathon.medicalrecorder.constant.CommonConstant;
import polyu.comp.hackathon.medicalrecorder.domain.Patient;
import polyu.comp.hackathon.medicalrecorder.utils.MyUtils;

/**
 * Created by liushanchen on 16/2/20.
 */
public class MeFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.me, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    private void initView() {
        getActivity().setTitle("About Me");
        
        TextView pName = (TextView) getActivity().findViewById(R.id.me_name);
        TextView pPid = (TextView) getActivity().findViewById(R.id.me_pid);

        TextView pPhone_lable = (TextView) getActivity().findViewById(R.id.label1);
        TextView pPhone = (TextView) getActivity().findViewById(R.id.content1);
        TextView pGender_lable = (TextView) getActivity().findViewById(R.id.label2);
        TextView pGender = (TextView) getActivity().findViewById(R.id.content2);
        TextView pAllergies_lable = (TextView) getActivity().findViewById(R.id.label3);
        TextView pAllergies = (TextView) getActivity().findViewById(R.id.content3);
        TextView pAddress_lable = (TextView) getActivity().findViewById(R.id.label4);
        TextView pAddress = (TextView) getActivity().findViewById(R.id.content4);

        TextView pRecord = (TextView) getActivity().findViewById(R.id.large_text1);
        TextView pRecord_label = (TextView) getActivity().findViewById(R.id.small_text1);
        TextView pAge = (TextView) getActivity().findViewById(R.id.large_text2);
        TextView pAge_label = (TextView) getActivity().findViewById(R.id.small_text2);
        TextView pBlood = (TextView) getActivity().findViewById(R.id.large_text3);
        TextView pBlood_label = (TextView) getActivity().findViewById(R.id.small_text3);


        Button editBtn = (Button) getActivity().findViewById(R.id.me_edit);
        Button logoutBtn = (Button) getActivity().findViewById(R.id.me_logout);

        editBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        
        pPhone_lable.setText(CommonConstant.phone);
        pAddress_lable.setText(CommonConstant.address);
        pGender_lable.setText(CommonConstant.gender);
        pAllergies_lable.setText(CommonConstant.allergies);
        pRecord_label.setText("Records");
        pAge_label.setText(CommonConstant.age);
        pBlood_label.setText(CommonConstant.blood);
        
        
        Patient patient=MyUtils.getPatient(getActivity());
        pPid.setText("ID:"+patient.getpId());
        System.out.println("patient.getPatientName()" + patient.getPatientName());
        pName.setText(patient.getPatientName());
        pPhone.setText(patient.getPhone());
        pGender.setText(patient.getGender());
        pAllergies.setText(patient.getAllergies());
        pAddress.setText(patient.getAddress());
        pRecord.setText(MyUtils.getRecordCount(getActivity()));
        int i=patient.getAge();
        pAge.setText(i+"");
        pBlood.setText(patient.getBlood());
        
        
    }
    


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.me_edit:
                intent.setClass(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.me_logout:
                MyUtils.deletePatient(getActivity());
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            default:
                break;

        }
    }
}

