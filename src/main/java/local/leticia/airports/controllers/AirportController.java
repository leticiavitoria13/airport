package local.leticia.airports.controllers;

import java.util.List;
import local.leticia.airports.entities.Airport;
import local.leticia.airports.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
