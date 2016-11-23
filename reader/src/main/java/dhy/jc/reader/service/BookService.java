package dhy.jc.reader.service;

import dhy.jc.reader.model.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface BookService extends BaseService<Book> {

    /**
     * 获取包含书籍标签的书籍集合
     *
     * @return 书籍信息
     */
    public List<Book> getBookListWithBrands();

    /**
     * 获取包含图书目录的图书信息
     *
     * @param id
     * @return
     */
    public Book getChapterByBookId(int id);
}
