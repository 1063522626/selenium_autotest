package sevenfresh.util.elementaction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sevenfresh.domain.CellList;

/**
 * Created by lubo3 on 2018/5/6.
 */
public class ElementAction {

    public static void windowAction(CellList windowInfo,WebDriver driver){

        CellList elementInfo=windowInfo;
        String value=elementInfo.getValue();
        if(value.equals("最大化"))
        {
            driver.manage().window().maximize();
        }else if(value.equals("关闭"))
        {
            driver.quit();
            driver.close();
        }else
        {
            //暂时只支持最大化和关闭
            driver.manage().window().fullscreen();
        }

    }
    public static void sleepAction(CellList sleepInfo,WebDriver driver) throws InterruptedException {

        CellList elementInfo=sleepInfo;
        String value=elementInfo.getValue();
        //将秒转换成毫秒
        long Longvalue=Long.parseLong(value)*1000;
        Thread.sleep(Longvalue);
    }

    public static void currentAction(CellList currentInfo,WebDriver driver)
    {
        CellList elementInfo=currentInfo;
        String value=elementInfo.getValue();
        String handle=elementInfo.getHandle();
        if(handle.equals("输入"))
        {
            Actions action=new Actions(driver);
            action.sendKeys(value).perform();
        }else if(handle.equals("单击"))
        {
            Actions action=new Actions(driver);
            action.click().perform();
        }else if(handle.equals("双击"))
        {
            Actions action=new Actions(driver);
            action.doubleClick().perform();
        }

    }

    public static void tabAction(CellList tabInfo,WebDriver driver)
    {
        CellList elementInfo=tabInfo;
        Actions action=new Actions(driver);
        //不调用perform时不生效
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.NULL).perform();
    }

    public static void inputAction(CellList inputInfo,WebDriver driver){

        CellList elementInfo=inputInfo;
        String itype=elementInfo.getItype();
        String identify=elementInfo.getIdentify();
        String value=elementInfo.getValue();

        if(itype.equals("id"))
        {
               driver.findElement(By.id(identify)).sendKeys(value);
        }else if(itype.equals("name"))
        {
            driver.findElement(By.name(identify)).sendKeys(value);
        }else if(itype.equals("xpath"))
        {
            driver.findElement(By.xpath(identify)).sendKeys(value);
        }else if(itype.equals("class"))
        {
            driver.findElement(By.className(identify)).sendKeys(value);
        }

    }
    public static void buttonAction(CellList buttonInfo,WebDriver driver)
    {
        CellList elementInfo=buttonInfo;
        String itype=elementInfo.getItype();
        String identify=elementInfo.getIdentify();
        String handle=elementInfo.getHandle();

        if(itype.equals("id"))
        {
            if(handle.equals("单击"))
            {
                Actions action=new Actions(driver);
                action.click(driver.findElement(By.id(identify))).perform();
            }else if(handle.equals("双击"))
            {
                Actions action=new Actions(driver);
                action.doubleClick(driver.findElement(By.id(identify))).perform();
            }
        }else if(itype.equals("name"))
        {
            if(handle.equals("单击"))
            {
                Actions action=new Actions(driver);
                action.click(driver.findElement(By.name(identify))).perform();
            }else if(handle.equals("双击"))
            {
                Actions action=new Actions(driver);
                action.doubleClick(driver.findElement(By.name(identify))).perform();
            }
        }else if(itype.equals("xpath"))
        {
            if(handle.equals("单击"))
            {
                Actions action=new Actions(driver);
                action.click(driver.findElement(By.xpath(identify))).perform();
            }else if(handle.equals("双击"))
            {
                Actions action=new Actions(driver);
                action.doubleClick(driver.findElement(By.xpath(identify))).perform();
            }
        }else if(itype.equals("linktext"))
        {
            if(handle.equals("单击"))
            {
                Actions action=new Actions(driver);
                action.click(driver.findElement(By.linkText(identify))).perform();
            }else if(handle.equals("双击"))
            {
                Actions action=new Actions(driver);
                action.doubleClick(driver.findElement(By.linkText(identify))).perform();
            }
        }else if(itype.equals("class"))
        {
            if(handle.equals("单击"))
            {
                Actions action=new Actions(driver);
                action.click(driver.findElement(By.className(identify))).perform();
            }else if(handle.equals("双击"))
            {
                Actions action=new Actions(driver);
                action.doubleClick(driver.findElement(By.className(identify))).perform();
            }
        }
    }

    public static void selectAction(CellList selectInfo,WebDriver driver)
    {
        CellList elementInfo=selectInfo;
        String itype=elementInfo.getItype();
        String identify=elementInfo.getIdentify();
        String value=elementInfo.getValue();

        if(itype.equals("id"))
        {
           WebElement element=driver.findElement(By.id(identify));
            Select select=new Select(element);
            select.selectByVisibleText(value);
        }else if(itype.equals("name"))
        {
            WebElement element=driver.findElement(By.name(identify));
            Select select=new Select(element);
            select.selectByVisibleText(value);
        }else if(itype.equals("xpath"))
        {
            WebElement element=driver.findElement(By.xpath(identify));
            Select select=new Select(element);
            select.selectByVisibleText(value);
        }

    }

}
