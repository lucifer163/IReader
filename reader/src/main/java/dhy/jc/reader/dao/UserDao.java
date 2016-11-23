package dhy.jc.reader.dao;

import dhy.jc.reader.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface UserDao extends BaseDao<User> {

    public User getRecordByEmail(User user);

    public User getRecordByMobile(User user);

    public User getRecordByMobiles(String mobile);

    public User getRecordByQQ(User user);

    public User getRecordByWechat(User user);

    /**
     * 获取包含用户自定义书架的用户列表
     *
     * @return 用户列表；仅用户信息 用户名自定义书架名称
     */
    public List<User> getUsersWithShelves();

    /**
     * 根据id 获取包含用户自定义书架的用户信息
     *
     * @return 单一用户信息；用户全部信息 用户自定义书架信息
     */
    public User getUserWithShelves(int id);

    /**
     * 获取包含用户书评的用户信息集合
     *
     * @return 单一用户信息；用户全部信息 用户书评信息
     */
    public List<User> getUsersWithReply();

    /**
     * 根据id 获取单个用户所有信息和的书评信息
     *
     * @param id
     * @return 单一用户信息；用户全部信息 用户书评信息
     */
    public User getUserWithReply(int id);

    /**
     * 获取包含用户私信的用户信息集合
     *
     * @return 单一用户信息；用户全部信息 用户私信信息
     */
    public List<User> getUsersWithMessage();

    /**
     * 根据id 获取单个用户所有信息和的私信信息
     *
     * @param id
     * @return 单一用户信息；用户全部信息 用户私信信息
     */
    public User getUserWithMessage(int id);

    /**
     * 获取包含完整推荐书籍信息的单个用户
     *
     * @param id
     * @return
     */
    public User getRecommandsByUserId(int id);

    /**
     * 获取包含完整收藏书籍信息的单个用户
     *
     * @return
     */
    public User getStoreBookByUserId(int id);
}
