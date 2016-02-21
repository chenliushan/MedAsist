package polyu.comp.hackathon.medicalrecorder.service;

/**
 * Created by liushanchen on 16/2/20.
 */
public class RecordRequest {
    private Long pid;
    private String page;

    public RecordRequest(String page, Long pid) {
        this.page = page;
        this.pid = pid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
