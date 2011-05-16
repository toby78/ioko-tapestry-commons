/*
 * Copyright (c) 2009 ioko365 Ltd
 *
 * This file is part of ioko tapestry-commons.
 *
 *     Foobar is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Foobar is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with ioko tapestry-commons.  If not, see <http://www.gnu.org/licenses/>.
 */

package uk.co.ioko.tapestry.caching.services;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.FieldFocusPriority;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Proxy class for RenderSupport that records all methods called on it. This is so we can 'playback' method calls for
 * cached components.
 * 
 * @author seldred
 */
public class RenderSupportRecorder extends SupportRecorder implements RenderSupport {

	@SuppressWarnings({"deprecation"})
    private RenderSupport renderSupport;

	public RenderSupportRecorder(RenderSupport renderSupport) {
		this.renderSupport = renderSupport;
	}

	// == IMPLEMENT ALL METHODS IN RENDER SUPPORT ==

	@SuppressWarnings({"deprecation"})
    public void addClasspathScriptLink(String... classpaths) {
		Method method = getMethod("addClasspathScriptLink", String[].class);
		recordMethodCall(method, new Object[] { classpaths });
		renderSupport.addClasspathScriptLink(classpaths);
	}

    @SuppressWarnings({"deprecation"})
	public void addInit(String functionName, JSONArray parameterList) {
		Method method = getMethod("addInit", String.class, JSONArray.class);
		recordMethodCall(method, functionName, parameterList);
		renderSupport.addInit(functionName, parameterList);
	}

    @SuppressWarnings({"deprecation"})
	public void addInit(String functionName, JSONObject parameter) {
		Method method = getMethod("addInit", String.class, JSONObject.class);
		recordMethodCall(method, functionName, parameter);
		renderSupport.addInit(functionName, parameter);
	}

    @SuppressWarnings({"deprecation"})
	public void addInit(String functionName, String... parameters) {
		Method method = getMethod("addInit", String.class, String[].class);
		recordMethodCall(method, functionName, parameters);
		renderSupport.addInit(functionName, parameters);
	}

    @SuppressWarnings({"deprecation"})
	public void addScript(String format, Object... arguments) {
		Method method = getMethod("addScript", String.class, Object[].class);
		recordMethodCall(method, format, arguments);
		renderSupport.addScript(format, arguments);
	}

    @SuppressWarnings({"deprecation"})
	public void addScript(String script) {
		Method method = getMethod("addScript", String.class);
		recordMethodCall(method, script);
		renderSupport.addScript(script);
	}

    @SuppressWarnings({"deprecation"})
	public void addScriptLink(Asset... scriptAssets) {
		List<String> assets = new ArrayList<String>();
		for (Asset asset : scriptAssets) {
			assets.add(asset.toClientURL());
		}
		addScriptLink(assets.toArray(new String[assets.size()]));
	}

    @SuppressWarnings({"deprecation"})
    public void addScriptLink(String... scriptURLs) {
		Method method = getMethod("addScriptLink", String[].class);
		recordMethodCall(method, new Object[] { scriptURLs });
		renderSupport.addScriptLink(scriptURLs);
	}

	public void addStylesheetLink(Asset stylesheet, String media) {
		addStylesheetLink(stylesheet.toClientURL(), media);
	}

	public void addStylesheetLink(String stylesheetURL, String media) {
		Method method = getMethod("addStylesheetLink", String.class, String.class);
		recordMethodCall(method, stylesheetURL, media);
		renderSupport.addStylesheetLink(stylesheetURL, media);
	}

    @SuppressWarnings({"deprecation"})
	public String allocateClientId(ComponentResources resources) {
		return allocateClientId(resources.getId());
	}

    @SuppressWarnings({"deprecation"})
	public String allocateClientId(String id) {
		Method method = getMethod("allocateClientId", String.class);
		recordMethodCall(method, id);
		return renderSupport.allocateClientId(id);
	}

	public void autofocus(FieldFocusPriority priority, String fieldId) {
		Method method = getMethod("autofocus", FieldFocusPriority.class, String.class);
		recordMethodCall(method, priority, fieldId);
		renderSupport.autofocus(priority, fieldId);
	}

	// =============================================

    @SuppressWarnings({"deprecation"})
	private Method getMethod(String name, Class<?>... parameterTypes) {
		return super.getMethod(RenderSupport.class, name, parameterTypes);
	}
}