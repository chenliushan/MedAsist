package polyu.comp.hackathon.medicalrecorder.domain;

/**
 * Created by liushanchen on 16/2/20.
 */
public class Inspection {
    private String iId;
    private String rId;
    private String inspectionName;
    private String description;

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getInspectionName() {
        return inspectionName;
    }

    public void setInspectionName(String inspectionName) {
        this.inspectionName = inspectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
