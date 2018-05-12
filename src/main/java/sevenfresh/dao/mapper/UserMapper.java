package sevenfresh.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sevenfresh.domain.User;

/**
 * Created by lubo3 on 2018/2/7.
 */
public interface UserMapper {

    User selectUserByBname(@Param("bname") String bname, @Param("password") String password);
}
