package com.PD.States;

public class Sell implements State{

  private static Sell sell;

  private Sell() { }

  public static synchronized Sell get(){
    if( sell == null ) sell = new Sell();
    return sell;
  }

  @Override
  public void sell() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'sell'");
  }

  @Override
  public void stored() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'stored'");
  }

  @Override
  public void devolution() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'devolution'");
  }

  @Override
  public void fix() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'fix'");
  }

  @Override
  public String getState() {
    return "Vendido";
  }
  
}
