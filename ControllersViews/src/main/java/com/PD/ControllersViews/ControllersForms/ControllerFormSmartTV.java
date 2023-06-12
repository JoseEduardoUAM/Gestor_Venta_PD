package com.PD.ControllersViews.ControllersForms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.ModelProduct;
import com.PD.Products.SmartTV;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.SmartTVProxy;

@Controller
@RequestMapping("/")
public class ControllerFormSmartTV {
    
    @GetMapping("/Formularios/SmartTV")
    public String mostrarFormulario( Model model ){       
        model.addAttribute( "modelos" ,  ModelProxy.get().getAll() );
        return "Formularios/SmartTV";
    }

    @PostMapping("/Formularios/SmartTV")
    public ModelAndView mostrarResultado( @RequestParam("screen") String screen , @RequestParam("idModelo") int idModelo , @RequestParam("procesador") String procesador , @RequestParam("sensores") String[] sensores , @RequestParam("alto") float alto , @RequestParam("ancho") float ancho , @RequestParam("largo") float largo , @RequestParam("stored") int stored , @RequestParam("weight") float weight ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoSmartTV");
        SmartTV smartTV = new SmartTV(0, screen, new ModelProduct(idModelo), procesador, sensores, new float[]{ alto , ancho , largo }, stored, weight);
        mav.addObject("SmartTV", smartTV);
        SmartTVProxy.get().add(smartTV);
        return mav;
    }

}
