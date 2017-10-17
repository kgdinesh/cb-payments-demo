package dao;

import models.Payment;
import models.PaymentSource;

public interface PaymentsDAO {

    boolean createPayment(Payment payment);

    boolean updatePayment(Payment payment);

    Payment getPayment(String paymentId);

    Payment getPaymentByAck(String ackId);

    PaymentSource getPaymentSource(String paymentSourceId);

}
