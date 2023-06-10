package com.PD.Proxys;

import java.util.ArrayList;

import com.PD.Inventorys.Inventory;
import com.PD.ProductsDAO.InventoryDAO;

public class InventoryProxy {

  private static InventoryProxy ip;
  private ArrayList<Inventory> products;

  private InventoryProxy() {
    products = new ArrayList<>();
  }

  public static synchronized InventoryProxy get() {
    if (ip == null) ip = new InventoryProxy();
    return ip;
  }

  public ArrayList<Inventory> getAll() {
    if (this.products.isEmpty()) this.products = InventoryDAO.getAll();
    return this.products;
  }

  public boolean add( Inventory inventory ){
    InventoryDAO.add(inventory);
    this.products = InventoryDAO.getAll();
    return true;
}

}
