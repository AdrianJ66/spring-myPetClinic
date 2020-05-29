package springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.sfgpetclinic.services.map.OwnerServiceMap;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerServiceMap ownerServiceMap;

    public OwnerController(OwnerServiceMap ownerServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String indexOwners(Model model) {
        model.addAttribute("owners", ownerServiceMap.findAll());
        return "owners/index";
    }
}