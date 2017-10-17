package processor;

import dao.PaymentsDAO;
import gateway.Gateway;
import gateway.GatewayPicker;
import lombok.AllArgsConstructor;
import models.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@AllArgsConstructor
@Path("/chargebee")
public class PaymentProcessor {

    private final GatewayPicker gatewayPicker;

    private final PaymentsDAO paymentsDAO;

    @POST
    @Path("/process")
    public PaymentResponse process(PaymentRequest request) {

        //fetch the payment-source from DB if ID is provided in request
        if (request.getPaymentSourceId() != null) {
            PaymentSource paymentSource = paymentsDAO.getPaymentSource(request.getPaymentSourceId());
            request.setPaymentSource(paymentSource);
        }

        //pick the gateway
        Gateway pickedGateway = gatewayPicker.pick(request);

        //pojo transformations
        GatewayRequest gatewayRequest = PaymentRequest.toGatewayRequest(request);

        //charge using the gateway
        GatewayResponse response = pickedGateway.charge(gatewayRequest);

        //pojo transformations
        PaymentResponse paymentResponse = GatewayResponse.toPaymentResponse(response);

        //persist response into DB (assuming payment creation is done by upstream system)
        Payment payment = paymentsDAO.getPayment(request.getPaymentId());

        //Update Payment based on info from PaymentResponse & Payment
        paymentsDAO.updatePayment(payment);

        //return to UI
        return paymentResponse;
    }

    /*
     This Endpoint will be used in case of async payment modes
     */
    @POST
    @Path("/callback")
    public boolean handleCallback(PaymentAck paymentAck) {

        //retrieve the original payment
        String ackId = paymentAck.getAckId();
        Payment payment = paymentsDAO.getPaymentByAck(ackId);

        //Update Payment based on info from PaymentAck (whether success or failure)

        //Save updated Payment back to DB
        paymentsDAO.updatePayment(payment);

        return true;
    }

}
