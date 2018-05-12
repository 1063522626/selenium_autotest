package sevenfresh.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lubo3 on 2018/4/27.
 */
@Data
public class ExecuteInfo implements Serializable {
    private String fileName;
    private String baseUrl;
    private String browser;
}
