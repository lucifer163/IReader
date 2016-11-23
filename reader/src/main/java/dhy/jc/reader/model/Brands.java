package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 书籍标签
 * Created by Administrator on 2016/11/18.
 */
@Alias("Brands")
@Component("brands")
public class Brands {
    private int id;
    private String name;

    private List<Book> books;

    public Brands() {
    }

    public Brands(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brands(List<Book> books, int id, String name) {
        this.books = books;
        this.id = id;
        this.name = name;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
