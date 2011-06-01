package uk.co.ioko.tapestry.mixins.mixins;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Checkbox;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import( library = {"jquery.tools.min.js", "boundCheckbox.js"}, stack = "Jquery")
public class BoundCheckbox {
	@InjectContainer
	private ClientElement container;

	@Parameter
	private Checkbox master;

	@Environmental
	private JavaScriptSupport renderSupport;

	@AfterRender
	void after(MarkupWriter writer) {
		String masterClientId = master == null ? "" : master.getClientId();
        JSONObject spec = new JSONObject();
        spec.put("clientId", container.getClientId());
        spec.put("masterId", masterClientId);
		renderSupport.addInitializerCall("boundCheckboxLoad", spec);
	}
}
