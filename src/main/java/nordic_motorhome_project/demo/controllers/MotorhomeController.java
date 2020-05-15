package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.repositories.ICustomerRepository;
import nordic_motorhome_project.demo.repositories.IMotorhomeRepository;
import nordic_motorhome_project.demo.repositories.MotorhomeRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MotorhomeController {

    private IMotorhomeRepository motorhomeRepository;

    public MotorhomeController(){
        motorhomeRepository = new MotorhomeRepositoryImpl();
    }

    @GetMapping("/motorhome")
    public String motorhome(Model model){
        model.addAttribute("motorhomes", motorhomeRepository.readAll());
        return "/motorhome/motorhome";
    }

    @GetMapping("/motorhome/create")
    public String motorhomeCreate(){
        return "/motorhome/create";
    }

    @PostMapping("/motorhome/realcreate")
    public String realCreateStudent(@ModelAttribute Motorhome motorhomeFromPost){
        motorhomeRepository.create(motorhomeFromPost);
        return "redirect:/motorhome";
    }
    @GetMapping("/motorhome/details")
    public String motorhomeDetails(@RequestParam int id, Model model){
        model.addAttribute("motorhome", motorhomeRepository.read(id));
        return "/motorhome/details";
    }

    @GetMapping("/motorhome/update")
    public String motorhomesUpdate(@RequestParam int id, Model model){
        model.addAttribute("motorhome", motorhomeRepository.read(id));
        return "/motorhome/update";
    }
    @PostMapping("/motorhome/realupdate")
    public String updateMotorhome(@ModelAttribute Motorhome motorhomeFromPost){
        motorhomeRepository.update(motorhomeFromPost);
        return "redirect:/motorhome";
    }
    @GetMapping("/motorhome/delete")
    public String deleteMotorhome(@RequestParam int id){
        motorhomeRepository.delete(id);
        return "redirect:/motorhome";
    }
}
