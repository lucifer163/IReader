package dhy.jc.reader.service.impl;

import dhy.jc.reader.dao.BookDao;
import dhy.jc.reader.model.Book;
import dhy.jc.reader.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 获取具体dao类
     */
    @Autowired
    public void setBaseDao() {
        super.setBaseDao(bookDao);
    }

    /**
     * 获取包含书籍标签的书籍集合
     *
     * @return 书籍信息
     */
    public List<Book> getBookListWithBrands() {
        return bookDao.getBookListWithBrands();
    }

    /**
     * 获取包含图书目录的图书信息
     *
     * @param id
     * @return
     */
    public Book getChapterByBookId(int id) {
        Book book = bookDao.getChapterByBookId(id);
        int chapterSize = bookDao.getChapterSizeByBookId(id);
        book.setChaptersize(chapterSize);
        return book;
    }
}
