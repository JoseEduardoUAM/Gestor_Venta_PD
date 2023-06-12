package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.Family;
import com.PD.Proxys.FamilyProxy;

@Controller
@RequestMapping("/")
public class ControllerFormFamily {
    
    @GetMapping("/Formularios/Familia")
    public String mostrarFormulario( Model model ){
        model.addAttribute( "Family" ,  new Family(0, null) );
        return "Formularios/Familia";
    }

    @PostMapping("/Formularios/Familia")
    public ModelAndView Peticiones2( @ModelAttribute("Family") Family family ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoFamilia");
        mav.addObject("Family", family);
        FamilyProxy.get().add(family);
        return mav;
    }

}
