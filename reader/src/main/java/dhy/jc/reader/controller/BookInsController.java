package dhy.jc.reader.controller;

import dhy.jc.reader.enums.MessageEnum;
import dhy.jc.reader.model.Book;
import dhy.jc.reader.model.ExtendModel;
import dhy.jc.reader.service.BookService;
import dhy.jc.reader.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/22.
 * 书籍具体操作接口 书籍导入 书籍删除 书籍基本信息编辑（管理员权限）
 * 调用书籍录入接口时 首先调用书籍基本信息添加接口 其次调用文件上传接口，分别上传txt文件和图片文件
 */
@Controller
@Scope("prototype")
public class BookInsController extends BaseController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Autowired
    private ExtendModel extendModel;

    /**
     * 书籍上传接口
     * 注意：form表单中上传书籍file name为bookFile  上传图片file name为logoFile :: POST
     * 传递json数据 :: GET
     *
     * @param bookFile
     * @param logoFile
     * @param request
     * @return
     */
    @RequestMapping(value = "book/importBookFile.json")
    @ResponseBody
    public String upload(@RequestParam(value = "bookFile", required = false) MultipartFile bookFile,
                         @RequestParam(value = "logoFile", required = false) MultipartFile logoFile,
                         HttpServletRequest request) {
        String jsonStr = "";
        String bookUrl = "upload/book";
        String logoUrl = "upload/logo";

        //判断后缀
        boolean bookType = super.getBookFileType(bookFile);
        boolean logoType = super.getLogoFileType(logoFile);

        if (bookType == false || logoType == false) {
            extendModel.setReturnMsg(MessageEnum.FILE_UPLOAD_ERROR.getDescription());
            extendModel.setReturnCode("1100011");
            jsonStr = JsonUtil.createJsonString(extendModel);
            return jsonStr;
        }
        //上传文件 获取保存路径
        String bookPath = super.importFile(bookFile, request, bookUrl);
        String logoPath = super.importFile(logoFile, request, logoUrl);
        //数据库操作
        String bookname = request.getParameter("bookname");
        String author = request.getParameter("author");
        String item = request.getParameter("item");
        Book book = new Book(author, bookname, item);

        extendModel.setReturnMsg(MessageEnum.OPERATE_SUCCESS.getDescription() + bookname);
        extendModel.setReturnCode("1100000");
        jsonStr = JsonUtil.createJsonString(extendModel);
        return jsonStr;
    }
}
