package sevenfresh.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sevenfresh.domain.CellList;
import sevenfresh.domain.ExecuteInfo;
import sevenfresh.util.ExcelVersionUntil;
import sevenfresh.util.ResolveScriptUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lubo3 on 2018/4/27.
 */
@Controller
public class ExecuteAutoScriptController {


    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "/executefile")
    public @ResponseBody boolean executeAutoScript(@RequestBody ExecuteInfo executeInfo) throws IOException, InterruptedException {

        boolean isExcel2003;
        Workbook wb;
        InputStream is = null;
        List<CellList> excelInfo;
        CellList rowInfo;
        int totalRow;
        int totalColumn;

        String fileName= executeInfo.getFileName();
        String baseUrl=executeInfo.getBaseUrl();
        String browser=executeInfo.getBrowser();

        File file=new File("E:\\AutoTestScript"+File.separator+fileName);
        //创建输入流
        try {

            is=new FileInputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(ExcelVersionUntil.isExcel2003(fileName))
        {
            isExcel2003=true;
            wb=new HSSFWorkbook(is);
        }else
        {
            isExcel2003=false;
            wb=new XSSFWorkbook(is);
        }

        Sheet sheet=wb.getSheetAt(0);
        totalRow=sheet.getPhysicalNumberOfRows();
        //所有行数据
        excelInfo=new ArrayList<CellList>();
        for(int i=1;i<totalRow;i++) {
            Row row=sheet.getRow(i);
            rowInfo=new CellList();
            //totalColumn=row.getPhysicalNumberOfCells() 方法中间有空值时，得到的是实际有值的总列数
            totalColumn=row.getLastCellNum();
            for(int j=0;j<totalColumn;j++) {
                Cell cell=row.getCell(j);
                if(null!=cell) {
                    if(j==0) {
                       rowInfo.setElement(cell.getStringCellValue());
                    }else if(j==1){

                        rowInfo.setItype(cell.getStringCellValue());
                    }else if(j==2){

                        rowInfo.setIdentify(cell.getStringCellValue());
                    }else if(j==3){
                        //首先设置单元格数据类型，否则读取数字类型时报错
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                        rowInfo.setValue(cell.getStringCellValue());
                    }else if(j==4){

                        rowInfo.setHandle(cell.getStringCellValue());
                    }
                }
            }

         //解析excel文档
         excelInfo.add(rowInfo);
        }
//        System.out.println(excelInfo.toString());
//       [CellList(action=输入, itype=id, identify=username, value=lubo),
//        CellList(action=输入, itype=id, identify=password, value=123)]
        ResolveScriptUtil.resolve(excelInfo,baseUrl,browser);
        is.close();
        return true;
    }

}
