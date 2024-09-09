package by.itclass.controllers;

import by.itclass.model.entities.Passenger;
import by.itclass.model.repositories.FlightRepository;
import by.itclass.model.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PassengerController {
    private PassengerRepository passengerRepository;
    private FlightRepository flightRepository;

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @PostMapping("/savePass")
    public String savePass(
            @RequestParam(name = "passengerId", required = false) Integer passengerId,
            @RequestParam(name = "flightId") int flightId,
            @RequestParam(name = "fio") String fio,
            @RequestParam(name = "place") String place) {
        var flight = flightRepository.findById(flightId).get();
        var passenger = passengerId == null
                ? new Passenger(fio, place, flight)
                : new Passenger(passengerId, fio, place, flight);
        passengerRepository.save(passenger);
        return "redirect:/viewFlight/" + flightId;
    }

    @GetMapping("/delPass/{flightId}/{passengerId}")
    public String delPass(
            @PathVariable(name = "flightId") int flightId,
            @PathVariable(name = "passengerId") int passengerId) {
        passengerRepository.deleteById(passengerId);
        return "redirect:/viewFlight/" + flightId;
    }

    @GetMapping("/updPass/{id}")
    public String updPass(
            @PathVariable(name = "id") int passengerId,
            Model model) {
        model.addAttribute("passenger", passengerRepository.findById(passengerId).get());
        return "upd-pass";
    }
}
