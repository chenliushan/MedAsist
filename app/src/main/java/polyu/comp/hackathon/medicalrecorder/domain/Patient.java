package polyu.comp.hackathon.medicalrecorder.domain;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by liushanchen on 16/2/20.
 */
public class Patient {
    private long pId=-1;
    private String patientName="name";
    private String phone;
    private String password;
    private String gender=""; //optional
    private int age=-1;
    private String blood=""; //optional
    private String allergies=""; //optional
    private String address=""; //optional

    public Patient( String phone, String password) {
        this.phone=phone;
        this.password = password;
    }

    public Patient(String patientName, String phone, String password) {
        this.patientName = patientName;
        this.phone = phone;
        this.password = password;
    }

    public Patient() {
    
        
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
