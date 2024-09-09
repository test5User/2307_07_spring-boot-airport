package by.itclass.controllers;

import by.itclass.model.entities.Flight;
import by.itclass.model.repositories.AirplaneRepository;
import by.itclass.model.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {
    private AirplaneRepository airplaneRepository;
    private FlightRepository flightRepository;

    @Autowired
    public void setAirplaneRepository(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/allFlights")
    public String getAllFlights(Model model) {
        var flights = flightRepository.findAll();
        model.addAttribute("flights", flights);
        return "flights";
    }

    @GetMapping("/addFlight")
    public String addFlight(Model model) {
        model.addAttribute("existingPlanes", airplaneRepository.findAll());
        return "add-flight";
    }

    @PostMapping("/saveFlight")
    public String saveFlight(
            @RequestParam(name = "number") String number,
            @RequestParam(name = "direction") String direction,
            @RequestParam(name = "planeId") int planeId) {
        var plane = airplaneRepository.findById(planeId).get();
        var flight = new Flight(number, direction, plane);
        flightRepository.save(flight);
        return "redirect:/allFlights";
    }
}
