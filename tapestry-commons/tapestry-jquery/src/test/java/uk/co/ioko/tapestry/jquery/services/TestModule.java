package uk.co.ioko.tapestry.jquery.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;

/**
 * Created by IntelliJ IDEA. User: ben Date: Jul 9, 2009 Time: 8:14:44 AM
 */
@SubModule({JqueryModule.class})
public class TestModule {

	public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {

		configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0");
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
	
	}

}