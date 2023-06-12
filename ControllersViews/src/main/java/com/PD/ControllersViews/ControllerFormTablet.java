package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.ModelProduct;
import com.PD.Products.Tablet;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.TabletProxy;

@Controller
@RequestMapping("/")
public class ControllerFormTablet {
    
    @GetMapping("/Formularios/Tablet")
    public String mostrarFormulario( Model model ){
        model.addAttribute( "Tablet" ,  new Tablet(0, null, new ModelProduct(), null, new String[]{}, new float[]{ 0 , 0 , 0 }, 0, new String[]{}) );        
        model.addAttribute( "modelos" ,  ModelProxy.get().getAll() );
        return "Formularios/Tablet";
    }

    @PostMapping("/Formularios/Tablet")
    public ModelAndView mostrarResultado( @ModelAttribute("Tablet") Tablet tablet ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoTablet");
        mav.addObject("Tablet", tablet);
        TabletProxy.get().add(tablet);
        return mav;
    }

}
