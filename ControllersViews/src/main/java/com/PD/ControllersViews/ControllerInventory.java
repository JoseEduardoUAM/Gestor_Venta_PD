package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Inventorys.Inventory;
import com.PD.Proxys.InventoryProxy;
import com.PD.Proxys.SmartphoneProxy;

@Controller
@RequestMapping("/")
public class ControllerInventory {

    @GetMapping("/Inventario")
    public ModelAndView arreglo() {
        ModelAndView mav = new ModelAndView("Inventario");
        mav.addObject("inventorys", InventoryProxy.get().getAll());
        return mav;
    }

    @GetMapping("/Inventario/Smartphone")
    public String mostrarFormulario(Model model) {
        model.addAttribute("Inventory", new Inventory() );
        model.addAttribute("smartphones", SmartphoneProxy.get().getAll());
        return "Inventarios/Smartphone";
    }

    @PostMapping("/Inventario/Smartphone")
    public ModelAndView mostrarResultado(@ModelAttribute("Inventory") Inventory inventory) {

        System.out.println( "id : " + inventory.getIdInventory() );
        System.out.println( "state : " + inventory.getState() );
        System.out.println( "product id : " + inventory.getProduct().getId() );
        System.out.println( "precio : " + inventory.getPrice() );

        ModelAndView mav = new ModelAndView("Resultados/ResultadoInventario");
        mav.addObject("Inventory", inventory);
        InventoryProxy.get().add(inventory);
        return mav;
    }

}