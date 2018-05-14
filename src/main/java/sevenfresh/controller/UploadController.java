package sevenfresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sevenfresh.service.FileUploadService;
import sevenfresh.service.SelectFilenameListService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lubo3 on 2018/4/24.
 */
@Controller
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private SelectFilenameListService selectFilenameListService;

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value = "/upload")
    public @ResponseBody ResponseEntity<?> uploadAutoScriptFile(MultipartFile file) {

        List<String> fileNameList=selectFilenameListService.selectFileList();
        String fileName;
        //文件判空
        if(null!=file&&!file.isEmpty()) {
            try {
                fileName=file.getOriginalFilename();
                if(fileNameList.contains(fileName))
                {
                    ResponseEntity responseEntity=new ResponseEntity(fileNameList,HttpStatus.BAD_REQUEST);
                    return responseEntity;
                }
                String filePath = "E:\\AutoTestScript"+File.separator
                              +fileName;
                file.transferTo(new File(filePath));
                //上传文件信息保存数据库
                fileUploadService.insertFile(fileName,filePath);
                System.out.println(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //查询数据库所有文件，返回文件名称列表
        fileNameList=selectFilenameListService.selectFileList();
        ResponseEntity responseEntity=new ResponseEntity(fileNameList, HttpStatus.OK);
        return responseEntity;
    }
}
