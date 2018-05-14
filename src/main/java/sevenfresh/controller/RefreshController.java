package sevenfresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sevenfresh.service.SelectFilenameListService;

import java.util.List;

/**
 * Created by lubo3 on 2018/5/14.
 */
@Controller
public class RefreshController {

    @Autowired
    SelectFilenameListService selectFilenameListService;

    @CrossOrigin(origins= "*",maxAge=3600)
    @RequestMapping(value= "/refresh")
    public @ResponseBody List<String> refreshAutoScriptFile(){

       List<String> fileNameList=selectFilenameListService.selectFileList();
       return  fileNameList;
    }


}
