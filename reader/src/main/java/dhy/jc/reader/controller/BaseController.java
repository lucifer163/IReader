package dhy.jc.reader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 公共controller类
 * Created by Administrator on 2016/11/22.
 */
@Controller
public class BaseController {

    /**
     * 文件上传
     *
     * @param file
     * @param request
     */
    public String importFile(MultipartFile file, HttpServletRequest request, String url) {
        System.out.println("------------------------BEGIN-------------------------");
        String path = request.getSession().getServletContext().getRealPath(url);
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //position
        System.out.println(fileName + "保存路径：" + path);
        System.out.println(fileName + "文件名" + fileName);
        System.out.println(fileName + "项目下的路径" + path);
        System.out.println("------------------------OVER-------------------------");
        return path;
    }

    /**
     * 判断文件类型是否符合要求
     * 文档上传类型：.txt
     *
     * @param file
     */
    public boolean getBookFileType(MultipartFile file) {
        boolean flag = false;
        System.out.println("getBookType:============================");
        if (!file.isEmpty()) {
            String suffixList = "txt";
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            if (suffixList.contains(suffix.trim().toLowerCase())) {
                System.out.println(suffix);
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 判断文件类型是否符合要求
     * 图片上传类型：.jpg .jpeg .png .bmp
     *
     * @param file
     */
    public boolean getLogoFileType(MultipartFile file) {
        boolean flag = false;
        System.out.println("getLogoType:============================");
        if (!file.isEmpty()) {
            String suffixList = "jpg,jpeg,png,bmp";
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            if (suffixList.contains(suffix.trim().toLowerCase())) {
                System.out.println(suffix);
                flag = true;
            }
        }
        return flag;
    }
}
