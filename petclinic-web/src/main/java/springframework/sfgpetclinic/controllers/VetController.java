package springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.sfgpetclinic.services.map.VetServiceMap;

@Controller
public class VetController {
    private final VetServiceMap vetServiceMap;

    public VetController(VetServiceMap vetServiceMap) {
        this.vetServiceMap = vetServiceMap;
    }

    @RequestMapping({"/vets", "/vets/index", "vets/index.html", "/vets.html"})
    public String indexVets(Model model) {

        model.addAttribute("vets", vetServiceMap.findAll());
        return "vets/index";
    }
}
