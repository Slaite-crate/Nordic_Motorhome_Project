package nordic_motorhome_project.demo.controllers;
import nordic_motorhome_project.demo.models.Fee;
import nordic_motorhome_project.demo.repositories.FeeRepositoryImpl;
import nordic_motorhome_project.demo.interfaceRepositories.IFeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FeeController {
    private IFeeRepository feeRepository;

    public FeeController(){
        feeRepository = new FeeRepositoryImpl();
    }

    @GetMapping("/fee")
    public String feesList(Model model){
        model.addAttribute("fees",feeRepository.readAll());
        return "/fee/fee";
    }

    @GetMapping("/fee/create")
    public String feeCreate(){
        return "/fee/create";
    }

    @PostMapping("/fee/realcreate")
    public String feeRealCreate(@ModelAttribute Fee fee){
        feeRepository.create(fee);
        return "redirect:/fee";
    }

    @GetMapping("/fee/details")
    public String feeDetails(@RequestParam int id, Model model){
        model.addAttribute("fee",feeRepository.read(id));
        return "/fee/details";
    }

    @GetMapping("/fee/delete")
    public String feeDelete(@RequestParam int id){
        feeRepository.delete(id);
        return "redirect:/fee";
    }

    @GetMapping("/fee/update")
    public String feeUpdate(@RequestParam int id, Model model){
        model.addAttribute("fee", feeRepository.read(id));
        return "/fee/update";
    }

    @PostMapping("/fee/realupdate")
    public String feeRealUpdate(@ModelAttribute Fee fee){
        feeRepository.update(fee);
        return "redirect:/fee";
    }
}




