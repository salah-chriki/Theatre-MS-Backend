package ma.theatre.theatremanagementsystembackend.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "proj", types = {ma.theatre.theatremanagementsystembackend.entities.MovieScreening.class})
public interface ProjectionMovieScreening {
    public Long getScreeningId();
    public Date getScreeningDate();
    public double getPrice();

    public Hall getHall();

    public Movie getMovie();

    public List<Ticket> grtTickets();

    public Session getSession();
}
