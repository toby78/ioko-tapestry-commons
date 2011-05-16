package uk.co.ioko.tapestry.swfObject.components;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by IntelliJ IDEA. User: ben Date: Jun 8, 2009 Time: 4:22:32 PM
 */
@Import( library = { "swfobject.js", "swfobjectTapestry.js" })
public class SwfObject {

	/**
	 * The SWF to play as an asset
	 */
	@Parameter(required = true)
	private String swf;

	@Inject
	private ComponentResources resources;

	/**
	 * The width in pixels or percentage(examples: 300,100%)
	 */
	@Parameter(required = true,defaultPrefix=BindingConstants.LITERAL)
	private String width;

	/**
	 * The height in pixels or percentage(examples: 300,100%)
	 */
	@Parameter(required = true,defaultPrefix=BindingConstants.LITERAL)
	private String height;

	/**
	 * The minimum flash version. If not set the default of 10.0.22 is used.
	 */
	@Parameter
	private String version = "10.0.22";

	@Inject
	@Path("expressInstall.swf")
	private Asset expressInstall;

	@Parameter
	private Boolean useExpressInstall = true;

	/**
	 * The flash vars to pass in javascript array format
	 */
	@Parameter
	private JSONObject flashVars;

	/**
	 * The attributes to pass in javascript array format
	 */
	@Parameter
	private JSONObject attributes;

	/**
	 * The params to pass in javascript array format
	 */
	@Parameter
	private JSONObject params;

	public String getClientId() {
		return clientId;
	}

	private String clientId;

	@Environmental
	private JavaScriptSupport javascriptSupport;


	void setupRender() {

		clientId = javascriptSupport.allocateClientId(resources.getId());

		JSONObject parameters = new JSONObject();
		// 0
		parameters.put("swf", swf);
		// 1
		parameters.put("clientId", clientId);
		// 2
		parameters.put("width", width);
		//3
		parameters.put("height", height);
		// 4
		parameters.put("version", version);
		// 5
		if (useExpressInstall) {
			parameters.put("expressInstall", expressInstall.toString());
		} else {
			parameters.put("expressInstall", false);
		}
		// 6
		if (flashVars == null) {
			parameters.put("flashVars", false);
		} else {
			parameters.put("flashVars", flashVars);
		}
		//7
		if (params == null) {
			parameters.put("params", false);
		} else {
			parameters.put("params", params);
		}
		//8 
		if (attributes == null) {
			parameters.put("attributes", false);
		} else {
			parameters.put("attributes", attributes);
		}


		javascriptSupport.addInitializerCall("swfObject", parameters);

	}
}
