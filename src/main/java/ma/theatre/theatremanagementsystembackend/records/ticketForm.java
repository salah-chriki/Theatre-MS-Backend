package ma.theatre.theatremanagementsystembackend.records;

import ma.theatre.theatremanagementsystembackend.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public record ticketForm(String clientName,
                         List<Ticket> tickets) {

}
