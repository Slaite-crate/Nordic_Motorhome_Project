package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.interfaceRepositories.IModifierRepository;
import nordic_motorhome_project.demo.repositories.ModifierRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModifierController {
    private IModifierRepository modifierRepository;

    public ModifierController(){
        modifierRepository = new ModifierRespository();
    }
    @GetMapping("/modifier")
    public String modifierList(Model model){
        model.addAttribute("modifier",modifierRepository.readAll());
        return "/modifier/modifier";
    }
}
