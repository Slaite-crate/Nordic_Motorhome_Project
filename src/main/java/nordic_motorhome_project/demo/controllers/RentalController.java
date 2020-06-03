package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.models.Rental;
import nordic_motorhome_project.demo.interfaceRepositories.IRentalRepository;
import nordic_motorhome_project.demo.repositories.RentalRepository;
import nordic_motorhome_project.demo.utilities.RentalHolder;
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
    public String create(Model customer, Model motorhome) {
        if (RentalHolder.getCustomer() == null) {
            return "/error/missing";
        }
        if (RentalHolder.getMotorhome() == null) {
            return "/error/missing";
        }
        customer.addAttribute("customer", RentalHolder.getCustomer());
        motorhome.addAttribute("motorhome", RentalHolder.getMotorhome());
        return "/rental/create";
    }

    @PostMapping("/rental/realcreate")
    public String realcreate(@ModelAttribute Rental rental) {
        rentalRepository.create(rental);
        return "redirect:/rental";
    }

    @GetMapping("/rental/details")
    public String details(@RequestParam int id, Model customer, Model motorhome, Model rental){
        customer.addAttribute("customer", rentalRepository.readCustomer(id));
        motorhome.addAttribute("motorhome", rentalRepository.readMotorhome(id));
        rental.addAttribute("rental", rentalRepository.read(id));
        return "/rental/details";
    }

    @GetMapping("/rental/delete")
    public String delete(@RequestParam int id){
        rentalRepository.delete(id);
        return "redirect:/rental";
    }
}
