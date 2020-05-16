package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.model.Aerolinea;
import pe.isil.service.AerolineaService;

import java.util.List;

@Controller
public class AerolineaController {

    @Autowired
    AerolineaService aerolineaService;

    @GetMapping("/aerolineas")
    public String getAerolineas(Model model){
        List<Aerolinea> aerolineas = aerolineaService.findAll();
        model.addAttribute("aerolineas", aerolineas);
        return "aerolineas";
    }

    @GetMapping("/aerolineas/add")
    public String addAerolineas(Model model){

        model.addAttribute("aerolinea", new Aerolinea());
        return "aerolineas-add";
    }

}
