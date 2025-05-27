package local.leticia.airports.service; 

import java.util.List;
import local.leticia.airports.DTO.AirportMinDTO;
import local.leticia.airports.DTO.AirportNearMeDTO;
import local.leticia.airports.entities.Airport;
import local.leticia.airports.projections.AirportNearMeProjection;
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
    public List<AirportMinDTO> findByCountry(String country) {
       List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
    
       List<AirportMinDTO> resultDTO = resultAirport.stream()
               .map(x -> new AirportMinDTO(x)).toList();
       
       return resultDTO;
}
    public Airport findByIataCode(String iataCode) {
        Airport result = airportRepository.findByIataCode(iataCode);
        return result;
    }
   
    public List<AirportNearMeDTO> findNearMe(double latitude, double longitude) {
    List<AirportNearMeProjection> resultNearAirports = airportRepository.findNearMe(latitude, longitude);

    List<AirportNearMeDTO> resultDTO = resultNearAirports.stream()
        .map(x -> new AirportNearMeDTO(x)).toList();

    return resultDTO;
}

}

    