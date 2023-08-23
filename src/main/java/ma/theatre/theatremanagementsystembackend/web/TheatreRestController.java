package ma.theatre.theatremanagementsystembackend.web;

import ma.theatre.theatremanagementsystembackend.dtos.TicketDTO;
import ma.theatre.theatremanagementsystembackend.dtos.TicketsForm;
import ma.theatre.theatremanagementsystembackend.mappers.TicketMapper;
import ma.theatre.theatremanagementsystembackend.repositories.MovieRepository;
import ma.theatre.theatremanagementsystembackend.repositories.TicketRepository;
import ma.theatre.theatremanagementsystembackend.services.TheatreService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TheatreRestController {

    private final TheatreService theatreService;

    public TheatreRestController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping(path = "moviesPoster/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPoster(@PathVariable(name = "id") Long id) throws IOException {
        return theatreService.getPoster(id);
    }

    @PostMapping("/payTickets")
    public List<TicketDTO> payTickets(@RequestBody TicketsForm ticketsForm) {
        return theatreService.payForTickets(ticketsForm);
    }
}
