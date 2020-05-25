package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.repositories.IMotorhomeRepository;
import nordic_motorhome_project.demo.repositories.MotorhomeRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrandController {
    private IMotorhomeRepository motorhomeRepository;

    public BrandController(){
        motorhomeRepository = new MotorhomeRepositoryImpl();
    }

    @GetMapping("/brand/brand")
    public String brand(Model model){
        model.addAttribute("motorhomes", motorhomeRepository.readAllBrands());
        return "/brand/brand";
    }

    @GetMapping("/brand/create")
    public String createBrand(){
        return "/brand/create";
    }

    @PostMapping("/brand/realcreate")
    public String realCreateBrand(@ModelAttribute Motorhome motorhomeFromPost){
        motorhomeRepository.createBrand(motorhomeFromPost);
        return "redirect:/brand/brand";
    }

    @GetMapping("/brand/update")
    public String update(@RequestParam int id, Model model){
        model.addAttribute("motorhome", motorhomeRepository.readBrand(id));
        return "/brand/update";
    }

    @PostMapping("/brand/realupdate")
    public String realUpdate(@ModelAttribute Motorhome motorhomeFromPost){
        motorhomeRepository.updateBrand(motorhomeFromPost);
        return "redirect:/brand/brand";
    }

    @GetMapping("/brand/delete")
    public String delete(@RequestParam int id){
        motorhomeRepository.deleteBrand(id);
        return "redirect:/brand/brand";
    }
}
