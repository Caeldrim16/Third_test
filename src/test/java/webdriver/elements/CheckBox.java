package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


/**
 * The class that describes an input field
 */
public class CheckBox extends BaseElement {

	/**
	 * Constructor
	 * @param locator locator
	 * @param name name
	 */
	public CheckBox(final By locator, final String name) {
		super(locator, name);
	}

	/**
	 * Constructor
	 * @param string locator
	 * @param name name
	 */
	public CheckBox(final String string, final String name) {
		super(string, name);
	}

	/**
	 * Returns Element type
	 * @return Element type
	 */
	protected String getElementType() {
		return getLoc("loc.checkbox");
	}

	/**
	 * Constructor
	 * @param locator locator
	 */
	public CheckBox(final By locator) {
		super(locator);
	}

	/**
	 * Choose the element in checkbox
	 */
	public void setChecked() {
		waitForIsElementPresent();
		if (!isChecked())
			element.click();
	}

	/**
	 * Gets value of selected
	 * @return isSelected
	 */
	public Boolean isChecked() {
		waitForIsElementPresent();
		return element.isSelected();
	}
}
