package dhy.jc.reader.dao;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface BaseDao<T> {
    /**
     * 添加一条记录
     *
     * @param record
     * @return
     */
    public int insertRecord(T record);

    /**
     * 删除一条记录
     *
     * @param id
     * @return
     */
    public int deleteRecordByID(int id);

    /**
     * 更新一条记录
     *
     * @param record
     * @return
     */
    public int updateRecord(T record);

    /**
     * 获取一条记录
     *
     * @param id
     * @return
     */
    public T getRecord(int id);

    /**
     * 获取所有记录
     *
     * @return
     */
    public List<T> getRecords();

    /**
     * 单条件下的精确查询
     *
     * @param condition
     * @return
     */
    public List<T> getRecordByCondition(String condition);

    /**
     * 单条件下的模糊查询
     *
     * @param vague
     * @return
     */
    public List<T> getRecordByVague(String vague);
}
