package com.PD.Products;

public class Family {

    private final int id;
    private final String name;

    public Family(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Family( int id ){
        this( id , null );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}