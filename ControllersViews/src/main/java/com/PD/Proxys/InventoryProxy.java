package com.PD.Proxys;

import java.util.ArrayList;

import com.PD.Inventorys.Inventory;
import com.PD.Products.SmartTV;
import com.PD.Products.Smartphone;
import com.PD.Products.Smartwatch;
import com.PD.Products.Tablet;
import com.PD.ProductsDAO.InventoryDAO;

public class InventoryProxy {

  private static InventoryProxy ip;
  private ArrayList<Inventory> products;

  private InventoryProxy() {
    products = new ArrayList<>();
  }

  public static synchronized InventoryProxy get() {
    if (ip == null)
      ip = new InventoryProxy();
    return ip;
  }

  public ArrayList<Inventory> getAll() {
    if (this.products.isEmpty())
      this.products = InventoryDAO.getAll();
    return this.products;
  }

  public boolean add(Inventory inventory) {
    InventoryDAO.add(inventory);
    this.products = InventoryDAO.getAll();
    return true;
  }

  public int[] mostrarNumeroProductosInventariados() {
    if (this.products.isEmpty())
      this.products = InventoryDAO.getAll();
    int numeroSmartphone = 0;
    int numeroSmartTV = 0;
    int numeroSmartwatch = 0;
    int numeroTablet = 0;
    for (Inventory inventory : this.products) {
      if (inventory.getProduct() instanceof Smartphone)
        numeroSmartphone++;
      else if (inventory.getProduct() instanceof SmartTV)
        numeroSmartTV++;
      else if (inventory.getProduct() instanceof Smartwatch)
        numeroSmartwatch++;
      else if (inventory.getProduct() instanceof Tablet)
        numeroTablet++;
    }
    return new int[] { numeroSmartphone, numeroSmartTV, numeroSmartwatch, numeroTablet };
  }

  public int[] mostrarNumeroDefectuosos() {
    if (this.products.isEmpty())
      this.products = InventoryDAO.getAll();
    int numeroSmartphone = 0;
    int numeroSmartTV = 0;
    int numeroSmartwatch = 0;
    int numeroTablet = 0;
    for (Inventory inventory : this.products) {

      if (inventory.getProduct() instanceof Smartphone) {
        if (inventory.getFactoryErrors() != null)
          numeroSmartphone++;
      } else if (inventory.getProduct() instanceof SmartTV) {
        if (inventory.getFactoryErrors() != null)
          numeroSmartTV++;
      } else if (inventory.getProduct() instanceof Smartwatch) {
        if (inventory.getFactoryErrors() != null)
          numeroSmartwatch++;
      } else if (inventory.getProduct() instanceof Tablet) {
        if (inventory.getFactoryErrors() != null)
          numeroTablet++;
      }
    }
    return new int[] { numeroSmartphone, numeroSmartTV, numeroSmartwatch, numeroTablet };
  }

}
