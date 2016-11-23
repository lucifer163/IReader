package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/22.
 */
@Alias("Chapter")
@Component("chapter")
public class Chapter {
    private int id;
    private int sort;
    private String name;
    private String content;
    private int vip;

    public Chapter() {
    }

    public Chapter( int id,int sort, String name, String content, int vip) {
        this.sort = sort;
        this.content = content;
        this.id = id;
        this.name = name;
        this.vip = vip;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }
}
