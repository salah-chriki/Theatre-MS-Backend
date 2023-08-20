package ma.theatre.theatremanagementsystembackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    @Column(length=28)
    private String customerName;
    private double price;
//    @Column(unique = true,nullable = true)
    private Integer paymentCode;
    private boolean reserved;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private MovieScreening movieScreening;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(Integer paymentCode) {
        this.paymentCode = paymentCode;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public MovieScreening getMovieScreening() {
        return movieScreening;
    }

    public void setMovieScreening(MovieScreening movieScreening) {
        this.movieScreening = movieScreening;
    }
}
