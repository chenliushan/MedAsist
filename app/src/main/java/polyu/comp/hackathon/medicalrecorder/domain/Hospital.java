package polyu.comp.hackathon.medicalrecorder.domain;

/**
 * Created by liushanchen on 16/2/20.
 */
public class Hospital {
   private long hId;
    private String hospitalName;
    private  String 	description;

    public long gethId() {
        return hId;
    }

    public void sethId(long hId) {
        this.hId = hId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
