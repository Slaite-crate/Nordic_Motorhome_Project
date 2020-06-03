package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.interfaceRepositories.IMotorhomeRepository;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.repositories.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrandController { //Pelle
    private IMotorhomeRepository MotorhomeRepository;

    public BrandController() {
        MotorhomeRepository = new BrandRepository();
    }

    @GetMapping("/brand/brand")
    public String brand(Model model) {
        model.addAttribute("motorhomes", MotorhomeRepository.readAll());
        return "/brand/brand";
    }

    @GetMapping("/brand/create")
    public String createBrand() {
        return "/brand/create";
    }

    @PostMapping("/brand/realcreate")
    public String realCreateBrand(@ModelAttribute Motorhome motorhomeFromPost) {
        if (MotorhomeRepository.create(motorhomeFromPost)) {
            return "redirect:/brand/brand";
        }
        else {
            return "/brand/create";
        }
    }

    @GetMapping("/brand/update")
    public String update(@RequestParam int id, Model model) {
        model.addAttribute("motorhome", MotorhomeRepository.read(id));
        return "/brand/update";
    }

    @PostMapping("/brand/realupdate")
    public String realUpdate(@ModelAttribute Motorhome motorhomeFromPost) {
        MotorhomeRepository.update(motorhomeFromPost);
        return "redirect:/brand/brand";
    }

    @GetMapping("/brand/delete")
    public String delete(@RequestParam int id) {
        MotorhomeRepository.delete(id);
        return "redirect:/brand/brand";
    }
}
