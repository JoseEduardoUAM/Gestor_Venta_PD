package com.PD.ControllersViews.ControllersForms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addAttribute( "modelos" ,  ModelProxy.get().getAll() );
        return "Formularios/Tablet";
    }

    @PostMapping("/Formularios/Tablet")
    public ModelAndView mostrarResultado( @RequestParam("screen") String screen , @RequestParam("idModelo") int idModelo , @RequestParam("procesador") String procesador , @RequestParam("sensores") String[] sensores , @RequestParam("alto") float alto , @RequestParam("ancho") float ancho , @RequestParam("largo") float largo , @RequestParam("stored") int stored , @RequestParam("colors") String[] colors ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoTablet");
        Tablet tablet = new Tablet(0, screen, new ModelProduct(idModelo), procesador, sensores, new float[]{ alto , ancho , alto }, stored, colors);
        mav.addObject("Tablet", tablet);
        TabletProxy.get().add(tablet);
        return mav;
    }

}
