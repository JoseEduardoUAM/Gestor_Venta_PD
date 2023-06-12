package com.PD.ControllersViews.ControllersInventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Inventorys.Inventory;
import com.PD.Products.SmartTV;
import com.PD.Proxys.InventoryProxy;
import com.PD.Proxys.SmartTVProxy;
import com.PD.States.Devolution;
import com.PD.States.Reparacion;
import com.PD.States.Sell;
import com.PD.States.State;
import com.PD.States.Stored;

@Controller
@RequestMapping("/")
public class ControllerInventorySmartTV {
  
  @GetMapping("/Inventario/SmartTV")
  public String showSmartphoneFormulario(Model model) {
    model.addAttribute("smartTVs", SmartTVProxy.get().getAll());
    return "Inventarios/SmartTV";
  }

  @PostMapping("/Inventario/SmartTV")
  public ModelAndView showSmartphoneResultado(@RequestParam("idProduct") int idProduct,
      @RequestParam("precio") float precio, @RequestParam("estado") int estado,
      @RequestParam("erroresFabrica") String[] erroresFabrica) {
    State state;
    if (estado == 2) state = Devolution.get();
    else if (estado == 3) state = Reparacion.get();
    else if (estado == 4) state = Sell.get();
    else state = Stored.get();
    SmartTV smartTV = new SmartTV(idProduct);
    Inventory inventory = new Inventory(0, state, smartTV, precio, erroresFabrica);
    ModelAndView mav = new ModelAndView("Resultados/ResultadoInventario");
    mav.addObject("Product", smartTV);
    InventoryProxy.get().add(inventory);
    return mav;
  }

}
