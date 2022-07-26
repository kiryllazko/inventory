package com.lirik.model;

public class VehiclePart extends Product{

    private String make;    //e.g. Honda, BMW
    private String model;   //e.g. Civic or 5-Series
    private int year;       //e.g. 2020

    public VehiclePart(int id, String title, String make, String model, int year) {
        super(id, title);
        this.make=make;
        this.model=model;
        this.year=year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "VehiclePart{" +
                "id='" + getId() + '\'' +
                "title='" + getTitle() + '\'' +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
