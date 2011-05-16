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
	 * @throws InterruptedException
	 */
	@Test
	public void testRender() throws InterruptedException {

		PageTester pageTester = new PageTester("uk.co.ioko.tapestry.swfObject", "Swf", "src/test/webapp");
		Document document = pageTester.renderPage("SwfObjectTestPage");
		Assert.assertNotNull(document);

		String content = document.toString();

		// Check for non express install variant
		Assert.assertTrue(content.contains("\"loadSwfObject\":[{\"flashVars\":{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]},\"height\":\"300\",\"width\":\"300\",\"expressInstall\":\"/foo/assets/2912c607572e5cce/ioko/components/expressInstall.swf\",\"attributes\":false,\"params\":false,\"swf\":\"/assets/app/1.0/pages/SwfObjectTest.swf\",\"clientId\":\"swfObject\",\"version\":\"10.0.22\"},{\"flashVars\":{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]},\"height\":\"300\",\"width\":\"300\",\"expressInstall\":\"/foo/assets/2912c607572e5cce/ioko/components/expressInstall.swf\",\"attributes\":false,\"params\":false,\"swf\":\"/foo/assets/2912c607572e5cce/ioko/pages/SwfObjectTest.swf\",\"clientId\":\"swfObject2\",\"version\":\"10.0.22\"},{\"flashVars\":false,\"height\":\"100%\",\"width\":\"100%\",\"expressInstall\":false,\"attributes\":{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]},\"params\":{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]},\"swf\":\"/assets/app/1.0/pages/SwfObjectTest.swf\",\"clientId\":\"swfObject3\",\"version\":\"10.0.22\"},{\"flashVars\":false,\"height\":\"300\",\"width\":\"300\",\"expressInstall\":false,\"attributes\":{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]},\"params\":{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]},\"swf\":\"/assets/app/1.0/pages/SwfObjectTest.swf\",\"clientId\":\"swfObjectVariant\",\"version\":\"10.0.22\"}]}"));
		
		
	}
	
	/**
	 * Testing width and height parameters with percentage values
	 * @throws InterruptedException
	 */
	@Test
	public void testRenderWithPercentageHeightWidth() throws InterruptedException {

		PageTester pageTester = new PageTester("uk.co.ioko.tapestry.swfObject", "Swf", "src/test/webapp");
		Document document = pageTester.renderPage("SwfObjectTestPage");
		Assert.assertNotNull(document);

		String content = document.toString();

		// Check for non express install variant
		Assert.assertTrue(content.contains("[\"/assets/app/1.0/pages/SwfObjectTest.swf\",\"swfObject3\",\"100%\",\"100%\",\"10.0.22\",false,false,{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]},{\"Cat\":[\"Parsnip\"],\"Vegetable\":[\"Turnip\"]}]"));
		
		
	}

}
