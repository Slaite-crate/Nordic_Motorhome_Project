package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.models.Rental;
import nordic_motorhome_project.demo.interfaceRepositories.IRentalRepository;
import nordic_motorhome_project.demo.repositories.RentalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentalController {
    private IRentalRepository rentalRepository;

    public RentalController() {
        rentalRepository = new RentalRepository();

    }

    @GetMapping("/rental")
    public String rental(Model model) {
        model.addAttribute("rentals", rentalRepository.readAll());
        return "/rental/rental";
    }

    @GetMapping("/rental/order")
    public String rentalOrder(@RequestParam String order, Model model) {
        model.addAttribute("rentals", rentalRepository.readAll(order));
        return "/rental/rental";
    }

    @GetMapping("/rental/create")
    public String create() {
        return "/rental/create";
    }

    @PostMapping("/rental/realcreate")
    public String realcreate(@ModelAttribute Rental rental) {
        rentalRepository.create(rental);
        return "redirect:/rental";
    }
}
