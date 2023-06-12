package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Inventorys.Inventory;
import com.PD.Products.ModelProduct;
import com.PD.Products.Smartphone;
import com.PD.Proxys.InventoryProxy;
import com.PD.Proxys.SmartphoneProxy;

@Controller
@RequestMapping("/")
public class ControllerInventory {
  
    @GetMapping("/Inventario/Smartphone")
    public String mostrarFormulario( Model model ){
        model.addAttribute( "Inventory" , new Inventory(0, new Smartphone(0, null, new ModelProduct(0, null, null), null, new String[]{}, new float[]{}, 0, new String[]{}, 0) , 0, new String[]{} ) );        
        model.addAttribute( "smartphones" ,  SmartphoneProxy.get().getAll() );
        return "Inventarios/Smartphone";
    }

    @PostMapping("/Inventario/Smartphone")
    public ModelAndView mostrarResultado( @ModelAttribute("Inventory") Inventory inventory ){
        ModelAndView mav = new ModelAndView("Resultados/ResultadoInventario");
        mav.addObject("Inventory", inventory);
        InventoryProxy.get().add(inventory);
        return mav;
    }
  
}