package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * 用户评论
 * Created by Administrator on 2016/11/18.
 */
@Alias("Reply")
@Component("reply")
public class Reply {
    //基本属性
    private int id;
    private int parentid;               //父级id
    private String localtime;
    private String message;
    private int thumbsize;              //点赞数
    private int opposesize;             //反对数
    private int replysize;              //回复数

    //关联关系
    //1.和用户的关联关系：多对一
    private User user;
    //2.和书籍的关联关系：多对一
    private Book book;

    public Reply() {
    }

    public Reply(int id, String localtime, String message, int opposesize, int parentid, int replysize, int thumbsize) {
        this.id = id;
        this.localtime = localtime;
        this.message = message;
        this.opposesize = opposesize;
        this.parentid = parentid;
        this.replysize = replysize;
        this.thumbsize = thumbsize;
    }

    public Reply(Book book, int id, String localtime, String message, int opposesize, int parentid, int replysize, int thumbsize, User user) {
        this.book = book;
        this.id = id;
        this.localtime = localtime;
        this.message = message;
        this.opposesize = opposesize;
        this.parentid = parentid;
        this.replysize = replysize;
        this.thumbsize = thumbsize;
        this.user = user;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOpposesize() {
        return opposesize;
    }

    public void setOpposesize(int opposesize) {
        this.opposesize = opposesize;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getReplysize() {
        return replysize;
    }

    public void setReplysize(int replysize) {
        this.replysize = replysize;
    }

    public int getThumbsize() {
        return thumbsize;
    }

    public void setThumbsize(int thumbsize) {
        this.thumbsize = thumbsize;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
