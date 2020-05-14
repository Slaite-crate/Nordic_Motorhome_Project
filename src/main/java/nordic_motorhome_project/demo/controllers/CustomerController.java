package nordic_motorhome_project.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class CustomerController {

    @GetMapping("/customer")
    public String customer(){
        return "/customer/customer";
    }
}
