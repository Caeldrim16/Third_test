package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import webdriver.elements.*;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

/**
 * Class, Describing element button
 */
public class Select extends BaseElement{

    /**
     *
     * @param locator
     * @param name
     */
    public Select(final By locator, final String name) {
        super(locator, name);
    }

    public Select(String string, String name) {
    	 super(string, name);
	}

	protected String getElementType() {
        return getLoc("loc.selecting.value");
    }

	public Select(By locator) {
		super(locator);
	}

    public Boolean isSelect(){
        String s = locator.toString();
        if (s.contains("select")){
            return true;
        }
            else return false;
    }

    public void byValue(Select subElement) {
        if (isSelect())
        waitForIsElementPresent();
        subElement.click();
    }
}
