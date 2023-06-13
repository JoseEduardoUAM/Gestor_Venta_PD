package com.PD.ControllersViews.ControllersInventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Inventorys.Inventory;
import com.PD.Products.Smartphone;
import com.PD.Proxys.InventoryProxy;
import com.PD.Proxys.SmartphoneProxy;
import com.PD.States.*;

@Controller
@RequestMapping("/")
public class ControllerInventorySmartphone {

  @GetMapping("/Inventario/Smartphone")
  public String showSmartphoneFormulario(Model model) {
    model.addAttribute("smartphones", SmartphoneProxy.get().getAll());
    return "Inventarios/Smartphone";
  }

  @PostMapping("/Inventario/Smartphone")
  public ModelAndView showSmartphoneResultado(@RequestParam("idProduct") int idSmartphone,
      @RequestParam("precio") float precio, @RequestParam("estado") int estado,
      @RequestParam( name = "erroresFabrica" , required = false ) String[] erroresFabrica) {
    State state;
    if (estado == 2) state = Devolution.get();
    else if (estado == 3) state = Reparacion.get();
    else if (estado == 4) state = Sell.get();
    else state = Stored.get();
    Smartphone smartphone = new Smartphone(idSmartphone);
    Inventory inventory = new Inventory(0, state, smartphone, precio, erroresFabrica);
    ModelAndView mav = new ModelAndView("Resultados/ResultadoInventario");
    mav.addObject("Product", smartphone);
    InventoryProxy.get().add(inventory);
    return mav;
  }

}
