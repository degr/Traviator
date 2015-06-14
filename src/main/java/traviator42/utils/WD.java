package traviator42.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WD {

    public WebDriver d;

    public WD(WebDriver driver){
        d = driver;
    }
    public void get(String url){
        d.get(url);
    }
    public void refresh(){
        d.navigate().refresh();
    }

    //<editor-fold defaultstate="collapsed" desc="возвращаемые элементы">
    public WebElement id(String id){
        return d.findElement(By.id(id));
    }
    public WebElement xp(String xpath){
        return d.findElement(By.xpath(xpath));
    }
    public WebElement name(String name){
        return d.findElement(By.name(name));
    }
    public WebElement cName(String className){
        return d.findElement(By.className(className));
    }
    public WebElement css(String cssSelector){
        return d.findElement(By.cssSelector(cssSelector));
    }
    public WebElement tag(String tagName){
        return d.findElement(By.tagName(tagName));
    }
    public WebElement plText(String partialLinkText){
        return d.findElement(By.partialLinkText(partialLinkText));
    }
    public WebElement lText(String linkText){
        return d.findElement(By.linkText(linkText));
    }


    //</editor-fold>
    public  boolean ajaxEl(String xpath){
        int i = 0;
        while(i < 10){
            try{
                xp(xpath);
                return true;
            }catch(org.openqa.selenium.NoSuchElementException ex){
            }
            i++;
            sleep(1000);
        }
        return false;
    }
    public int getInt(String xp){
         return Integer.parseInt(xp(xp).getText());
    }
    public int getElemsCount(String xp){
        return d.findElements(By.xpath(xp)).size();
    }
    /**
     * Sleep thread, with current millis
     * @param millis - milliseconds 
     */
    public void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }
    /**
     * Sleep thread, with current millis
     * @param millis - milliseconds
     */
    public void sleep(String  millis){
        sleep(Integer.parseInt(millis));
    }

    void back(){
        d.navigate().back();
    }
    void forward(){
        d.navigate().forward();
    }
    boolean isPresent(String xpath){
        try{
            d.findElement(By.xpath(xpath));
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    boolean clickIfExist(String xpath){
        try{
            d.findElement(By.xpath(xpath)).click();
            return true;
        }catch(org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
    }

    boolean ajax(String text){
        int i = 0;
        while(i < 10){
            if(d.getPageSource().indexOf(text)>-1)
                return true;
            i++;
            sleep(1000);
        }
        return false;
    }
    boolean ajax(String text, int sec){
        int i = 0;
        while(i < sec){
            if(d.getPageSource().indexOf(text)>-1)
                return true;
            i++;
            sleep(1000);
        }
        return false;
    }
    boolean ajaxEl(String xpath, int sec){
        int i = 0;
        while(i < sec){
            try{
                xp(xpath);
                return true;
            }catch(org.openqa.selenium.NoSuchElementException ex){
            }
            i++;
            sleep(1000);
        }
        return false;
    }

    public void forceClick(String xpath){
        Actions action = new Actions(d);
        action.moveToElement(xp(xpath));
        action.click();
        action.perform();
    }

    public void scroll(String xp){
        scroll(xp(xp));
    }
    public void scroll(WebElement el) {
        ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", el);
        sleep(500);
    }
}
