package local.leticia.airports.service; 

import java.util.List;
import local.leticia.airports.entities.Airport;
import local.leticia.airports.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll() {
        
        List<Airport> result = airportRepository.findAll();
        return result;
        
    }
    
    public List<Airport> findByCity(String city) {
    List<Airport> result = airportRepository.findByCityIgnoreCase(city);
    return result;
}
}
    