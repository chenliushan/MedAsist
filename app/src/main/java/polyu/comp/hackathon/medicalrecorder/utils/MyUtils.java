package polyu.comp.hackathon.medicalrecorder.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import polyu.comp.hackathon.medicalrecorder.R;
import polyu.comp.hackathon.medicalrecorder.constant.CommonConstant;
import polyu.comp.hackathon.medicalrecorder.domain.Patient;

/**
 * Created by liushanchen on 16/2/20.
 */
public class MyUtils {
    public static void show(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }

    public Date date(String dateTime) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            if (dateTime != null) {
                date = sdf.parse(dateTime);

                return date;
            }
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return null;
    }
    public static boolean setPatient(Context context, Patient patient) {
        SharedPreferences.Editor editor = context.getSharedPreferences(CommonConstant.preferenceName,0).edit();
        editor.putLong(CommonConstant.pId, patient.getpId());
        System.out.println("sp.set:" + patient.getPatientName());
        editor.putString(CommonConstant.patientName,patient.getPatientName() );
        editor.putString(CommonConstant.phone,patient.getPhone() );
        editor.putString(CommonConstant.password,patient.getPassword() );
        editor.putString(CommonConstant.gender,patient.getGender() );
        editor.putInt(CommonConstant.age,patient.getAge() );
        editor.putString(CommonConstant.blood,patient.getBlood() );
        editor.putString(CommonConstant.allergies,patient.getAllergies() );
        editor.putString(CommonConstant.address, patient.getAddress());
        return editor.commit();
    }
    public static boolean deletePatient(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(CommonConstant.preferenceName, 0).edit();
        editor.remove(CommonConstant.pId);
        editor.remove(CommonConstant.patientName);
        editor.remove(CommonConstant.phone);
        editor.remove(CommonConstant.password);
        editor.remove(CommonConstant.gender);
        editor.remove(CommonConstant.age);
        editor.remove(CommonConstant.blood);
        editor.remove(CommonConstant.allergies);
        editor.remove(CommonConstant.address);
        return editor.commit();
    }

    public static Patient getPatient(Context context) {
        SharedPreferences sp = context.getSharedPreferences(CommonConstant.preferenceName, 0);
//        SharedPreferences sp = getSharedPreferences(context);
        Patient user = new Patient();
            user.setpId(sp.getLong(CommonConstant.pId, -1));
        System.out.println("sp.getString(CommonConstant.patientName:" + sp.getString(CommonConstant.patientName, null));
            user.setPatientName(sp.getString(CommonConstant.patientName, null));
            user.setPhone(sp.getString(CommonConstant.phone, null));
            user.setPassword(sp.getString(CommonConstant.password, null));
            user.setGender(sp.getString(CommonConstant.gender, null));
            user.setAge(sp.getInt(CommonConstant.age, -1));
            user.setBlood(sp.getString(CommonConstant.blood, null));
            user.setAllergies(sp.getString(CommonConstant.allergies, null));
            user.setAddress(sp.getString(CommonConstant.address, null));

        return user;
    }

    public static boolean setRecordCount(Context context, String count) {
        SharedPreferences.Editor editor = context.getSharedPreferences(CommonConstant.preferenceName, 0).edit();
        editor.putString(CommonConstant.re_count, count);
        return editor.commit();
    }

    public static String getRecordCount(Context context) {
        SharedPreferences sp = context.getSharedPreferences(CommonConstant.preferenceName, 0);
        return sp.getString(CommonConstant.re_count,null);
         
    }
    /**
     * * 设置Listview的高度
     */

    public static void setListViewHeight(ListView listView, int headerFooter) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        if (listAdapter.getCount() >= headerFooter) {
            for (int i = 0; i < listAdapter.getCount(); i++) {
                View listItem = listAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
            listView.setLayoutParams(params);
        } else {
            listView.setVisibility(View.GONE);
        }

    }

//    public static boolean setUser(Context context, User user) {
//        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
//        editor.putString(KEY_USER_ID, user.getId());
//        editor.putString(KEY_MOBILE, user.getMobile());
//        editor.putString(KEY_NICKNAME, user.getNickname());
//        editor.putString(KEY_USER_TYPE, user.getUserType());
//        editor.putBoolean(KEY_ENABLED, user.getEnabled());
//        editor.putString(KEY_TOKEN, user.getToken());
//        editor.putString(KEY_AVATARS, user.getAvatarId());
//        return editor.commit();
//    }
//
//    public static boolean deleteUser(Context context) {
//        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
//        editor.remove(KEY_USER_ID);
//        editor.remove(KEY_MOBILE);
//        editor.remove(KEY_NICKNAME);
//        editor.remove(KEY_USER_TYPE);
//        editor.remove(KEY_ENABLED);
//        editor.remove(KEY_TOKEN);
//        editor.remove(KEY_AVATARS);
//        return editor.commit();
//    }
//
//    public static User getUser(Context context) {
//        SharedPreferences sp = getSharedPreferences(context);
//        User user = new User();
//        if (sp.getString(KEY_USER_ID, null) != null) {
//            user.setId(sp.getString(KEY_USER_ID, null));
//            user.setMobile(sp.getString(KEY_MOBILE, null));
//            user.setNickname(sp.getString(KEY_NICKNAME, null));
//            user.setUserType(sp.getString(KEY_USER_TYPE, null));
//            user.setEnabled(sp.getBoolean(KEY_ENABLED, false));
//            user.setToken(sp.getString(KEY_TOKEN, null));
//            user.setAvatarId(sp.getString(KEY_AVATARS, null));
//        } else {
////            Toast.makeText(context, KEY_USER_TYPE+":"+sp.getString(KEY_USER_TYPE_GUEST, null),Toast.LENGTH_SHORT).show();
//            user.setId(sp.getString(KEY_USER_ID_GUEST, null));
//            user.setMobile(sp.getString(KEY_MOBILE_GUEST, null));
//            user.setNickname(sp.getString(KEY_NICKNAME_GUEST, null));
//            user.setUserType(sp.getString(KEY_USER_TYPE_GUEST, null));
//            user.setEnabled(sp.getBoolean(KEY_ENABLED_GUEST, false));
//            user.setToken(sp.getString(KEY_TOKEN_GUEST, null));
//            user.setAvatarId(sp.getString(KEY_AVATARS_GUEST, null));
//        }
//
//        return user;
//    }
}
