package ma.theatre.theatremanagementsystembackend.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import ma.theatre.theatremanagementsystembackend.dtos.TicketDTO;
import ma.theatre.theatremanagementsystembackend.dtos.TicketsForm;
import ma.theatre.theatremanagementsystembackend.entities.*;
import ma.theatre.theatremanagementsystembackend.mappers.TicketMapper;
import ma.theatre.theatremanagementsystembackend.repositories.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
@Slf4j
public class TheatreServiceImpl implements TheatreService {

    private final CityRepository cityRepository;
    private final TheatreRepository theatreRepository;
    private final HallRepository hallRepository;
    private final SeatRepository seatRepository;
    private final MovieRepository movieRepository;
    private final SessionRepository sessionRepository;
    private final CategoryRepository categoryRepository;
    private final MovieScreeningRepository movieScreeningRepository;
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TheatreServiceImpl(CityRepository cityRepository, TheatreRepository theatreRepository, HallRepository hallRepository, SeatRepository seatRepository, MovieRepository movieRepository, SessionRepository sessionRepository, CategoryRepository categoryRepository, MovieScreeningRepository movieScreeningRepository, TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.cityRepository = cityRepository;
        this.theatreRepository = theatreRepository;
        this.hallRepository = hallRepository;
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
        this.sessionRepository = sessionRepository;
        this.categoryRepository = categoryRepository;
        this.movieScreeningRepository = movieScreeningRepository;
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }


    @Override
    public void cities() {
//        log.info("Adding cities");
        Stream.of("Casablanca", "Tetouan", "tanger", "Marrakech").forEach(cityName -> {
            City city = new City();
            city.setName(cityName);
            cityRepository.save(city);
        });

    }

    @Override
    public void theatres() {
        cityRepository.findAll().forEach(city -> {
            Stream.of("Avenida", "IMax", "Fonoun", "Daouliz").forEach(theatreName -> {
                Theatre theatre = new Theatre();
                theatre.setName(theatreName);
//                theatre.setName(theatreName);
                theatre.setCity(city);
                theatre.setNumberOfHalls(2 + (int) (Math.random() * 3));
                theatreRepository.save(theatre);
            });
        });
    }

    @Override
    public void halls() {
        theatreRepository.findAll().forEach(theatre -> {
            for (int i = 0; i < theatre.getNumberOfHalls(); i++) {
                Hall hall = new Hall();
                hall.setName("Hall " + (i + 1));
                hall.setNumberOfPlaces(5 + (int) (Math.random() * 2));
                hall.setTheatre(theatre);
                hallRepository.save(hall);
            }
        });
    }

    @Override
    public void seats() {
        hallRepository.findAll().forEach(hall -> {
            for (int i = 0; i < hall.getNumberOfPlaces(); i++) {
                Seat seat = new Seat();
                seat.setSeatNumber(i + 1);
                seat.setHall(hall);
                seatRepository.save(seat);
            }

        });
    }

    @Override
    public void categories() {
        //Adding categories
        Stream.of("Action", "Comedy", "Drama", "Musical").forEach(s -> {
            Category category = new Category();
            category.setCategoryName(s);
            categoryRepository.save(category);
        });
    }

    @Override
    public void sessions() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("13:00", "15:00", "17:00", "19:00", "21:00", "01:00").forEach(s -> {
            Session session = new Session();
            try {

                session.setStartTime(dateFormat.parse(s));
                sessionRepository.save(session);
            } catch (ParseException e) {
                e.getStackTrace();
            }
        });

    }

    @Override
    public void movies() {
        Double[] duration = new Double[]{2.0, 2.15, 2.30, 3.0};
        List<Category> categories = categoryRepository.findAll();
        Stream.of("The Shawshank Redemption", "The Godfather", "The Dark Knight", "12 Angry Men", "The Lord of the Rings The Return of the King").forEach(movieName -> {
            Movie movie = new Movie();
            movie.setMovieName(movieName);
            movie.setDuration(duration[new Random().nextInt(duration.length)]);
            movie.setCategory(categories.get(new Random().nextInt(categories.size())));
            movie.setPicture(movieName.replaceAll(" ", ""));
            movieRepository.save(movie);
        });
    }

    @Override
    public void movieScreenings() {
        double[] prices = new double[]{40, 50, 60, 70, 80, 90};
        cityRepository.findAll().forEach(city -> {
            city.getTheatres().forEach(theatre -> {
                theatre.getHalls().forEach(hall -> {
                    movieRepository.findAll().forEach(movie -> {
                        sessionRepository.findAll().forEach(session -> {
                            MovieScreening movieScreening = new MovieScreening();
                            movieScreening.setHall(hall);
                            movieScreening.setMovie(movie);
                            movieScreening.setSession(session);
                            movieScreening.setPrice(prices[new Random().nextInt(prices.length)]);
                            movieScreeningRepository.save(movieScreening);
                        });
                    });
                });
            });
        });


    }

    @Override
    public void tickets() {
//Adding tickets
        movieScreeningRepository.findAll().forEach(ms -> {
            ms.getHall().getSeats().forEach(seat -> {
                Ticket ticket = new Ticket();
                ticket.setSeat(seat);
                ticket.setReserved(false);
                ticket.setMovieScreening(ms);
                ticket.setPrice(ms.getPrice());
                ticketRepository.save(ticket);


            });
        });
    }



    @Override
    public List<TicketDTO> payForTickets(TicketsForm ticketsForm) {
        List<TicketDTO> ticketList=new ArrayList<>();
        ticketsForm.getTickets().forEach(ticketId ->{
            Ticket ticket=ticketRepository.findById(ticketId).get();
            ticket.setReserved(true);
            ticket.setCustomerName(ticketsForm.getCustomerName());
            System.out.println(ticketsForm.getCustomerName());
            System.out.println(ticket.getCustomerName());
            ticket.setPaymentCode(ticketsForm.getPaymentCode());
            ticketRepository.save(ticket);
            TicketDTO ticketDTO=new TicketDTO();
            ticketDTO= ticketMapper.map(ticket);
            System.out.println(ticketDTO.getCustomerName());
            ticketList.add(ticketDTO);
        } );
        return ticketList;
    }

    @Override
    public byte[] getPoster(Long id) throws IOException {
        Movie movie = movieRepository.findById(id).get();
        String posterName = movie.getPicture();
        File file = new File(System.getProperty("user.home") + "/moviesPosters/" + posterName + ".jpg");
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
}

