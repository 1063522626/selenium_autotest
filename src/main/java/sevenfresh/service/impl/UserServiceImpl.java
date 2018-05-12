package sevenfresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sevenfresh.dao.mapper.UserMapper;
import sevenfresh.domain.User;
import sevenfresh.service.UserService;

/**
 * Created by lubo3 on 2018/2/7.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public User login(String bname, String password) {

        return userMapper.selectUserByBname(bname,password);
    }
}
