package dhy.jc.reader.controller;

import dhy.jc.reader.enums.MessageEnum;
import dhy.jc.reader.model.Book;
import dhy.jc.reader.model.ExtendModel;
import dhy.jc.reader.model.Shelves;
import dhy.jc.reader.model.User;
import dhy.jc.reader.service.UserService;
import dhy.jc.reader.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户查找相关接口
 * Created by Administrator on 2016/11/21.
 */
@Controller
@Scope("prototype")
public class UserInfoController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private ExtendModel extendModel;

    /**
     * 获取包含用户自定义书架的用户集合
     * 请求数据：
     * {"id":1}
     *
     * @return 用户详细信息 用户自定义书架
     */
    @RequestMapping(value = "user/getUsersWithShelves.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUsersWithShelves() {
        List<User> users = userService.getUsersWithShelves();
        String jsonStr = JsonUtil.createJsonList(users);
        return jsonStr;
    }

    /**
     * 获取查找用户的自定义书架
     * 请求数据：
     * {"id":1}
     *
     * @param jsonCode 用户id
     * @return 自定义书架集合
     */
    @RequestMapping(value = "user/getUserWithShelves.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getShelvesByUserId(@RequestBody String jsonCode) {
        String jsonStr = "";
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        if (map.get("id") == null || "".equals(map.get("id"))) {
            extendModel.setReturnMsg(MessageEnum.JSON_ACCESS_ERROR.getDescription());
            extendModel.setReturnCode("1100001");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        } else {
            double id = (Double) map.get("id");
            List<Shelves> shelves = userService.getUserWithShelves((int) id).getShelves();
            jsonStr = JsonUtil.createJsonList(shelves);
            return jsonStr;
        }
    }

    /**
     * 获取用户信息集合
     *
     * @return
     */
    @RequestMapping(value = "user/getUsersWithoutAnything.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUsersWithoutAnything() {
        List<User> users = userService.getRecords();
        String jsonStr = JsonUtil.createJsonList(users);
        return jsonStr;
    }

    /**
     * 根据id获取单个用户信息
     * 请求数据：
     * {"id":1}
     *
     * @param jsonCode id
     * @return
     */
    @RequestMapping(value = "user/getUserById.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserById(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        User user = userService.getRecord((int) id);
        String jsonStr = JsonUtil.createJsonString(user);
        return jsonStr;
    }

    /**
     * 根据id获取单个用户推荐书籍信息
     * 请求数据：
     * {"id":1}
     *
     * @param jsonCode id
     * @return
     */
    @RequestMapping(value = "user/getRecommandsByUserId.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRecommandsByUserId(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        List<Book> books = userService.getRecommandsByUserId((int) id).getRecommandBooks();
        String jsonStr = JsonUtil.createJsonString(books);
        return jsonStr;
    }

    /**
     * 根据id获取单个用户搜藏书籍信息
     * 请求数据：
     * {"id":1}
     *
     * @param jsonCode id
     * @return
     */
    @RequestMapping(value = "user/getStoreBookByUserId.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getStoreBookByUserId(@RequestBody String jsonCode) {
        Map map = JsonUtil.changeGsonToMaps(jsonCode);
        double id = (Double) map.get("id");
        List<Book> books = userService.getStoreBookByUserId((int) id).getStoreBooks();
        String jsonStr = JsonUtil.createJsonString(books);
        return jsonStr;
    }
}
