package local.leticia.airports.controllers;

import java.util.List;
import local.leticia.airports.DTO.AirportMinDTO;
import local.leticia.airports.DTO.AirportNearMeDTO;
import local.leticia.airports.entities.Airport;
import local.leticia.airports.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author ppjatb
 */
@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
        
    }
    
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);
        
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
            
        } else {
            return ResponseEntity.ok(result);
        }
        
  }
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName){
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        
        if(result.isEmpty()){
            
            return ResponseEntity.notFound().build();
        
        } else{
        
            return ResponseEntity.ok(result);
        }
    
    }
     @GetMapping("/iatacode/{iataCode}")
     public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
         Airport result = airportService.findByIataCode(iataCode);
         
         if (result == null) {
             
             return ResponseEntity.notFound().build();
             
         } else {
             
             return ResponseEntity.ok(result);
         }
     }
  
@GetMapping("/nearme")
public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
    @RequestParam double latitude,
    @RequestParam double longitude ) {

    List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);

    if (result.isEmpty()) {
        
        return ResponseEntity.notFound().build();
    } else {
       
        return ResponseEntity.ok(result);
    }
}

}