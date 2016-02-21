package polyu.comp.hackathon.medicalrecorder.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.domain.Inspection;
import polyu.comp.hackathon.medicalrecorder.domain.Record;
import polyu.comp.hackathon.medicalrecorder.service.ApiService;
import polyu.comp.hackathon.medicalrecorder.service.InspectionResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by liushanchen on 16/2/20.
 */
public class RecordDetailActivity extends Activity {
    Record record;
    //    InspectionAdapter inspectionAdapter;
//    ListView inspectionList;
    TextView in_name;
    TextView in_des;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.record_detail);

        Bundle bundle = getIntent().getExtras();
        record = (Record) bundle.getSerializable("record");

        initView();
    }

    private void initView() {
        setTitle("Record Details");
        TextView pPhone_lable = (TextView) findViewById(R.id.label1);
        TextView pPhone = (TextView) findViewById(R.id.content1);
        TextView pGender_lable = (TextView) findViewById(R.id.label2);
        TextView pGender = (TextView) findViewById(R.id.content2);
        TextView pAllergies_lable = (TextView) findViewById(R.id.label3);
        TextView pAllergies = (TextView) findViewById(R.id.content3);
        TextView pAddress_lable = (TextView) findViewById(R.id.label4);
        TextView pAddress = (TextView) findViewById(R.id.content4);
        TextView description = (TextView) findViewById(R.id.description);
         in_name = (TextView) findViewById(R.id.inspection_name);
         in_des = (TextView) findViewById(R.id.inspection_description);

//        inspectionList = (ListView) findViewById(R.id.inspection_listView);
//        inspectionAdapter = new InspectionAdapter(this);

        pPhone_lable.setText("Date");
        pGender_lable.setText("Hospital");
        pAllergies_lable.setText("Disease");
        pAddress_lable.setText("Doctor");

        pPhone.setText(record.getCreateAt());
        pGender.setText(record.getHospital());
        pAllergies.setText(record.getDisease());
        pAddress.setText(record.getdId() + "");

        description.setText(record.getDescription());

        inspectionApi(record.getrId() + "");
        System.out.println("getrId"+record.getrId());
    }

    private void inspectionApi(String rid) {
        Map<String, String> options = new HashMap<String, String>();
        options.put("rId", rid);
        ApiService.Creator.create(getApplication()).inspectionList(options, new Callback<InspectionResponse>() {

            @Override
            public void success(InspectionResponse inspectionResponse, Response response) {
                polyu.comp.hackathon.medicalrecorder.service.Error error = inspectionResponse.getError();
                System.out.println("error.get:" + error.getError());
                Inspection inspection = inspectionResponse.getInspection();
                if (inspection != null) {
//                    inspectionAdapter.setMyList(inspections);
//                    inspectionList.setAdapter(inspectionAdapter);
                    in_name.setText(inspection.getInspectionName());
                    in_des.setText(inspection.getDescription());
                } 
//                else {
                    System.out.println("inspections == null");
//                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
