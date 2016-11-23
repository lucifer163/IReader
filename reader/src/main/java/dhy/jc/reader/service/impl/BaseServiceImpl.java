package dhy.jc.reader.service.impl;

import dhy.jc.reader.dao.BaseDao;
import dhy.jc.reader.service.BaseService;

import java.util.List;

/**
 * 抽象类的service具体实现
 * Created by Administrator on 2016/11/18.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    private BaseDao<T> baseDao;

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    public int insertRecord(T record) {
        return baseDao.insertRecord(record);
    }

    public int deleteRecordByID(int id) {
        return baseDao.deleteRecordByID(id);
    }

    public int updateRecord(T record) {
        return baseDao.updateRecord(record);
    }

    public T getRecord(int id) {
        return baseDao.getRecord(id);
    }

    public List<T> getRecords() {
        return baseDao.getRecords();
    }

    public List<T> getRecordByCondition(String condition) {
        return baseDao.getRecordByCondition(condition);
    }

    public List<T> getRecordByVague(String vague) {
        return baseDao.getRecordByVague(vague);
    }
}
