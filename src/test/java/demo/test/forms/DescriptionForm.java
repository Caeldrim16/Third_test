package demo.test.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.BaseForm;
import webdriver.elements.BaseElement;
import webdriver.elements.Label;

/**
 * Created by seregin-av on 11.10.2016.
 */
public class DescriptionForm extends BaseForm {

    private Label lblMaker;
    private RemoteWebDriver driver = browser.getDriver();
    private Label lblCheck = new Label(By.xpath("//h3[contains(text(),'Описание')]"), "Check Description Form");
    private Label lblPrice = new Label(By.xpath("//a[contains(@class, 'price') and contains(@class, 'primary')]"), "Price");
    private Label lblDiagonal = new Label(By.xpath("//td[contains(text(),'Диагональ экрана')]/following-sibling::td/span"), "Diagonal");
    private Label lblDate = new Label(By.xpath("//td[contains(text(),'Дата выхода на рынок')]/following-sibling::td/span"), "Date");

    public DescriptionForm() {
        super(By.xpath("//h3[contains(text(),'Описание')]"), "DescriptionForm");
    }

    public void assertDescriptionForm(){
        assert(lblCheck.isPresent());
    }

    public void checkMaker(String maker) {
        lblMaker = new Label(By.xpath("//h2[contains(text(), '"+ maker +"')]"),"Maker");
        lblMaker.isPresent();
    }

    public String checkPrice() {
        return lblPrice.getText();
    }

    public String checkDate() {
        return lblDate.getText();
    }

    public String checkDiagonal() {
        return lblDiagonal.getText();
    }

    public void backToForm() {
        driver.navigate().back();
        browser.waitForPageToLoad();
    }
}
