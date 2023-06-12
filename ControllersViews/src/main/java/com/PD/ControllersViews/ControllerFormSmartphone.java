package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.Smartphone;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.SmartphoneProxy;

@Controller
@RequestMapping("/")
public class ControllerFormSmartphone {
    
    @GetMapping("/Formularios/Smartphone")
    public String mostrarFormulario( Model model ){
        model.addAttribute( "Smartphone" ,  new Smartphone() );        
        model.addAttribute( "modelos" ,  ModelProxy.get().getAll() );
        return "Formularios/Smartphone";
    }

    @PostMapping("/Formularios/Smartphone")
    public ModelAndView mostrarResultado( @ModelAttribute("Smartphone") Smartphone smartphone ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoSmartphone");
        mav.addObject("Smartphone", smartphone);
        SmartphoneProxy.get().add(smartphone);
        return mav;
    }

}
