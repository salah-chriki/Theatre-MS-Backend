package ma.theatre.theatremanagementsystembackend.entities;

import jakarta.persistence.*;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj",types = {ma.theatre.theatremanagementsystembackend.entities.Ticket.class})
public interface ProjectionTicket {
    public Long getTicketId();
    public String getCustomerName();
    public double getPrice();
    public Integer getPaymentCode();
    public boolean getReserved();
    public Seat getSeat();
}
