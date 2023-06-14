package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerMain {
  
  @GetMapping("/")
  public ModelAndView mostrarPrincipal(){
    ModelAndView mav = new ModelAndView("index");
    return mav;
  }
  
}
