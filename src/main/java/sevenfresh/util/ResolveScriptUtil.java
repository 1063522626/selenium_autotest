package sevenfresh.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sevenfresh.domain.CellList;
import sevenfresh.util.elementaction.ElementAction;

import javax.xml.bind.Element;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lubo3 on 2018/5/6.
 */
public class ResolveScriptUtil {


    public static void resolve(List<CellList> excel,String baseUrl,String browser) throws InterruptedException {

        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\browser\\geckodriver.exe");
        if(browser.equals("chrome"))
        {
            driver=new ChromeDriver();
        }else if(browser.equals("firefox"))
        {
            driver=new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);

        List<CellList> excelInfo = excel;
        for(CellList cellList:excelInfo)
        {
            String elem=cellList.getElement();
            if(elem.equals("浏览器"))
            {
                ElementAction.windowAction(cellList,driver);
            }else if(elem.equals("文本框"))
            {
                ElementAction.inputAction(cellList,driver);
            }else if(elem.equals("按钮"))
            {
                ElementAction.buttonAction(cellList,driver);
            }else if(elem.equals("下拉框"))
            {
                ElementAction.selectAction(cellList,driver);
            }else if(elem.equals("暂停"))
            {
                ElementAction.sleepAction(cellList,driver);
            }else if(elem.equals("tab"))
            {
                ElementAction.tabAction(cellList,driver);
            }else if(elem.equals("当前组件"))
            {
                ElementAction.currentAction(cellList,driver);
            }else if(elem.equals("多级下拉框"))
            {
                ElementAction.multiSelectAction(cellList,driver);
            }

        }

    }

}
