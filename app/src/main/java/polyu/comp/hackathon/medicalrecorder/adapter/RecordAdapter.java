package polyu.comp.hackathon.medicalrecorder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.domain.Record;

/**
 * Created by liushanchen on 16/2/20.
 */
public class RecordAdapter extends BaseAdapter {
    List<Record> myList=null;
    Context context;
    LayoutInflater layoutInflater;

    public RecordAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public RecordAdapter(List<Record> myList, Context context) {
        this.myList = myList;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public List<Record> getMyList() {
        return myList;
    }

    public void setMyList(List<Record> myList) {
        this.myList = myList;
    }

    @Override
    public int getCount() {
        if(myList!=null){
            return myList.size();
        }else{
            return 0;
        }
    }


    @Override
    public Record getItem(int position) {
//        return null;
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
//        return 0;
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Record item = getItem(position);
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.record_item, parent, false);
        }
        TextView item_date=(TextView)view.findViewById(R.id.item_date);
        TextView disease=(TextView)view.findViewById(R.id.disease);
        TextView hospital=(TextView)view.findViewById(R.id.hospital);
//        item_date.setText(position+":");
        item_date.setText(item.getCreateAt());
        disease.setText(item.getDisease());
        hospital.setText(item.getHospital());
        return view;
    }
}
