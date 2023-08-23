package ma.theatre.theatremanagementsystembackend;

import ma.theatre.theatremanagementsystembackend.entities.Hall;
import ma.theatre.theatremanagementsystembackend.entities.Movie;
import ma.theatre.theatremanagementsystembackend.services.TheatreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class TheatreManagementSystemBackendApplication implements CommandLineRunner {
    private final TheatreService theatreService;
    private final RepositoryRestConfiguration restConfiguration;

    public TheatreManagementSystemBackendApplication(TheatreService theatreService, RepositoryRestConfiguration restConfiguration) {
        this.theatreService = theatreService;
        this.restConfiguration = restConfiguration;
    }

    public static void main(String[] args) {
        SpringApplication.run(TheatreManagementSystemBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Movie.class, Hall.class);
        theatreService.cities();
        theatreService.theatres();
        theatreService.halls();
        theatreService.seats();
        theatreService.sessions();
        theatreService.categories();
        theatreService.movies();
        theatreService.movieScreenings();
        theatreService.tickets();
    }
}
