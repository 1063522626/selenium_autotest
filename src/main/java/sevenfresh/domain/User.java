package sevenfresh.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lubo3 on 2018/2/7.
 */
@Data
public class User implements Serializable {

    private String cardnumber;

    private String bname;

    private String education;

    private String location;

    private Date birthday;

    private float salary;

    private String currenthome;

    private String father;

    private String monther;

    private String sister;

    private String pride;

    private String password;


}
