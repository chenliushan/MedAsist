package polyu.comp.hackathon.medicalrecorder.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liushanchen on 16/2/20.
 */
public class Record implements Serializable {
    private long rId;
    private String dId;
    private String pId;
//    private Doctor doctor;
    private String disease;
    private String description;
    private String hospital;
    private String createAt;
    private String level;

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getLevel() {
        return level;
    }
}

