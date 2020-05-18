package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.repositories.IRentalRepository;
import nordic_motorhome_project.demo.repositories.RentalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RentalController {

    private IRentalRepository rentalRepository;

    public RentalController(){
        rentalRepository = new RentalRepository();
    }

    @GetMapping("/rental")
    public String rental(Model model){
        model.addAttribute("customers", rentalRepository.readAllCustomers());
        return "/rental/rental";
    }
}
