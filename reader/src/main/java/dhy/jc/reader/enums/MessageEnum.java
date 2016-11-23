package dhy.jc.reader.enums;

/**
 * Created by Administrator on 2016/11/17.
 * 错误消息通知
 */
public enum MessageEnum {

    //记录常规的返回数值:
    OPERATE_SUCCESS(0, "success"),
    OPERATE_ERROR(1, "error"),
    JSON_ACCESS_ERROR(2, "参数请求错误"),
    FILE_UPLOAD_ERROR(3, "非法的文件后缀"),

    //记录信息已经存在的部分:
    USER_EXITED(10, "该账号名称已被注册"),
    EMAIL_EXITED(11, "该电子邮箱已被注册"),
    TEL_EXITED(12, "该联系方式已被注册"),
    QQ_EXITED(13, "该qq账号已被注册"),
    WECHAT_EXITED(14, "该微信账号已被注册"),

    //记录信息校验错误的部分:
    ADMIN_INFO_ERROR(13, "用户名或密码错误");

    private int value;
    private String description;

    //私有构造函数
    private MessageEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    //?
    public static MessageEnum getValue(int _value) {
        for (MessageEnum _enum : MessageEnum.values()) {
            if (_enum.value == _value)
                return _enum;
        }
        return null;
    }
}
