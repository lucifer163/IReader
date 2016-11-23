package dhy.jc.reader.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据处理工具类
 * Created by Administrator on 2016/11/18.
 */
public class DataOpt {

    /**
     * md5数据加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        String newStr = "";
        try {
            //确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
        } catch (NoSuchAlgorithmException e) {
        }
        return newStr;
    }

    /**
     * 获取当前时间
     *
     * @return String time
     */
    public static String getLocalTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(date);
        return dateStr;
    }
}
