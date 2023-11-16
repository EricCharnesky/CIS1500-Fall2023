package com.example.coffeeshop;

import java.util.ArrayList;

public class Beverage {
    private String name;
    private double price;
    private ArrayList<String> addins;
    private int amountOfAddins;
    private String customerName;

    public Beverage(String name) {
        this.name = name;
        if ( name.equalsIgnoreCase("espresso")){
            price = 1.5;
        } else if  ( name.equalsIgnoreCase("coffee")){
            price = 1;
        } else if  ( name.equalsIgnoreCase("latte")){
            price = 2;
        }
        addins = new ArrayList<>();
        amountOfAddins = 0;
        customerName = "";
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void addAddin(String addin, int amount){
        if (addin.equalsIgnoreCase("soy milk")){
            price += .5;
        }
        addins.add(addin);
        amountOfAddins = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<String> getAddins() {
        return addins;
    }

    public int getAmountOfAddins() {
        return amountOfAddins;
    }

    public String getReceipt(){
        String receipt = "For " + customerName + ": ";
        receipt += name;

        if ( addins.size() > 0 ){
            receipt += " with " + amountOfAddins + " ";
        }
        for ( String addin : addins ){
            receipt += addin + " ";
        }

        receipt += "$" + price;

        return receipt;
    }
}
