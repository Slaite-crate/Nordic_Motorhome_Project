package nordic_motorhome_project.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class RentalController {

    @GetMapping("/rental")
    public String rental(){
        return "/rental/rental";
    }
}
