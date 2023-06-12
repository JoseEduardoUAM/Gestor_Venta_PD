package com.PD.ControllersViews;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PD.Products.*;
import com.PD.Proxys.*;
import com.PD.Records.*;

@RestController
public class RestControllerProducts {
  
  @CrossOrigin(origins = "*")
  @PostMapping("/addSmartphone")
  public ResponseMessage addSmartphone( @RequestBody RequestSmartphone product ) {
    ModelProduct mp = ModelProxy.get().getModel( product.model() );
    SmartphoneProxy.get().add( 
      new Smartphone( product.id() , product.screen(), mp , product.processor() , product.sensors(), product.dimension(), product.stored(), product.colors(), product.numberSIM())
    );
    return new ResponseMessage( 200 , "Se agregó el Smartphone" );
	}

  @CrossOrigin(origins = "*")
  @PostMapping("/addSmartTV")
  public ResponseMessage addSmartTV( @RequestBody RequestSmartTV product ) {
    ModelProduct mp = ModelProxy.get().getModel( product.model() );
    SmartTVProxy.get().add( 
      new SmartTV( product.id() , product.screen(), mp , product.processor() , product.sensors(), product.dimension(), product.stored(), product.weight())
    );
    return new ResponseMessage( 200 , "Se agrego el Smart TV" );
	}

  @CrossOrigin(origins = "*")
  @PostMapping("/addTablet")
  public ResponseMessage addTablet( @RequestBody RequestTablet product ) {
    ModelProduct mp = ModelProxy.get().getModel( product.model() );
    TabletProxy.get().add( 
      new Tablet( product.id() , product.screen(), mp , product.processor() , product.sensors(), product.dimension(), product.stored(), product.colors())
    );
    return new ResponseMessage( 200 , "Se agrego la Tablet" );
	}

  @CrossOrigin(origins = "*")
  @PostMapping("/addSmartwatch")
  public ResponseMessage addSmartwatch( @RequestBody RequestTSmartwatch product ) {
    ModelProduct mp = ModelProxy.get().getModel( product.model() );
    SmartwatchProxy.get().add( 
      new Smartwatch( product.id() , product.screen(), mp , product.processor() , product.sensors(), product.dimension(), product.stored() )
    );
    return new ResponseMessage( 200 , "Se agrego un smartwatch" );
	}

}





