package de.mxro.client.gwt;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

import de.mxro.client.Client;
import de.mxro.metrics.js.JsMetricsNode;
import de.mxro.metrics.js.MetricsJs;

@Export
public class ClientJs implements Exportable {

    private Client wrapped;

    public MetricsJs metrics() {
        return JsMetricsNode.wrap(wrapped.metrics());
    }

    @NoExport
    public static ClientJs wrap(final Client client) {
        final ClientJs clientJs = new ClientJs();

        clientJs.wrapped = client;

        return clientJs;
    }

    public ClientJs() {
        super();
    }

}
