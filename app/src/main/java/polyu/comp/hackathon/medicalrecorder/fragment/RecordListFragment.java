package polyu.comp.hackathon.medicalrecorder.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.quentindommerc.superlistview.OnMoreListener;
import com.quentindommerc.superlistview.SuperListview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.activity.RecordDetailActivity;
import polyu.comp.hackathon.medicalrecorder.adapter.RecordAdapter;
import polyu.comp.hackathon.medicalrecorder.domain.Record;
import polyu.comp.hackathon.medicalrecorder.service.ApiService;
import polyu.comp.hackathon.medicalrecorder.service.RecordResponse;
import polyu.comp.hackathon.medicalrecorder.utils.MyUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by liushanchen on 16/2/20.
 */
public class RecordListFragment extends Fragment {
    private SuperListview recordList;
    private RecordAdapter recordAdapter;
    LinearLayout headView;
    private static int myPage = 1;
    private static int recordCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.record_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListView();

    }


    private Void recordListApi(int page) {
//        Patient p = MyUtils.getPatient(getActivity());
        Map<String, String> options = new HashMap<String, String>();
        options.put("pId", MyUtils.getPatient(getActivity()).getpId() + "");
        options.put("page", page + "");
//            RecordRequest recordRequest = new RecordRequest("" + page, p.getpId());
        ApiService.Creator.create(getActivity().getApplication()).recordList(options, new Callback<RecordResponse>() {
            @Override
            public void success(RecordResponse recordResponse, Response response) {
                System.out.println("success:" + recordResponse.getCountItem());
                recordCount = Integer.parseInt(recordResponse.getCountItem());
                MyUtils.setRecordCount(getActivity(),recordCount+"");
                List<Record> record = recordResponse.getRecords();
                if (record != null) {

                    for (int i = 0; i < record.size(); i++) {
                        System.out.println("getDisease:" + i + "i:" + record.get(i).getDisease());
                    }
                    setListView(recordResponse.getRecords());
                }

            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("error:" + error);

            }
        });
        return null;
    }

    private void setListView(List<Record> records) {
//        recordAdapter = new RecordAdapter(records, getActivity());
        TextView hint = (TextView) headView.findViewById(R.id.item_inspection_name);
        recordAdapter.setMyList(records);
        recordList.setAdapter(recordAdapter);
        if(records.size()==0){
            MyUtils.show(getActivity(),"Do not have any Records.");
            hint.setText("Do not have any Records in your Record list.");
            
        }else{
            hint.setText("You have "+records.size()+" records");
        }
        
    }

    private void initListView() {
        getActivity().setTitle("Record List");
        /*ListView*/
        headView = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.inspection_item, null);
        recordList = (SuperListview) getActivity().findViewById(R.id.list);
        recordList.getList().addHeaderView(headView);
        recordAdapter = new RecordAdapter(getActivity().getApplication());
        recordList.setAdapter(recordAdapter);
        recordListApi(myPage);
//        shareList.hideMoreProgress();
//        shareList.hideProgress();
        recordList.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myPage = 1;
                recordListApi(myPage);
            }

        });
//        recordList.setupMoreListener(new OnMoreListener() {
//            @Override
//            public void onMoreAsked(int numberOfItems, int numberBeforeMore, int currentItemPos) {
//                if (myPage < pageCount) {
//                    myPage++;
//                    recordListApi(myPage);
//                }
//                recordList.hideMoreProgress();
//            }
//        }, 0);
        recordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                MyUtils.show(getActivity(), "position" + position);
                Record record = (Record) parent.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplication(), RecordDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("record", record);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
