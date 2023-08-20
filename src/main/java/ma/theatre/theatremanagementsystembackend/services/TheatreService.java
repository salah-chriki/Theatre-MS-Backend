package ma.theatre.theatremanagementsystembackend.services;

import ma.theatre.theatremanagementsystembackend.dtos.TicketDTO;
import ma.theatre.theatremanagementsystembackend.dtos.TicketsForm;

import java.io.IOException;
import java.util.List;

public interface TheatreService {
    void cities();
    void theatres();

    void halls();
    void seats();
    void categories();
    void sessions();
    void movies();
    void movieScreenings();
    void tickets();

    List<TicketDTO> payForTickets(TicketsForm ticketsForm);

    byte[] getPoster(Long id) throws IOException;
}
