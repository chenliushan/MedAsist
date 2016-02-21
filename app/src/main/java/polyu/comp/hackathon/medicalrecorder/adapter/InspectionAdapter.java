package polyu.comp.hackathon.medicalrecorder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.domain.Inspection;
import polyu.comp.hackathon.medicalrecorder.domain.Record;

/**
 * Created by liushanchen on 16/2/20.
 */
public class InspectionAdapter extends BaseAdapter {
    List<Inspection> myList=null;
    Context context;
    LayoutInflater layoutInflater;

    public InspectionAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public InspectionAdapter(List<Inspection> myList, Context context) {
        this.myList = myList;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public List<Inspection> getMyList() {
        return myList;
    }

    public void setMyList(List<Inspection> myList) {
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
    public Inspection getItem(int position) {
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
        Inspection item = getItem(position);
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.inspection_item, parent, false);
        }
        TextView item_name=(TextView)view.findViewById(R.id.item_inspection_name);
        item_name.setText(item.getInspectionName());
        
        return view;
    }
}
