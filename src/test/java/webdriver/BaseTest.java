package webdriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * An abstract class that describes the basic test application contains
 * methods for logging and field test settings (options)
 */
public abstract class BaseTest extends BaseEntity{
	protected String date;
	protected String price;
	protected String diagfrom;
	protected String diagto;
	protected String maker;
	/**
	 * To override.
	 */
	public abstract void runTest();

	@Parameters({"date","price","diagfrom","diagto","maker"})
	@BeforeTest
	public void BaseTest(String date, String price, String diagfrom, String diagto, String maker){
		this.date=date;
		this.price=price;
		this.diagfrom=diagfrom;
		this.diagto=diagto;
		this.maker=maker;
	}

	/**
	 * Test
	 * @throws Throwable Throwable
	 */
	@Test
	public void xTest() throws Throwable {
		Class<? extends BaseTest> currentClass = this.getClass();

		try {
			logger.logTestName(currentClass.getName());
			browser.navigate(Browser.getBaseUrl());
			runTest();
			logger.logTestEnd(currentClass.getName());
		} catch (Throwable e) {
			
				logger.warn("");
				logger.warnRed(getLoc("loc.test.failed"));
				logger.warn("");
				logger.fatal(e.getMessage());
		}
	}

	/**
	 * Format logging
	 * @param message Message
	 * @return Message
	 */
	protected String formatLogMsg(final String message) {
		return message;
	}
}
