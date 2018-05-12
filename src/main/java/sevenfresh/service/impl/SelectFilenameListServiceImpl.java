package sevenfresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sevenfresh.dao.mapper.SelectFilenameListMapper;
import sevenfresh.service.SelectFilenameListService;

import java.util.List;

/**
 * Created by lubo3 on 2018/4/26.
 */
@Service("selectFilenameListService")
public class SelectFilenameListServiceImpl implements SelectFilenameListService {

    @Autowired
    SelectFilenameListMapper selectFilenameListMapper;

    public List<String> selectFileList() {

        List<String> fileNameList=selectFilenameListMapper.selectFilenameList();
        return fileNameList;
    }
}
