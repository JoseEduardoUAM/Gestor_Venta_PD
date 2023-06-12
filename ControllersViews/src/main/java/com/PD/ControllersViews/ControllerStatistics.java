package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerStatistics {
    
  @GetMapping("/Estadisticas")
  public ModelAndView mostrarEstadisticas(){
    ModelAndView mav = new ModelAndView("Estadisticas");
    return mav;
  }

}
