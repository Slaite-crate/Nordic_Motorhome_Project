package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.interfaceRepositories.IBrandRepository;
import nordic_motorhome_project.demo.interfaceRepositories.IMotorhomeModelRepository;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelController {
    private IMotorhomeModelRepository motorhomeModelRepository;
    private IBrandRepository brandRepository;

    public ModelController(){
        motorhomeModelRepository = new MotorhomeModelRepository();
        brandRepository = new BrandRepository();
    }

    @GetMapping("/model/model")
    public String motorhomeModel(Model model){
        model.addAttribute("models", motorhomeModelRepository.readAllModels());
        return "/model/model";
    }

    @GetMapping("/model/create")
    public String modelCreate(Model model){
        model.addAttribute("brands", brandRepository.readAllBrands());
        return "/model/create";
    }

    @PostMapping("/model/realcreate")
    public String modelRealCreate(@ModelAttribute Motorhome motorhome){
        motorhomeModelRepository.createModel(motorhome);
        return "redirect:/model/model";
    }

    @GetMapping("/model/update")
    public String modelUpdate(@RequestParam int id, Model model, Model brand){
        model.addAttribute("model", motorhomeModelRepository.readModel(id));
        brand.addAttribute("brands", brandRepository.readAllBrands());
        return "/model/update";
    }

    @PostMapping("/model/realupdate")
    public String modelRealUpdate(@ModelAttribute Motorhome model){
        motorhomeModelRepository.updateModel(model);
        return "redirect:/model/model";
    }

    @GetMapping("/model/delete")
    public String delete(@RequestParam int id){
        motorhomeModelRepository.deleteModel(id);
        return "redirect:/model/model";
    }
}
