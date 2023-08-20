package ma.theatre.theatremanagementsystembackend.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class TicketsForm {
    String customerName;
    int paymentCode;
    List<Long> tickets = new ArrayList<>();

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(int paymentCode) {
        this.paymentCode = paymentCode;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }
}
