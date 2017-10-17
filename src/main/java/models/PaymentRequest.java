package models;

import lombok.Data;

@Data
public class PaymentRequest {

    private String paymentId;
    private String paymentSourceId;
    private PaymentSource paymentSource;
    private Double amount;
    private String currency;

    public static GatewayRequest toGatewayRequest(PaymentRequest request) {
        return new GatewayRequest();
    }
}
