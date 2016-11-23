package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户实体类
 * Created by Administrator on 2016/11/18.
 */
@Alias("User")
@Component("user")
public class User {
    //基本属性
    private int id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private int type;           //用户种类
    private String qq;
    private String wechat;
    private int bookage;
    private int gender;

    //关联关系：
    //1.和收藏书籍的关联关系：多对多
    private List<Book> storeBooks;
    //2.和推荐书籍的关联关系：多对多
    private List<Book> RecommandBooks;
    //3.和书评的关联关系：1对多
    private List<Reply> replys;
    //4.自定义书架的关联关系：
    private List<Shelves> shelves;

    public User() {
    }

    public User(int bookage, String email, int gender, int id, String mobile, String password, String qq, int type, String username, String wechat) {
        this.bookage = bookage;
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.qq = qq;
        this.type = type;
        this.username = username;
        this.wechat = wechat;
    }

    public User(int bookage, String email, int gender, int id, String mobile, String password, String qq, List<Book> recommandBooks, List<Reply> replys, List<Book> storeBooks, int type, String username, String wechat, List<Shelves> shelves) {
        this.bookage = bookage;
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.qq = qq;
        this.RecommandBooks = recommandBooks;
        this.replys = replys;
        this.storeBooks = storeBooks;
        this.type = type;
        this.username = username;
        this.wechat = wechat;
        this.shelves = shelves;
    }

    public int getBookage() {
        return bookage;
    }

    public void setBookage(int bookage) {
        this.bookage = bookage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public List<Book> getRecommandBooks() {
        return RecommandBooks;
    }

    public void setRecommandBooks(List<Book> recommandBooks) {
        RecommandBooks = recommandBooks;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }

    public List<Book> getStoreBooks() {
        return storeBooks;
    }

    public void setStoreBooks(List<Book> storeBooks) {
        this.storeBooks = storeBooks;
    }

    public List<Shelves> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelves> shelves) {
        this.shelves = shelves;
    }
}
