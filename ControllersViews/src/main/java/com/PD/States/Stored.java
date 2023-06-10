package com.PD.States;

public class Stored implements State {

  private static Stored stored;

  private Stored() { }

  public static synchronized Stored get(){
    if( stored == null ) stored = new Stored();
    return stored;
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
    return "Almacenado";
  }
  
}
