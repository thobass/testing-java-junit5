package rocks.basset.sfgpetclinic.controllers;

import rocks.basset.sfgpetclinic.fauxspring.Model;
import rocks.basset.sfgpetclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
