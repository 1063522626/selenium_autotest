package sevenfresh.service;

import sevenfresh.domain.User;

/**
 * Created by lubo3 on 2018/2/7.
 */
public interface UserService {

    User login(String bname, String password);
}
