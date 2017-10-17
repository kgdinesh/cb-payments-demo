package gateway;

import models.PaymentRequest;

public class GatewayPicker {

    public Gateway pick(PaymentRequest request) {
        /*
         1. filter based on feasibility (see whether gateway accepts the current payment source etc.,)
         2. filter based on runtime info (gateway stability, network conditions etc.,)
         3. If single -> return the picked Gateway
            if multiple ->
             1. rank them based on multiple dimensions (like gateway commission) and pick the first one
             2. or return the top-N to allow the system to try all gateways one by one in-case of failures
         */
        return null;
    }
}
