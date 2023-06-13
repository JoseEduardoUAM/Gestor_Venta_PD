package com.PD.ProductsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.PD.DataBase.Connect;
import com.PD.Inventorys.Inventory;
import com.PD.Products.Product;
import com.PD.Proxys.SmartTVProxy;
import com.PD.Proxys.SmartphoneProxy;
import com.PD.Proxys.SmartwatchProxy;
import com.PD.Proxys.TabletProxy;
import com.PD.States.*;

public class InventoryDAO {

    public static ArrayList<Inventory> getAll() {
        ArrayList<Inventory> inventories = new ArrayList<>();
        Connect conn;
        try {
            conn = new Connect();
        } catch (Exception e) {
            System.out.println("Error al conectarse en la base de datos");
            return inventories;
        }
        try {
            ResultSet result = conn.iniciarConexion().createStatement().executeQuery("SELECT * FROM inventory");

            while (result.next()) {

                State state;
                if (result.getInt(2) == 2)
                    state = Devolution.get();
                else if (result.getInt(2) == 3)
                    state = Reparacion.get();
                else if (result.getInt(2) == 4)
                    state = Sell.get();
                else
                    state = Stored.get();

                Product product;
                if (result.getInt(3) != 0)
                    product = SmartphoneProxy.get().getProduct(result.getInt(3));
                else if (result.getInt(4) != 0)
                    product = SmartwatchProxy.get().getProduct(result.getInt(4));
                else if (result.getInt(5) != 0)
                    product = TabletProxy.get().getProduct(result.getInt(5));
                else if (result.getInt(6) != 0)
                    product = SmartTVProxy.get().getProduct(result.getInt(6));
                else
                    product = null;

                String[] factoryError = result.getString(8).replaceAll("\\[", "").replaceAll("]", "")
                        .replaceAll("null", "").split(",");

                if (factoryError[0].length() == 0)
                    factoryError = null;

                if (product != null)
                    inventories.add(
                            new Inventory(result.getInt(1), state, product, result.getFloat(7), factoryError)
                    );

            }
        } catch (Exception e) {
            System.out.println(e);
            return inventories;
        }
        return inventories;
    }

    public static boolean add(Inventory inventory) {
        Connect conn;
        try {
            conn = new Connect();
        } catch (Exception e) {
            return false;
        }
        try {
            PreparedStatement st = conn
                    .iniciarConexion()
                    .prepareStatement(String.format("INSERT INTO Inventory VALUES( %s )", inventory.getSQLInsert()));
            int insert = st.executeUpdate();
            conn.finalizarConexion();
            if (insert <= 0)
                return false;
        } catch (Exception e) {
            System.out.println(e);
            if (conn != null)
                conn.finalizarConexion();
            return false;
        }
        return true;
    }

}
