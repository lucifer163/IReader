package dhy.jc.reader.dao;

import dhy.jc.reader.model.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface BookDao extends BaseDao<Book> {

    /**
     * 获取包含书籍标签的书籍集合
     *
     * @return
     */
    public List<Book> getBookListWithBrands();

    /**
     * 获取包含图书目录的图书信息
     *
     * @param id
     * @return
     */
    public Book getChapterByBookId(int id);

    /**
     * 获取图书章节数量
     *
     * @param id
     * @return
     */
    public int getChapterSizeByBookId(int id);

}
