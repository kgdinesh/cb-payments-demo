package models;

public class PaymentSource {
    private String sourceId;
    private PaymentSourceType sourceType;

    enum PaymentSourceType {
        CREDIT_CARD, DEBIT_CARD, DEBIT_ACCOUNT, BITCOIN, PAYPAL, UPI
    }

}
