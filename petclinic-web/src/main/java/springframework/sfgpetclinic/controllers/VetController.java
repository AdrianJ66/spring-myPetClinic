package springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.VetService;
import springframework.sfgpetclinic.services.map.VetServiceMap;

import java.util.Set;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "vets/index.html", "/vets.html"})
    public String indexVets(Model model) {

        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @GetMapping({"/api/vets"})
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
