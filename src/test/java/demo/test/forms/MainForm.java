package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by seregin-av on 10.10.2016.
 */
public class MainForm extends BaseForm {

    private Label lblCheck = new Label(By.xpath("//h2/a[contains(text(),'Люди')]"),"Check Main Form");
    private Label lblCatalog = new Label (By.xpath("//span[contains(text(),'Каталог')]"),"Catalog");

    public MainForm() {
        super(By.xpath("//h2/a[contains(text(),'Люди')]"), "MainForm");
    }

    public void assertMainForm(){
        assert(lblCheck.isPresent());
    }

    public void clickOn() {
        lblCatalog.click();
        browser.waitForPageToLoad();
    }
}
