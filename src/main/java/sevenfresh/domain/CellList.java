package sevenfresh.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lubo3 on 2018/4/28.
 */
@Data
public class CellList implements Serializable {
    private String element;

    private String itype;

    private String identify;

    private String value;

    private String handle;
}
