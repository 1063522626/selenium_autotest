package sevenfresh.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lubo3 on 2018/4/19.
 */
@Data
public class LoginInfo implements Serializable{
    private String bname;
    private String password;

//    public String getBname() {
//        return bname;
//    }
//
//    public void setBname(String bname) {
//        this.bname = bname;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}

