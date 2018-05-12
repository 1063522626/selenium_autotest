package sevenfresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sevenfresh.dao.mapper.FileMapper;
import sevenfresh.service.FileUploadService;

/**
 * Created by lubo3 on 2018/2/9.
 */
@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileMapper fileMapper;

    public void insertFile(String filename, String filepath) {
        fileMapper.insertFile(filename,filepath);

    }
}
