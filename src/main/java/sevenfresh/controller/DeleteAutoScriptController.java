package sevenfresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sevenfresh.domain.ExecuteInfo;
import sevenfresh.service.DeleteAutoScriptService;

import java.io.File;

/**
 * Created by lubo3 on 2018/4/26.
 */
@Controller
public class DeleteAutoScriptController {

    @Autowired
    private DeleteAutoScriptService deleteAutoScriptService;

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value = "/deletefile")
    public @ResponseBody boolean deleteAutoScript(@RequestBody ExecuteInfo executeInfo){
        String fileName= executeInfo.getFileName();
        //删除文件夹中的脚本
        File file=new File("E:\\AutoTestScript"+ File.separator+fileName);
        file.delete();
//        System.out.println(fileName);
        //删除数据库中的脚本
        deleteAutoScriptService.deleteAutoScriptByFilename(fileName);
        return true;
    }
}
