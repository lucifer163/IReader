package dhy.jc.reader.service.impl;

import dhy.jc.reader.dao.UserDao;
import dhy.jc.reader.enums.MessageEnum;
import dhy.jc.reader.model.User;
import dhy.jc.reader.service.UserService;
import dhy.jc.reader.util.DataOpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 获取具体dao类
     */
    @Autowired
    public void setBaseDao() {
        super.setBaseDao(userDao);
    }

    /**
     * 添加用户
     *
     * @param record
     * @return
     */
    @Override
    public int insertRecord(User record) {
        //判断联系方式
        if (userDao.getRecordByMobiles(record.getMobile()) != null) {
            return MessageEnum.TEL_EXITED.getValue();
        }
        //密码md5加密
        String password = DataOpt.md5(record.getPassword());
        record.setPassword(password);
        //添加数据
        int count = userDao.insertRecord(record);
        if (count > 0) {
            return MessageEnum.OPERATE_SUCCESS.getValue();
        }
        return MessageEnum.OPERATE_ERROR.getValue();
    }

    /**
     * 完善信息/更改信息
     *
     * @param record
     * @return
     */
    @Override
    public int updateRecord(User record) {
        //判断email
        if (userDao.getRecordByEmail(record) != null) {
            return MessageEnum.EMAIL_EXITED.getValue();
        }
        //判断联系方式
        if (userDao.getRecordByMobile(record) != null) {
            return MessageEnum.TEL_EXITED.getValue();
        }
        //判断qq账号
        if (userDao.getRecordByQQ(record) != null) {
            return MessageEnum.QQ_EXITED.getValue();
        }
        //判断微信账号
        if (userDao.getRecordByWechat(record) != null) {
            return MessageEnum.WECHAT_EXITED.getValue();
        }
        int count = userDao.updateRecord(record);
        if (count > 0) {
            return MessageEnum.OPERATE_SUCCESS.getValue();
        }
        return MessageEnum.OPERATE_ERROR.getValue();
    }

    /**
     * 获取用户自定义书架集合
     *
     * @return
     */
    public List<User> getUsersWithShelves() {
        return userDao.getUsersWithShelves();
    }

    /**
     * 获取用户自定义书架对象
     *
     * @param id
     * @return
     */
    public User getUserWithShelves(int id) {
        return userDao.getUserWithShelves(id);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteRecordByID(int id) {
        int count = userDao.deleteRecordByID(id);
        if (count > 0) {
            return MessageEnum.OPERATE_SUCCESS.getValue();
        }
        return MessageEnum.OPERATE_ERROR.getValue();
    }

    /**
     * 根据id 获取单个用户的推荐书籍信息
     *
     * @param id
     * @return
     */
    public User getRecommandsByUserId(int id) {
        return userDao.getRecommandsByUserId(id);
    }

    /**
     * 根据id 获取单个用户的收藏书籍信息
     *
     * @param id
     * @return
     */
    public User getStoreBookByUserId(int id) {
        return userDao.getStoreBookByUserId(id);
    }

}
