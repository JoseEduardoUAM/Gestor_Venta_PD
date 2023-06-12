package com.PD.ControllersViews.ControllersForms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Products.Family;
import com.PD.Products.ModelProduct;
import com.PD.Proxys.FamilyProxy;
import com.PD.Proxys.ModelProxy;

@Controller
@RequestMapping("/")
public class ControllerFormModel {
    
    @GetMapping("/Formularios/Modelo")
    public String mostrarFormulario( Model model ){      
        model.addAttribute( "familias" ,  FamilyProxy.get().getAll() );
        return "Formularios/Modelo";
    }

    @PostMapping("/Formularios/Modelo")
    public ModelAndView mostrarResultado( @RequestParam("name") String name , @RequestParam("idFamilia") int id ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoModelo");
        ModelProduct model = new ModelProduct( 0 , name, new Family(id));
        mav.addObject("Modelo", model);
        ModelProxy.get().add(model);
        return mav;
    }

}
