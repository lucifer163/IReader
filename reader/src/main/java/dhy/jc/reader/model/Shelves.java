package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户自定义书架
 * Created by Administrator on 2016/11/21.
 */
@Alias("Shelves")
@Component("shelves")
public class Shelves {
    private int id;
    private String name;

    //1.书架与用户的关联关系：
    private User user;
    //2.书架与书籍的关联关系：
    private List<Book> books;

    public Shelves() {
    }

    public Shelves(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Shelves(List<Book> books, int id, String name, User user) {
        this.books = books;
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
