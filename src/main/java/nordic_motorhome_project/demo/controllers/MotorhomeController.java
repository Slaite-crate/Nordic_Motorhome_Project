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

    @GetMapping("/motorhome/create")
    public String motorhomeCreate(){
        return "motorhome/create";
    }

    @PostMapping("/motorhome/realcreate")
    public String realCreateStudent(@ModelAttribute Motorhome motorhomeFromPost){
        MotorhomeRepository.create(motorhomeFromPost);
        return "redirect:/motorhome";
    }
    @GetMapping("/motorhome/details")
    public String motorhomeDetails(@RequestParam int id, Model model){
        model.addAttribute("motorhome", MotorhomeRepository.read(id));
        return "motorhome/details";
    }
    @GetMapping("/motorhome/delete")
    public String motorhomeDelete(@RequestParam int id, Model model){
        model.addAttribute("motorhome", MotorhomeRepository.read(id));
        return "motorhome/delete";
    }
    @GetMapping("/motorhome/update")
    public String motorhomesUpdate(@RequestParam int id, Model model){
        model.addAttribute("motorhome", MotorhomeRepository.read(id));
        return "motorhome/update";
    }
    @PostMapping("/motorhome/realupdate")
    public String updateMotorhome(@ModelAttribute Motorhome motorhomeFromPost){
        MotorhomeRepository.update(motorhomeFromPost);
        return "redirect:/motorhome";
    }
    @GetMapping("/motorhome/realdelete")
    public String deleteMotorhome(@RequestParam int id){
        MotorhomeRepository.delete(id);
        return "redirect:/motorhome";
    }
}
