package sevenfresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sevenfresh.dao.mapper.DeleteAutoScriptMapper;
import sevenfresh.service.DeleteAutoScriptService;

/**
 * Created by lubo3 on 2018/4/27.
 */
@Service("deleteAutoScriptService")
public class DeleteAutoScriptServiceImpl implements DeleteAutoScriptService {

    @Autowired
    private DeleteAutoScriptMapper deleteAutoScriptMapper;
    public void deleteAutoScriptByFilename(String fileName) {
        deleteAutoScriptMapper.deleteAutoScriptByFilename(fileName);
    }
}
