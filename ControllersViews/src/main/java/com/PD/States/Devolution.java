package com.PD.States;

public class Devolution implements State{

  private static Devolution devolution;

  private Devolution() { }

  public static synchronized Devolution get(){
    if( devolution == null ) devolution = new Devolution();
    return devolution;
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
    return "Devuelto";
  }
  
}
