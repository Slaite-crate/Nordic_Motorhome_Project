package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.interfaceRepositories.IBrandRepository;
import nordic_motorhome_project.demo.interfaceRepositories.IMotorhomeModelRepository;
import nordic_motorhome_project.demo.interfaceRepositories.IMotorhomeRepository;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MotorhomeController {

    private IMotorhomeRepository motorhomeRepository;
    private IMotorhomeModelRepository modelRepository;
    private IBrandRepository brandRepository;


    public MotorhomeController(){
        motorhomeRepository = new MotorhomeRepositoryImpl();
        modelRepository = new MotorhomeModelRepository();
        brandRepository = new BrandRepository();
    }

    @GetMapping("/motorhome")
    public String motorhome(Model model){
        model.addAttribute("motorhomes", motorhomeRepository.readAllMotorhomes());
        return "/motorhome/motorhome";
    }

    @GetMapping("/motorhome/createbrand")
    public String motorhomeBrandCreate(Model brands){
        brands.addAttribute("brands", brandRepository.readAllBrandsWithModels());
        return "/motorhome/createbrand";
    }

    @PostMapping("/motorhome/create")
    public String motorhomeCreate(@ModelAttribute Motorhome brand, Model models){
        models.addAttribute("models", modelRepository.readModelsFromBrand(brand));
        return "/motorhome/create";
    }

    @PostMapping("/motorhome/realcreate")
    public String realCreateStudent(@ModelAttribute Motorhome motorhomeFromPost){
        motorhomeRepository.createMotorhome(motorhomeFromPost);
        return "redirect:/motorhome";
    }
    @GetMapping("/motorhome/details")
    public String motorhomeDetails(@RequestParam int id, Model model){
        model.addAttribute("motorhome", motorhomeRepository.readMotorhome(id));
        return "/motorhome/details";
    }

    @GetMapping("/motorhome/update")
    public String motorhomesUpdate(@RequestParam int id, Model motorhome, Model model){
        motorhome.addAttribute("motorhome", motorhomeRepository.readMotorhome(id));
        model.addAttribute("models", modelRepository.readModelsFromBrand(id));
        return "/motorhome/update";
    }
    @PostMapping("/motorhome/realupdate")
    public String updateMotorhome(@ModelAttribute Motorhome motorhomeFromPost){
        motorhomeRepository.updateMotorhome(motorhomeFromPost);
        return "redirect:/motorhome";
    }
    @GetMapping("/motorhome/delete")
    public String deleteMotorhome(@RequestParam int id){
        motorhomeRepository.deleteMotorhome(id);
        return "redirect:/motorhome";
    }
}
