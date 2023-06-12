package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Proxys.SmartTVProxy;
import com.PD.Proxys.SmartphoneProxy;
import com.PD.Proxys.SmartwatchProxy;
import com.PD.Proxys.TabletProxy;

@Controller
public class ControllerMain {
  
  @GetMapping("/")
  public ModelAndView mostrarPrincipal(){
    ModelAndView mav = new ModelAndView("index");
    mav.addObject( "numbersSmartphone" , SmartphoneProxy.get().sizeProducts() );
    mav.addObject( "numbersTablets" , TabletProxy.get().sizeProducts() );
    mav.addObject( "numbersSmartwatch" , SmartwatchProxy.get().sizeProducts() );
    mav.addObject( "numbersSmartTV" , SmartTVProxy.get().sizeProducts() );
    return mav;
  }
  
}
