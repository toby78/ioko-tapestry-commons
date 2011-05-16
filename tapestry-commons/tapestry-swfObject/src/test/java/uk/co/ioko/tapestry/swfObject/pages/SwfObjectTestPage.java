package uk.co.ioko.tapestry.swfObject.pages;

import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import uk.co.ioko.tapestry.swfObject.components.SwfObject;

/**
 * Created by IntelliJ IDEA. User: ben Date: Jun 8, 2009 Time: 4:38:43 PM
 */
@Import(library = "readFlashStatus.js")
public class SwfObjectTestPage {

	@Property
	private JSONObject flashVars;

	@Environmental
	private JavaScriptSupport javascriptSupport;

	@Component
	private SwfObject swfObject;

	public void setupRender() {
		flashVars = new JSONObject();
		flashVars.put("Cat", "Parsnip");
		flashVars.put("Vegetable", "Turnip");

	}

	public void afterRender() {
        JSONObject spec = new JSONObject();
        spec.put("flashId", swfObject.getClientId());
        spec.put("outputId", "flashvarResults");

		javascriptSupport.addInitializerCall("readFlashStatus", spec);

	}
}
