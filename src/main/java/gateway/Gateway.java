package gateway;

import models.GatewayRequest;
import models.GatewayResponse;

public interface Gateway {


    /*
    LOGIC:
    If sync, process request and return response (success, failure) or in-case of any errors remote will throw Exception
    If async, response will be an ackId which will be a part of GatewayResponse to caller

    INSTRUMENTATION:
    instrumenting can be done on top of this method to create metrics like call-rate, success-rate (2xx),
    client-failure-rate(4xx), server-failure-rate(5xx) etc.,
    Graphs & Alerting can be done on top these metrics outputted (usually emitted via JMX and aggregated to a system like Graphite)
     */
    GatewayResponse charge(GatewayRequest request);

    /* There can be more methods that give us information about the gateway's health, which can be an input to GatewayPicker's decision algorithm */

    //boolean isHealthy();

    //boolean isLatent();
}

class Stripe implements Gateway {

    @Override
    public GatewayResponse charge(GatewayRequest request) {
        return null;
    }

}

class GoCardless implements Gateway {

    @Override
    public GatewayResponse charge(GatewayRequest request) {
        return null;
    }
}

class Braintree implements Gateway {

    @Override
    public GatewayResponse charge(GatewayRequest request) {
        return null;
    }
}