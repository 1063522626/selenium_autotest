package sevenfresh.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lubo3 on 2018/2/9.
 */
@Data
public class AutoScriptFile implements Serializable {

    private int id;

    private String filename;

    private String filepath;

    private String user_name;

}
