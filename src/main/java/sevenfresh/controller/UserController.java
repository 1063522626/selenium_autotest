package sevenfresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sevenfresh.domain.LoginInfo;
import sevenfresh.domain.User;
import sevenfresh.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by lubo3 on 2018/2/7.
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value = "/login")
    public @ResponseBody User loginForm(@RequestBody LoginInfo loginInfo) {
        String bname = loginInfo.getBname();
        String password = loginInfo.getPassword();
        System.out.println(bname);
        System.out.println(password);
        User user=userService.login(bname,password);
//        System.out.println(user.toString());
//        if(user!=null)
//        {
//            session.setAttribute("user",user);
//            mv.setViewName("AutoScriptFile");
//        }else
//        {
//            mv.setViewName("Login");
//        }
        return user;

    }
}
