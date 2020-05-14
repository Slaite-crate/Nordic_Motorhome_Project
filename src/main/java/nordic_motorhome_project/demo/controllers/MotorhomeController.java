package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.repositories.ICustomerRepository;
import nordic_motorhome_project.demo.repositories.IMotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MotorhomeController {

    private IMotorhomeRepository MotorhomeRepository;

    @GetMapping("/motorhome")
    public String motorhome(){
        return "/motorhome/motorhome";
    }

    @GetMapping("/motorhomes/create")
    public String motorhomesCreate(){
        return "motorhome/create";
    }

    @PostMapping("/motorhome/realcreate")
    public String realCreateStudent(@ModelAttribute Motorhome motorhomeFromPost){
        MotorhomeRepository.create(motorhomeFromPost);
        return "redirect:/motorhomes";
    }
    @GetMapping("/motorhomes/details")
    public String motorhomesDetails(@RequestParam int id, Model model){
        model.addAttribute("motorhome", MotorhomeRepository.read(id));
        return "motorhomes/details";
    }
    @GetMapping("/motorhomes/delete")
    public String motorhomesDelete(@RequestParam int id, Model model){
        model.addAttribute("motorhome", MotorhomeRepository.read(id));
        return "motorhomes/delete";
    }
    @GetMapping("/motorhomes/update")
    public String motorhomesUpdate(@RequestParam int id, Model model){
        model.addAttribute("motorhome", MotorhomeRepository.read(id));
        return "motorhomes/update";
    }
    @PostMapping("/motorhomes/realupdate")
    public String updateMotorhome(@ModelAttribute Motorhome motorhomeFromPost){
        MotorhomeRepository.update(motorhomeFromPost);
        return "redirect:/motorhomes";
    }
    @GetMapping("/motorhomes/realdelete")
    public String deleteMotorhome(@RequestParam int id){
        MotorhomeRepository.delete(id);
        return "redirect:/motorhomes";
    }
}
