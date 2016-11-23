package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/21.
 */
@Alias("Recommand")
@Component("recommand")
public class Recommand {
    private int id;
    private String localtime;
    private String reason;
    private int thumbsize;

    public Recommand(int id, String localtime, String reason, int thumbsize) {
        this.id = id;
        this.localtime = localtime;
        this.reason = reason;
        this.thumbsize = thumbsize;
    }

    public Recommand() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getThumbsize() {
        return thumbsize;
    }

    public void setThumbsize(int thumbsize) {
        this.thumbsize = thumbsize;
    }
}
