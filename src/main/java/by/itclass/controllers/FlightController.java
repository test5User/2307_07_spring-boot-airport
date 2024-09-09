package by.itclass.controllers;

import by.itclass.model.entities.Flight;
import by.itclass.model.repositories.AirplaneRepository;
import by.itclass.model.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "number") String number,
            @RequestParam(name = "direction") String direction,
            @RequestParam(name = "planeId") int planeId) {
        var plane = airplaneRepository.findById(planeId).get();
        var flight = id == null
                ? new Flight(number, direction, plane)
                : new Flight(id, number, direction, plane);
        flightRepository.save(flight);
        return "redirect:/allFlights";
    }

    @GetMapping("/viewFlight/{id}")
    public String viewFlight(
            @PathVariable(name = "id") int flightId,
            Model model) {
        model.addAttribute("flight", flightRepository.findById(flightId).get());
        return "flight-info";
    }

    @GetMapping("/delFlight/{id}")
    public String delFlight(@PathVariable(name = "id") int id) {
        flightRepository.deleteById(id);
        return "redirect:/allFlights";
    }

    @GetMapping("/updFlight/{id}")
    public String updFlight(@PathVariable(name = "id") int id,
                            Model model) {
        var updFlight = flightRepository.findById(id).get();
        model.addAttribute("updFlight", updFlight);
        model.addAttribute("currentPlanes", airplaneRepository.findAll());
        return "upd-flight";
    }

}
