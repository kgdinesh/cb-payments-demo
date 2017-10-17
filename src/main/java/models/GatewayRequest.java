package models;

import lombok.Data;

@Data
public class GatewayRequest {

    private PaymentSource paymentSource;
    private Double amount;
    private String currency;

    //other gateway-specific fields to follow
}
