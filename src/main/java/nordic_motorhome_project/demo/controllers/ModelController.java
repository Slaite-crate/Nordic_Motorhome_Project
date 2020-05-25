package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.repositories.IMotorhomeRepository;
import nordic_motorhome_project.demo.repositories.MotorhomeRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModelController {
    private IMotorhomeRepository motorhomeRepository;

    public ModelController(){
        motorhomeRepository = new MotorhomeRepositoryImpl();
    }

    @GetMapping("/model/model")
    public String motorhomeModel(Model model){
        model.addAttribute("models", motorhomeRepository.readAllModels());
        return "model/model";
    }

}
