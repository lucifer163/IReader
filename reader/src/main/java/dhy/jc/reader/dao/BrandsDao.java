package dhy.jc.reader.dao;

import dhy.jc.reader.model.Brands;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface BrandsDao extends BaseDao<Brands> {
    /**
     * 根据书籍信息查询标签
     *
     * @param id
     * @return
     */
    public List<Brands> getBrandsListWithBooks();

}
