package polyu.comp.hackathon.medicalrecorder.domain;

import java.util.Date;

/**
 * Created by liushanchen on 16/2/20.
 */
public class TimeTable {
    private long tId;
    private long dId;
    private long pId;
    private Date time;

    public long gettId() {
        return tId;
    }

    public void settId(long tId) {
        this.tId = tId;
    }

    public long getdId() {
        return dId;
    }

    public void setdId(long dId) {
        this.dId = dId;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
