package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.SmartTV;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.SmartTVProxy;

@Controller
@RequestMapping("/")
public class ControllerFormSmartTV {
    
    @GetMapping("/Formularios/SmartTV")
    public String mostrarFormulario( Model model ){
        model.addAttribute( "SmartTV" ,  new SmartTV() );        
        model.addAttribute( "modelos" ,  ModelProxy.get().getAll() );
        return "Formularios/SmartTV";
    }

    @PostMapping("/Formularios/SmartTV")
    public ModelAndView mostrarResultado( @ModelAttribute("SmartTV") SmartTV smartTV ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoSmartTV");
        mav.addObject("SmartTV", smartTV);
        SmartTVProxy.get().add(smartTV);
        return mav;
    }

}
