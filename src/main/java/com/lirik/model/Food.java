package com.lirik.model;

public class Food extends Product{

    private ShelfLife shelfLife = ShelfLife.UNKNOWN;


    public Food(int id, String title, ShelfLife shelfLife) {
        super(id, title);
        this.shelfLife=shelfLife;

    }

    public ShelfLife getShelfLife(){
        return shelfLife;
    }


    public enum ShelfLife{
        UNKNOWN,
        PERISHABLE,
        NON_PERISHABLE,
    }
}
