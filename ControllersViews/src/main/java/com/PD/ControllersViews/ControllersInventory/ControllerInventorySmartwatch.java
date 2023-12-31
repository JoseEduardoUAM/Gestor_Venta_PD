package com.PD.ControllersViews.ControllersInventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Inventorys.Inventory;
import com.PD.Products.Smartwatch;
import com.PD.Proxys.InventoryProxy;
import com.PD.Proxys.SmartwatchProxy;
import com.PD.States.*;

@Controller
@RequestMapping("/")
public class ControllerInventorySmartwatch {

  @GetMapping("/Inventario/Smartwatch")
  public String showSmartwatchFormulario(Model model) {
    model.addAttribute("smartwatchs", SmartwatchProxy.get().getAll());
    return "Inventarios/Smartwatch";
  }

  @PostMapping("/Inventario/Smartwatch")
  public ModelAndView showSmartwatchResultado(@RequestParam("idProduct") int id,
      @RequestParam("precio") float precio, @RequestParam("estado") int estado,
      @RequestParam( name = "erroresFabrica" , required = false ) String[] erroresFabrica) {
    State state;
    if (estado == 2) state = Devolution.get();
    else if (estado == 3) state = Reparacion.get();
    else if (estado == 4) state = Sell.get();
    else state = Stored.get();
    Smartwatch smartwatch = new Smartwatch(id);
    Inventory inventory = new Inventory( 0 , state, smartwatch, precio, erroresFabrica);
    ModelAndView mav = new ModelAndView("Resultados/ResultadoInventario");
    mav.addObject("Product", smartwatch);
    InventoryProxy.get().add(inventory);
    return mav;
  }

}
