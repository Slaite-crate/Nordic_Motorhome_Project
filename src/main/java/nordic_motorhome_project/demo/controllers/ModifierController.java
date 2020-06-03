package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.interfaceRepositories.ICrud;
import nordic_motorhome_project.demo.models.Modifier;
import nordic_motorhome_project.demo.repositories.ModifierRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModifierController { //Cecilie
    private ICrud<Modifier> modifierRepository;

    public ModifierController(){
        modifierRepository = new ModifierRespository();
    }

    @GetMapping("/modifier")
    public String modifiersList(Model model){
        model.addAttribute("modifiers",modifierRepository.readAll());
        return "/modifier/modifier";
    }

    @GetMapping("/modifier/create")
    public String modifierCreate(){
        return "/modifier/create";
    }

    @PostMapping("/modifier/realcreate")
    public String modifierRealCreate(@ModelAttribute Modifier modifier){
        modifierRepository.create(modifier);
        return "redirect:/modifier";
    }

    @GetMapping("/modifier/delete")
    public String modifierDelete(@RequestParam int id){
        modifierRepository.delete(id);
        return "redirect:/modifier";
    }

    @GetMapping("/modifier/update")
    public String modifierUpdate(@RequestParam int id, Model model){
        model.addAttribute("modifier", modifierRepository.read(id));
        return "/modifier/update";
    }

    @PostMapping("/modifier/realupdate")
    public String customerRealUpdate(@ModelAttribute Modifier modifier){
        modifierRepository.update(modifier);
        return "redirect:/modifier";
    }
}
