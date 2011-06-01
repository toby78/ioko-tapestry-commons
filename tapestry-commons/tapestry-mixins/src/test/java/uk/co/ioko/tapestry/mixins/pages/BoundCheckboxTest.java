package uk.co.ioko.tapestry.mixins.pages;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA. User: ben Date: Jul 13, 2009 Time: 12:42:10 PM
 */
public class BoundCheckboxTest extends SeleniumTestCase {

    @Test(groups = "selenium")
	public void testBoundCheckBox(){
		open(getBaseURL() + "BoundCheckboxPage");

		Assert.assertFalse(isChecked("checkbox_1"));

		click("selectAllCheckbox");

		Assert.assertTrue(isChecked("checkbox_1"));

		click("selectAllCheckbox");

		Assert.assertFalse(isChecked("checkbox_1"));

				
	}

}
