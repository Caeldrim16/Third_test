package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by seregin-av on 10.10.2016.
 */
public class CatalogForm extends BaseForm{
    private Label lblCheck = new Label(By.xpath("//span[contains(text(),'Электроника')]"), "Check Catalog Form");
    private Label lblTV = new Label (By.xpath("//li/a[contains(text(),'Телевизоры')]"),"TV");

    public CatalogForm() {
        super(By.xpath("//span[contains(text(),'Электроника')]"), "CatalogForm");
    }

    public void assertCatalogForm(){
        assert(lblCheck.isPresent());
    }

    public void clickOn() {
        lblTV.click();
        browser.waitForPageToLoad();
    }
}
