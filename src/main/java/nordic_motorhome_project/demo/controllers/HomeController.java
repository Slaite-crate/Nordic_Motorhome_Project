package nordic_motorhome_project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { //Pelle

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
