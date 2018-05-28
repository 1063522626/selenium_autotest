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
        String handle=elementInfo.getHandle();
        String value=elementInfo.getValue();
        if(handle.equals("最大化"))
        {
            driver.manage().window().maximize();
        }else if(handle.equals("关闭"))
        {
            driver.quit();
            driver.close();
        }else if(handle.equals("前进"))
        {
            driver.navigate().forward();
        }else if(handle.equals("后退"))
        {
            driver.navigate().back();
        }else if(handle.equals("刷新"))
        {
            driver.navigate().refresh();
        }else if(handle.equals("新窗口"))
        {
            Actions action=new Actions(driver);
            action.sendKeys(Keys.CONTROL+"t").perform();
            driver.get(value);

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
        String identify=elementInfo.getIdentify();
        String handle=elementInfo.getHandle();
        String value=elementInfo.getValue();

        Actions action=new Actions(driver);
        if(handle.equals("输入"))
        {

            action.sendKeys(value).perform();
        }else if(handle.equals("单击"))
        {

            action.click().perform();
        }else if(handle.equals("双击"))
        {

            action.doubleClick().perform();
        }

    }

    public static void multiSelectAction(CellList multiSelectInfo,WebDriver driver)
    {
        CellList elementInfo=multiSelectInfo;
        String itype=elementInfo.getItype();
        String identify=elementInfo.getIdentify();
        String handle=elementInfo.getHandle();
        Actions action=new Actions(driver);
        if (itype.equals("xpath"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.xpath(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.xpath(identify))).perform();
            }
        }else if(itype.equals("id"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.id(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.id(identify))).perform();
            }
        }else if(itype.equals("name"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.name(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.name(identify))).perform();
            }
        }else if(itype.equals("linktext"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.linkText(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.linkText(identify))).perform();
            }
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

        Actions action=new Actions(driver);

        if(itype.equals("id"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.id(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.id(identify))).perform();
            }
        }else if(itype.equals("name"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.name(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.name(identify))).perform();
            }
        }else if(itype.equals("xpath"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.xpath(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.xpath(identify))).perform();
            }
        }else if(itype.equals("linktext"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.linkText(identify))).perform();
            }else if(handle.equals("双击"))
            {

                action.doubleClick(driver.findElement(By.linkText(identify))).perform();
            }
        }else if(itype.equals("class"))
        {
            if(handle.equals("单击"))
            {

                action.click(driver.findElement(By.className(identify))).perform();
            }else if(handle.equals("双击"))
            {

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

    public static void uploadFileAction(CellList uploadFileInfo,WebDriver driver)
    {
        CellList elementInfo=uploadFileInfo;
        String itype=elementInfo.getItype();
        String identify=elementInfo.getIdentify();
        String value=elementInfo.getValue();

        if(itype.equals("xpath"))
        {
            WebElement element=driver.findElement(By.xpath(identify));
            element.sendKeys(value);
        }
    }

    public static void switchToWindow(String title,WebDriver driver)
    {
        System.out.println("测试");
    }

}
