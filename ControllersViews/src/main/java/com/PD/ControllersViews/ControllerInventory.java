package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Proxys.InventoryProxy;

@Controller
public class ControllerInventory {
  
  @GetMapping("/Inventario")
  public ModelAndView arreglo(){
    ModelAndView mav = new ModelAndView("Inventario");
    mav.addObject( "inventorys" , InventoryProxy.get().getAll() );
    return mav;
  }
  
}

record ResponseMessage( int status , String message ){}