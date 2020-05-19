package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.repositories.CustomerRepositoryImpl;
import nordic_motorhome_project.demo.repositories.ICustomerRepository;
import nordic_motorhome_project.demo.repositories.IRentalRepository;
import nordic_motorhome_project.demo.repositories.RentalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentalController {

    private IRentalRepository rentalRepository;
    private ICustomerRepository customerRepository;

    public RentalController(){
        rentalRepository = new RentalRepository();
        customerRepository = new CustomerRepositoryImpl();
    }

    @GetMapping("/rental")
    public String rental(Model model){
        model.addAttribute("customers", rentalRepository.readAllCustomers());
        return "/rental/rental";
    }

    @GetMapping("/rental/details")
    public String rentalDetails(@RequestParam int id, Model modelCustomer, Model modelMotorhome){
        modelCustomer.addAttribute("customer", customerRepository.read(id));
        modelMotorhome.addAttribute("motorhomes", rentalRepository.readMotorhomes(id));
        return "/rental/details";
    }
}
