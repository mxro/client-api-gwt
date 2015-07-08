package de.mxro.client.gwt;

import org.javadelight.log.js.JsLogsNode;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

import de.mxro.client.BasicClient;
import de.mxro.metrics.js.JsMetricsNode;

@Export
public class JsClient implements Exportable {

    @NoExport
    private BasicClient wrapped;

    @Export
    public JsMetricsNode metrics() {
        return JsMetricsNode.wrap(wrapped.metrics());
    }

    @Export
    public JsLogsNode logs() {
        return JsLogsNode.wrap(wrapped.logs());
    }

    @NoExport
    public static JsClient wrap(final BasicClient client) {
        final JsClient clientJs = new JsClient();

        clientJs.wrapped = client;

        return clientJs;
    }

    public JsClient() {
        super();
    }

}
