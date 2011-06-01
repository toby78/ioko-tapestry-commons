package uk.co.ioko.tapestry.jquery.services;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.internal.InternalConstants;
import org.apache.tapestry5.internal.services.javascript.CoreJavaScriptStack;
import org.apache.tapestry5.internal.services.javascript.DateFieldStack;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.javascript.JavaScriptStack;

/**
 * Created by IntelliJ IDEA. User: ben Date: Jul 8, 2009 Time: 4:39:50 PM
 */
public class JqueryModule {



    public static void contributeJavaScriptStackSource(MappedConfiguration<String, JavaScriptStack> configuration) {
        configuration.addInstance("jquery", JQueryStack.class);
    }

    public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration){
        configuration.add(new LibraryMapping("jquery", "uk.co.ioko.tapestry.jquery.pages"));
    }
}
