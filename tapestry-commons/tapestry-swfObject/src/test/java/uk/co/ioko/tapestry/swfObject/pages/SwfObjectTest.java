package uk.co.ioko.tapestry.swfObject.pages;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.test.PageTester;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA. User: ben Date: Jun 9, 2009 Time: 3:08:28 PM
 */
public class SwfObjectTest {

    /**
     * It is very hard to test this from here some selenium tests may be more in order
     *
     * @throws InterruptedException
     */
    @Test
    public void testRender() throws InterruptedException {

        PageTester pageTester = new PageTester("uk.co.ioko.tapestry.swfObject", "Swf", "src/test/webapp");
        Document document = pageTester.renderPage("SwfObjectTestPage");
        Assert.assertNotNull(document);

        String content = document.toString();

        // Check for tag -
        Assert.assertTrue(content.contains("flashVars\":{\"Cat\":\"Parsnip\",\"Vegetable\":\"Turnip\"}"));


    }

    /**
     * Testing width and height parameters with percentage values
     *
     * @throws InterruptedException
     */
    @Test
    public void testRenderWithPercentageHeightWidth() throws InterruptedException {

        PageTester pageTester = new PageTester("uk.co.ioko.tapestry.swfObject", "Swf", "src/test/webapp");
        Document document = pageTester.renderPage("SwfObjectTestPage");
        Assert.assertNotNull(document);

        String content = document.toString();

        // Check for non express install variant
        Assert.assertTrue(content.contains("\"height\":\"100%\",\"width\":\"100%\""));


    }

}
