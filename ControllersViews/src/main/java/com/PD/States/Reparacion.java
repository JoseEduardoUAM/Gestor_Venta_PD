package com.PD.States;

public class Reparacion implements State{

  private static Reparacion reparacion;

  private Reparacion() { }

  public static synchronized Reparacion get(){
    if( reparacion == null ) reparacion = new Reparacion();
    return reparacion;
  }

  @Override
  public void sell() {
    throw new UnsupportedOperationException("Unimplemented method 'sell'");
  }

  @Override
  public void stored() {
    throw new UnsupportedOperationException("Unimplemented method 'stored'");
  }

  @Override
  public void devolution() {
    throw new UnsupportedOperationException("Unimplemented method 'devolution'");
  }

  @Override
  public void fix() {
    throw new UnsupportedOperationException("Unimplemented method 'fix'");
  }

  @Override
  public String getState() {
    return "En reparacion";
  }
  
}
