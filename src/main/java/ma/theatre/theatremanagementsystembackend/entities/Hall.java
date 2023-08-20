package ma.theatre.theatremanagementsystembackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallId;
    @Column(length=40)
    private String name;
    private int numberOfPlaces;
    @ManyToOne
    private Theatre theatre;
    @OneToMany(mappedBy = "hall")
    private List<Seat> seats;
    @OneToMany(mappedBy = "hall")
    private List<MovieScreening> movieScreening;

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<MovieScreening> getMovieScreening() {
        return movieScreening;
    }

    public void setMovieScreening(List<MovieScreening> movieScreening) {
        this.movieScreening = movieScreening;
    }
}
