package com.PD.ControllersViews;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PD.Proxys.InventoryProxy;

@RestController
public class RestControllerProducts {

  @PostMapping("/obtenerEstadisticas")
  public Response addSmartwatch() {
    return new Response( InventoryProxy.get().mostrarNumeroProductosInventariados() , InventoryProxy.get().mostrarNumeroDefectuosos() );
	}

}

record Response( int[] productos , int[] productosEF ){}



