package models;

import lombok.Data;

@Data
public class GatewayResponse {

    private String message;
    private String status;
    private String ackId;

    public static PaymentResponse toPaymentResponse(GatewayResponse response) {
        return new PaymentResponse();
    }
}
