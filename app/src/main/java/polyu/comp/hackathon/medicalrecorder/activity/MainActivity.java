package polyu.comp.hackathon.medicalrecorder.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.fragment.MeFragment;
import polyu.comp.hackathon.medicalrecorder.fragment.RecordListFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        actionBar.setCustomView(R.layout.actionbar);
//        TextView titleTextView = (TextView) findViewById(R.id.title);
//        titleTextView.setText(R.string.hospital_info);
        
        RecordListFragment recordListFragment = new RecordListFragment();
        //要用getSupportFragmentManager，而不是getFragmentManager
        getFragmentManager().beginTransaction().add(R.id.activity_main, recordListFragment).commit();

        ImageView recordBtn = (ImageView) findViewById(R.id.record_imageView);
        ImageView meBtn = (ImageView) findViewById(R.id.me_imageView);
        recordBtn.setOnClickListener(this);
        meBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_imageView:
                MeFragment meFragment = new MeFragment();
                getFragmentManager().beginTransaction().replace(R.id.activity_main, meFragment).commit();
//                Intent intent=new Intent(getActivity(),SecondActivity.class);
//                intent.putExtra("user_input",userInput);
//                startActivity(intent);
                break;
            case R.id.record_imageView:
                RecordListFragment recordListFragment = new RecordListFragment();
//                Bundle bundle=new Bundle();
//                bundle.putString("user_input", userInput);
//                secondFragment.setArguments(bundle);
                //如果这里用remove，两个界面还看得见，但是点击会出现空指针
                //如果只用replace，两个界面还看得见，也还有作用，点击后新的fragment2会替换以前的fragment2
                //如果用add，两个界面和以前的界面都全都看得见，点击不断的添加fragment

//                getActivity().getSupportFragmentManager().beginTransaction().hide(this).commit();//会隐藏包括要添加的fragment
                getFragmentManager().beginTransaction().replace(R.id.activity_main, recordListFragment).commit();
                break;
            default:
                break;

        }
    }
}
