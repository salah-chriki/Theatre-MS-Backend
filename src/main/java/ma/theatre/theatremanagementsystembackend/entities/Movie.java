package ma.theatre.theatremanagementsystembackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @Column(length=80)
    private String movieName;
    private double duration;
    private String movieDescription;
    private String picture;
    private Date releaseDate;
    @Column(length=80)
    private String director;
    @OneToMany(mappedBy = "movie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<MovieScreening> movieScreening;
    @ManyToOne
    private Category category;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<MovieScreening> getMovieScreening() {
        return movieScreening;
    }

    public void setMovieScreening(List<MovieScreening> movieScreening) {
        this.movieScreening = movieScreening;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
