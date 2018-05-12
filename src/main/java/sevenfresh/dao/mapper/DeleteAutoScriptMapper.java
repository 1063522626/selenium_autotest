package sevenfresh.dao.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by lubo3 on 2018/4/27.
 */
public interface DeleteAutoScriptMapper {
    void deleteAutoScriptByFilename(@Param("fileName") String fileName);
}
