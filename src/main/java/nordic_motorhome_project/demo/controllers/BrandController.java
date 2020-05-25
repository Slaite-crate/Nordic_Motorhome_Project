package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.repositories.BrandRepository;
import nordic_motorhome_project.demo.interfaceRepositories.IBrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrandController {
    private IBrandRepository brandRepository;

    public BrandController(){
        brandRepository = new BrandRepository();
    }


    @GetMapping("/brand/brand")
    public String brand(Model model){
        model.addAttribute("motorhomes", brandRepository.readAllBrands());
        return "/brand/brand";
    }

    @GetMapping("/brand/create")
    public String createBrand(){
        return "/brand/create";
    }

    @PostMapping("/brand/realcreate")
    public String realCreateBrand(@ModelAttribute Motorhome motorhomeFromPost){
        brandRepository.createBrand(motorhomeFromPost);
        return "redirect:/brand/brand";
    }

    @GetMapping("/brand/update")
    public String update(@RequestParam int id, Model model){
        model.addAttribute("motorhome", brandRepository.readBrand(id));
        return "/brand/update";
    }

    @PostMapping("/brand/realupdate")
    public String realUpdate(@ModelAttribute Motorhome motorhomeFromPost){
        brandRepository.updateBrand(motorhomeFromPost);
        return "redirect:/brand/brand";
    }

    @GetMapping("/brand/delete")
    public String delete(@RequestParam int id){
        brandRepository.deleteBrand(id);
        return "redirect:/brand/brand";
    }
}
