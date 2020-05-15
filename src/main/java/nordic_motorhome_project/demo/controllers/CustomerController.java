package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.repositories.CustomerRepositoryImpl;
import nordic_motorhome_project.demo.repositories.ICustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    private ICustomerRepository customerRepository;

    public CustomerController(){
        customerRepository = new CustomerRepositoryImpl();
    }

    @GetMapping("/customer")
    public String customer(){
        return "/customer/customer";
    }

    @GetMapping("/customer/list")
    public String customersList(Model model){
        model.addAttribute("customers",customerRepository.readAll());
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String customerCreate(){
        return "customer/create";
    }

    @PostMapping("/customer/realcreate")
    public String customerRealCreate(@ModelAttribute Customer customer){
        customerRepository.create(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/read")
    public String readCustomer(@RequestParam int id, Model model){
        model.addAttribute("customers",customerRepository.read(id));
        return "customer/read";
    }

}














