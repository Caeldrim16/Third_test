package demo.test.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.BaseForm;
import webdriver.elements.CheckBox;
import webdriver.elements.Label;
import webdriver.elements.TextBox;
import webdriver.elements.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by seregin-av on 11.10.2016.
 */
public class TVForm extends BaseForm {

    private Label lblCheck = new Label(By.xpath("//h1[contains(text(),'Телевизоры')]"), "Check TV Form");
    private TextBox txbPriceTo = new TextBox(By.xpath("//input[@placeholder='до']"), "PriceTo");
    private TextBox txbDateFrom = new TextBox(By.xpath("//input[@placeholder='2010']"), "DateFrom");
    private String diagonalFrom = "//select[contains(@data-bind, 'facet.value.from')]";
    private String diagonalTo = "//select[contains(@data-bind, 'facet.value.to')]";
    private Select sltDiagonalFrom = new Select(By.xpath(diagonalFrom), "DiagonalFrom");
    private Select sltDiagonalTo = new Select(By.xpath(diagonalTo), "DiagonalTo");
    private Select sltSubDiagonalFrom;
    private Select sltSubDiagonalTo;
    private CheckBox chbMaker;

    public TVForm() {
        super(By.xpath("//h1[contains(text(),'Телевизоры')]"), "TVForm");
    }

    public void assertTVForm(){
        assert(lblCheck.isPresent());
    }

    public void parameters(String price, String date, String diagfrom, String diagto, String maker) {

        Integer diagfromvalue = (Integer.parseInt(diagfrom)*10);
        diagfrom= diagfromvalue.toString();
        Integer diagtovalue = (Integer.parseInt(diagto)*10);
        diagto= diagtovalue.toString();
        maker = maker.toLowerCase();

        chbMaker = new CheckBox(By.xpath("//input[@value='" + maker +"']/parent::span"), "Maker");
        sltSubDiagonalFrom = new Select(By.xpath(diagonalFrom + "/option[@value='" + diagfrom + "']"), "Diagonal From");
        sltSubDiagonalTo = new Select(By.xpath(diagonalTo + "/option[@value='" + diagto + "']"), "Diagonal To");

        chbMaker.click();
        txbPriceTo.isPresent();
        txbPriceTo.type(price);

        txbDateFrom.isPresent();
        txbDateFrom.type(date);

        sltDiagonalFrom.byValue(sltSubDiagonalFrom);

        sltDiagonalTo.byValue(sltSubDiagonalTo);
        browser.timeout();
    }

    public List<WebElement> checkResults() {
        List<WebElement> results = browser.getDriver().findElements(By.xpath("//span[contains(@data-bind,'product.full_name')]"));
        return results;
    }

    public void clickOn(WebElement elem) {
        elem.click();
        browser.waitForPageToLoad();
    }
}

