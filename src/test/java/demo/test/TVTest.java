package demo.test;

import demo.test.forms.CatalogForm;
import demo.test.forms.DescriptionForm;
import demo.test.forms.MainForm;
import demo.test.forms.TVForm;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by seregin-av on 11.10.2016.
 */
public  class TVTest extends BaseTest {

    public void runTest(){

        logger.step(1);
        MainForm mf = new MainForm();
        mf.assertMainForm();
        mf.clickOn();

        logger.step(2);
        CatalogForm cf = new CatalogForm();
        cf.assertCatalogForm();
        cf.clickOn();

        logger.step(3);
        TVForm tvf = new TVForm();
        tvf.assertTVForm();
        tvf.parameters(price, date, diagfrom, diagto, maker);

        logger.step(4);
        for(Integer i=0; i < tvf.checkResults().size(); i++){
            TVForm tvf2 = new TVForm();
            WebElement elem = tvf2.checkResults().get(i);
            tvf2.clickOn(elem);

            DescriptionForm df = new DescriptionForm();
            df.assertDescriptionForm();
            df.checkMaker(maker);

            String datew = df.checkDate();
            Integer cdate = Integer.parseInt(datew.substring(0, datew.indexOf(" ")));
            if (cdate < Integer.parseInt(date)) {
                logger.error("Incorrect date");
            }

            String diagw = df.checkDiagonal();
            Integer cdiagw = Integer.parseInt(diagw.substring(0, diagw.indexOf("\"")));
            if (cdiagw < Integer.parseInt(diagfrom) | cdiagw > Integer.parseInt(diagto)) {
                logger.error("Incorrect diagonal");
            }

            String pricew = df.checkPrice();
            pricew = pricew.replace(",",".");
            Double cprice = Double.valueOf(pricew.substring(0, pricew.indexOf(" ")));
            if (cprice > Integer.parseInt(price)) {
                logger.error("Incorrect price");
            }
            df.backToForm();
        }
    }
}
