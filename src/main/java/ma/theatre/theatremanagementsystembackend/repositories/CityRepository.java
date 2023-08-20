package ma.theatre.theatremanagementsystembackend.repositories;

import ma.theatre.theatremanagementsystembackend.entities.Category;
import ma.theatre.theatremanagementsystembackend.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CityRepository extends JpaRepository<City,Long> {
}
