package sevenfresh.util;

/**
 * Created by lubo3 on 2018/4/28.
 */
public class ExcelVersionUntil {

    public static boolean isExcel2003(String fileName){

        return fileName.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String fileName){

        return fileName.matches("^.+\\.(?i)(xlsx)$");
    }
}
