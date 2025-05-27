package local.leticia.airports.repositories;


import java.util.List;
import local.leticia.airports.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface AirportRepository  extends JpaRepository<Airport, Long> {
    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String country);
    
}
