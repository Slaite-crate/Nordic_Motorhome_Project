package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.interfaceRepositories.ICrud;
import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.repositories.CustomerRepositoryImpl;
import nordic_motorhome_project.demo.utilities.RentalHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController { //Cecilie og Pelle
    private ICrud<Customer> customerRepository;

    public CustomerController() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @GetMapping("/customer")
    public String customersList(Model model) {
        model.addAttribute("customers", customerRepository.readAll());
        return "/customer/customer";
    }

    @GetMapping("/customer/create")
    public String customerCreate() {
        return "/customer/create";
    }

    @PostMapping("/customer/realcreate")
    public String customerRealCreate(@ModelAttribute Customer customer) {
        if(customerRepository.create(customer)){
            return "redirect:/customer";
        }
        else {
            return "/error/wrong_input";
        }
    }

    @GetMapping("/customer/details")
    public String customerDetails(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerRepository.read(id));
        return "/customer/details";
    }

    @GetMapping("/customer/delete")
    public String customerDelete(@RequestParam int id) {
        customerRepository.delete(id);
        return "redirect:/customer";
    }

    @GetMapping("/customer/update")
    public String customerUpdate(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerRepository.read(id));
        return "/customer/update";
    }

    @PostMapping("/customer/realupdate")
    public String customerRealUpdate(@ModelAttribute Customer customer) {
        customerRepository.update(customer);
        return "redirect:/customer";
    }

    @PostMapping("/customer/selectcustomer")
    public String selectCustomer(@ModelAttribute Customer customer){
        RentalHolder.setCustomer(customer);
        return "redirect:/customer";
    }
}














