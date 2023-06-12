package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.ModelProduct;
import com.PD.Products.Smartwatch;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.SmartwatchProxy;

@Controller
@RequestMapping("/")
public class ControllerFormSmartwatch {
    
    @GetMapping("/Formularios/Smartwatch")
    public String mostrarFormulario( Model model ){
        model.addAttribute( "Smartwatch" ,  new Smartwatch(0, null, new ModelProduct(), null, new String[]{}, new float[]{ 0 , 0 , 0 }, 0) );        
        model.addAttribute( "modelos" ,  ModelProxy.get().getAll() );
        return "Formularios/Smartwatch";
    }

    @PostMapping("/Formularios/Smartwatch")
    public ModelAndView mostrarResultado( @ModelAttribute("Smartwatch") Smartwatch smartwatch ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoSmartwatch");
        mav.addObject("Smartwatch", smartwatch);
        SmartwatchProxy.get().add(smartwatch);
        return mav;
    }

}
