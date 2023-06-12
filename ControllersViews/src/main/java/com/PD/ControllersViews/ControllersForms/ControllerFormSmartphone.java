package com.PD.ControllersViews.ControllersForms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.ModelProduct;
import com.PD.Products.Smartphone;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.SmartphoneProxy;

@Controller
@RequestMapping("/")
public class ControllerFormSmartphone {
    
    @GetMapping("/Formularios/Smartphone")
    public String mostrarFormulario( Model model ){       
        model.addAttribute( "modelos" ,  ModelProxy.get().getAll() );
        return "Formularios/Smartphone";
    }

    @PostMapping("/Formularios/Smartphone")
    public ModelAndView mostrarResultado( @RequestParam("screen") String screen , @RequestParam("idModelo") int idModelo , @RequestParam("procesador") String procesador , @RequestParam("sensores") String[] sensores , @RequestParam("alto") float alto , @RequestParam("ancho") float ancho , @RequestParam("largo") float largo , @RequestParam("stored") int stored , @RequestParam("colors") String[] colors , @RequestParam("numberSIM") int numSIM ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoSmartphone");
        Smartphone smartphone = new Smartphone( 0 , screen, new ModelProduct(idModelo) , procesador, sensores, new float[]{ alto , ancho , largo } , stored, colors, numSIM);
        mav.addObject("Smartphone", smartphone);
        SmartphoneProxy.get().add(smartphone);
        return mav;
    }

}
