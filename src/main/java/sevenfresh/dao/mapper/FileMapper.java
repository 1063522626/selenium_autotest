package sevenfresh.dao.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by lubo3 on 2018/2/9.
 */
public interface FileMapper {
    void insertFile(@Param("filename") String filename,
                    @Param("filepath") String filepath);

}
