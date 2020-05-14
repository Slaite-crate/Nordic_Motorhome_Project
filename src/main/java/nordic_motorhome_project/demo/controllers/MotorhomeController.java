package nordic_motorhome_project.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class MotorhomeController {

    @GetMapping("/motorhome")
    public String motorhome(){
        return "/motorhome/motorhome";
    }
}
