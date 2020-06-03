package nordic_motorhome_project.demo.controllers;

import nordic_motorhome_project.demo.interfaceRepositories.ICrud;
import nordic_motorhome_project.demo.models.Extra;
import nordic_motorhome_project.demo.repositories.ExtraRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExtraController { //Frederic
    private ICrud<Extra> extraRepository;

    public ExtraController() {
        extraRepository = new ExtraRepositoryImpl();
    }

    @GetMapping("/extra")
    public String extrasList(Model model) {
        model.addAttribute("extras", extraRepository.readAll());
        return "/extra/extra";
    }

    @GetMapping("/extra/create")
    public String extraCreate() {
        return "/extra/create";
    }

    @PostMapping("/extra/realcreate")
    public String extraRealCreate(@ModelAttribute Extra extra) {
        extraRepository.create(extra);
        return "redirect:/extra";
    }

    @GetMapping("/extra/details")
    public String extraDetails(@RequestParam int id, Model model) {
        model.addAttribute("extra", extraRepository.read(id));
        return "/extra/details";
    }

    @GetMapping("/extra/delete")
    public String extraDelete(@RequestParam int id) {
        extraRepository.delete(id);
        return "redirect:/extra";
    }

    @GetMapping("/extra/update")
    public String extraUpdate(@RequestParam int id, Model model) {
        model.addAttribute("extra", extraRepository.read(id));
        return "/extra/update";
    }

    @PostMapping("/extra/realupdate")
    public String extraRealUpdate(@ModelAttribute Extra extra) {
        extraRepository.update(extra);
        return "redirect:/extra";
    }
}