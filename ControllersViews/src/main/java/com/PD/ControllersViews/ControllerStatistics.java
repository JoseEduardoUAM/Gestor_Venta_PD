package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PD.Proxys.InventoryProxy;
import com.PD.Proxys.SmartTVProxy;
import com.PD.Proxys.SmartphoneProxy;
import com.PD.Proxys.SmartwatchProxy;
import com.PD.Proxys.TabletProxy;

@Controller
public class ControllerStatistics {
    
  @GetMapping("/Estadisticas")
  public ModelAndView mostrarEstadisticas(){
    ModelAndView mav = new ModelAndView("Estadisticas");
    mav.addObject( "NumeroSmartphone" , SmartphoneProxy.get().sizeProducts() );
    mav.addObject( "NumeroSmartwatch" , SmartwatchProxy.get().sizeProducts() );
    mav.addObject( "NumeroSmartTV" , SmartTVProxy.get().sizeProducts() );
    mav.addObject( "NumeroTablet" , TabletProxy.get().sizeProducts() );

    int[] numero = InventoryProxy.get().mostrarNumeroProductosInventariados();

    mav.addObject( "NoSmartphoneInventario" , numero[0] );
    mav.addObject( "NoSmartTVInventario" , numero[1] );
    mav.addObject( "NoSmartwatchInventario" , numero[2] );
    mav.addObject( "NoTabletInventario" , numero[3] );
    return mav;
  }

}
