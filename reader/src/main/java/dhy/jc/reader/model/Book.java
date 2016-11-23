package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 书籍实体类
 * Created by Administrator on 2016/11/18.
 */
@Alias("Book")
@Component("book")
public class Book {
    private int id;
    private String logo;
    private String bookname;
    private String author;
    private String wordsize;
    private int chaptersize;
    private int updated;
    private int reply;
    private int store;              //被收藏数
    private String item;
    private String url;

    //1.和用户的收藏关系：多对多
    private List<User> storeUsers;
    //2.和书籍标签的关联关系：多对多
    private List<Brands> brandses;
    //3.和书评的关联关系：多对1
    private List<Reply> repliys;
    //4.和推荐书籍的关联关系：1对多
    private List<Recommand> recommands;
    //5.和章节的关联关系
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(String author, String bookname, String item) {
        this.author = author;
        this.bookname = bookname;
        this.item = item;
    }

    public Book(String logo, String author, String bookname, int chaptersize, int id, String item, int reply, int store, int updated, String wordsize) {
        this.author = author;
        this.logo = logo;
        this.bookname = bookname;
        this.chaptersize = chaptersize;
        this.id = id;
        this.item = item;
        this.reply = reply;
        this.store = store;
        this.updated = updated;
        this.wordsize = wordsize;
    }

    public Book(String url, String logo, String author, String bookname, List<Brands> brandses, int chaptersize, int id, String item, List<Recommand> recommands, List<Reply> repliys, int reply, int store, List<User> storeUsers, int updated, String wordsize, List<Chapter> chapters) {
        this.author = author;
        this.logo = logo;
        this.bookname = bookname;
        this.brandses = brandses;
        this.chaptersize = chaptersize;
        this.id = id;
        this.item = item;
        this.recommands = recommands;
        this.repliys = repliys;
        this.reply = reply;
        this.store = store;
        this.storeUsers = storeUsers;
        this.updated = updated;
        this.wordsize = wordsize;
        this.chapters = chapters;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getChaptersize() {
        return chaptersize;
    }

    public void setChaptersize(int chaptersize) {
        this.chaptersize = chaptersize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public String getWordsize() {
        return wordsize;
    }

    public void setWordsize(String wordsize) {
        this.wordsize = wordsize;
    }

    public List<Brands> getBrandses() {
        return brandses;
    }

    public void setBrandses(List<Brands> brandses) {
        this.brandses = brandses;
    }

    public List<Recommand> getRecommands() {
        return recommands;
    }

    public void setRecommands(List<Recommand> recommands) {
        this.recommands = recommands;
    }

    public List<Reply> getRepliys() {
        return repliys;
    }

    public void setRepliys(List<Reply> repliys) {
        this.repliys = repliys;
    }

    public List<User> getStoreUsers() {
        return storeUsers;
    }

    public void setStoreUsers(List<User> storeUsers) {
        this.storeUsers = storeUsers;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
