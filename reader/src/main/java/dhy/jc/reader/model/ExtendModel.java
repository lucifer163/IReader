package dhy.jc.reader.model;

import org.springframework.stereotype.Component;

/**
 * 用于返回结果的额外的类
 * Created by Administrator on 2016/11/18.
 */
@Component("extendModel")
public class ExtendModel {
    private String returnMsg;
    private String returnCode;

    public ExtendModel(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public ExtendModel() {
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
