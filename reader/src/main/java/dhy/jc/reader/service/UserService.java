package dhy.jc.reader.service;

import dhy.jc.reader.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface UserService extends BaseService<User> {

    /**
     * 获取包含用户书架的用户集合
     *
     * @return
     */
    public List<User> getUsersWithShelves();

    /**
     * 获取单个用户的自定义书架集合
     *
     * @param id
     * @return
     */
    public User getUserWithShelves(int id);

    /**
     * 根据id 获取单个用户的推荐书籍信息
     *
     * @param id
     * @return
     */
    public User getRecommandsByUserId(int id);

    /**
     * 根据id 获取单个用户的收藏书籍信息
     *
     * @param id
     * @return
     */
    public User getStoreBookByUserId(int id);
}
