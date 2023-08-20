package ma.theatre.theatremanagementsystembackend;

import ma.theatre.theatremanagementsystembackend.services.TheatreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheatreManagementSystemBackendApplication implements CommandLineRunner {
    private final TheatreService theatreService;

    public TheatreManagementSystemBackendApplication(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TheatreManagementSystemBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
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

//    @Bean
//    CommandLineRunner commandLineRunner(CityRepository cityRepository,
//                                        TheatreRepository theatreRepository,
//                                        HallRepository hallRepository,
//                                        SeatRepository seatRepository,
//                                        MovieRepository movieRepository,
//                                        SessionRepository sessionRepository,
//                                        CategoryRepository categoryRepository,
//                                        MovieScreeningRepository movieScreeningRepository,
//                                        TicketRepository ticketRepository) {
//        return args -> {
//            //Adding cities
//            Stream.of("Casablanca", "Tetouan", "tanger", "Marrakech").forEach(cityName -> {
//                City city = new City();
//                city.setName(cityName);
//                cityRepository.save(city);
//            });
//
//            cityRepository.findAll().forEach(city -> {
//                Stream.of("Avenida", "IMax", "Fonoun", "Daouliz").forEach(theatreName -> {
//                    Theatre theatre = new Theatre();
//                    theatre.setName(theatreName);
//                    theatre.setCity(city);
//                    theatre.setNumberOfHalls(2 + (int) (Math.random() * 6));
//                    theatreRepository.save(theatre);
//                });
//            });
//
////Adding halls
//            theatreRepository.findAll().forEach(theatre -> {
//                for (int i = 0; i < theatre.getNumberOfHalls(); i++) {
//                    Hall hall = new Hall();
//                    hall.setName("Hall " + (i + 1));
//                    hall.setNumberOfPlaces(20 + (int) (Math.random() * 5));
//                    hall.setTheatre(theatre);
//                    hallRepository.save(hall);
//                }
//            });
////Adding Seats
//            hallRepository.findAll().forEach(hall -> {
//                for (int i = 0; i < hall.getNumberOfPlaces(); i++) {
//                    Seat seat = new Seat();
//                    seat.setSeatNumber(i + 1);
//                    seat.setHall(hall);
//                    seatRepository.save(seat);
//                }
//
//            });
////Adding sessions
//            DateFormat dateFormat = new SimpleDateFormat();
//            Stream.of("13:00", "15:00", "17:00", "19:00", "21:00", "01:00").forEach(s -> {
//                Session session = new Session();
//                try {
//                    session.setStartTime(dateFormat.parse(s));
//                    sessionRepository.save(session);
//                } catch (ParseException e) {
//                    e.getStackTrace();
//                }
//            });
//            //Adding categories
//            Stream.of("Action", "Comedy", "Drama", "Musical").forEach(s -> {
//                Category category = new Category();
//                category.setCategoryName(s);
//                categoryRepository.save(category);
//            });
//            //Adding movies
//            Double[] duration = new Double[]{2.0, 2.15, 2.30, 3.0};
//            List<Category> categories = categoryRepository.findAll();
//            Stream.of("The Shawshank Redemption", "The Godfather", "The Dark Knight", "Angry Men", "The Lord of the Rings: The Return of the King").forEach(movieName -> {
//                Movie movie = new Movie();
//                movie.setMovieName(movieName);
//                movie.setDuration(duration[new Random().nextInt(duration.length)]);
//                movie.setCategory(categories.get(new Random().nextInt(categories.size())));
//                movie.setPicture(movieName.replaceAll(" ", "_"));
//                movieRepository.save(movie);
//            });
//            //Adding movieScreening
//            double[] prices = new double[]{40, 50, 60, 70, 80, 90};
//            cityRepository.findAll().forEach(city -> {
//                city.getTheatres().forEach(theatre -> {
//                    theatre.getHalls().forEach(hall -> {
//                        movieRepository.findAll().forEach(movie -> {
//                            sessionRepository.findAll().forEach(session -> {
//                                MovieScreening movieScreening = new MovieScreening();
//                                movieScreening.setHall(hall);
//                                movieScreening.setMovie(movie);
//                                movieScreening.setSession(session);
//                                movieScreening.setPrice(prices[new Random().nextInt(prices.length)]);
//                                movieScreeningRepository.save(movieScreening);
//                            });
//                        });
//                    });
//                });
//            });
//
//            //Adding tickets
//            movieScreeningRepository.findAll().forEach(movieScreening -> {
//                movieScreening.getHall().getSeats().forEach(seat -> {
//                    Ticket ticket = new Ticket();
//                    ticket.setSeat(seat);
//                    ticket.setReserved(false);
//                    ticket.setMovieScreening(movieScreening);
//                    ticket.setPrice(movieScreening.getPrice());
//                    ticketRepository.save(ticket);
//
//
//                });
//            });
//
//
//        };
//    }
}
