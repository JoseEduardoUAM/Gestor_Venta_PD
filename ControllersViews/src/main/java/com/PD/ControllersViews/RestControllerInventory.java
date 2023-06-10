package com.PD.ControllersViews;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PD.Inventorys.Inventory;
import com.PD.Products.Product;
import com.PD.Proxys.InventoryProxy;
import com.PD.Proxys.SmartTVProxy;
import com.PD.Proxys.SmartphoneProxy;
import com.PD.Proxys.SmartwatchProxy;
import com.PD.Proxys.TabletProxy;

@RestController
public class RestControllerInventory {
  
  @CrossOrigin(origins = "*")
  @PostMapping("/addInventory")
  public ResponseMessage addSmartphone( @RequestBody RequestInventory inventory ) {
    Product product;
    if( inventory.typeProduct() == 1 ) product = SmartphoneProxy.get().getProduct(inventory.product());
    else if( inventory.typeProduct() == 2 ) product = SmartTVProxy.get().getProduct(inventory.product());
    else if( inventory.typeProduct() == 3 ) product = SmartwatchProxy.get().getProduct(inventory.product());
    else if( inventory.typeProduct() == 4 ) product = TabletProxy.get().getProduct(inventory.product());
    else return new ResponseMessage( 401 , "El tipo de producto no esta registrado" );

    if( product == null ) return new ResponseMessage( 401 , "El producto no esta registrado" );
    
    System.out.println( product.getTipo() );

    InventoryProxy.get().add(
      new Inventory( inventory.idInventory(), product, inventory.price(), inventory.factoryError() )
    );
    return new ResponseMessage( 200 , "Se agrego el inventario" );
	}

}

record ResponseMessage( int status , String message ){}

record RequestInventory(int idInventory, int state, int product, float price , String[] factoryError , int typeProduct){}
