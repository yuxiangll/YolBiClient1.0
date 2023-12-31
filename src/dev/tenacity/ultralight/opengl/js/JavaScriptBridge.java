package dev.tenacity.ultralight.opengl.js;

import com.labymedia.ultralight.UltralightView;
import com.labymedia.ultralight.databind.Databind;
import com.labymedia.ultralight.databind.DatabindConfiguration;
import com.labymedia.ultralight.javascript.JavascriptContext;
import com.labymedia.ultralight.javascript.JavascriptGlobalContext;
import com.labymedia.ultralight.javascript.JavascriptObject;
import dev.tenacity.ultralight.opengl.util.ViewContextProvider;

@SuppressWarnings("unused")
public class JavaScriptBridge {
    private final Databind databind;

    public JavaScriptBridge(UltralightView view) {
        databind = new Databind(DatabindConfiguration
                .builder()
                .contextProviderFactory(new ViewContextProvider.Factory(view))
                .build()
        );

    }

    public void setContext(Object object, String name, JavascriptContext context) {
        JavascriptGlobalContext globalContext = context.getGlobalContext();
        JavascriptObject globalObject = globalContext.getGlobalObject();
        globalObject.setProperty(name, databind.getConversionUtils().toJavascript(context, object), 0);
    }
}
