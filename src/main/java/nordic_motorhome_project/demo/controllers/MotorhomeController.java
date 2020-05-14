package nordic_motorhome_project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorhomeController {

    @GetMapping("/motorhome")
    public String motorhome(){
        return "/motorhome/motorhome";
    }
}
