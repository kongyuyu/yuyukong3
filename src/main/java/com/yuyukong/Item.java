package com.yuyukong;

/**
 * Created by Yuyu Kong on 7/9/2015.
 * For Comcast Interview
 */
public class Item {
    public static class Type {
        public static final String luxury = "luxury";
        public static final String necessary = "necessary";
    }
    private int price;
    private String type;

    public Item() {
    }

    public Item(int price, String type) {
        this.setPrice(price);
        this.setType(type);
    }

    public int getPrice() {
        return price;
    }

    //check for negative value
    public boolean setPrice(int price) {
        if (price >= 0) {
            this.price = price;
            return true;
        } else {
            System.out.println("Error, negative price.\nPrice show be non-negative only.");
            return false;
        }
    }

    public String getType() {
        return type;
    }

    //check for wrong type string
    public boolean setType(String type) {
        if (type.equals(Type.luxury) || type.equals(Type.necessary)) {
            this.type = type;
            return true;
        }
        else {
            System.out.println("Error, wrong type.\nAccepting " + Type.necessary + " and " + Type.luxury + " only.");
            return false;
        }
    }

    //calculate final price
    public long calculatePrice() {
        double taxRate;
        if (type.equals(Type.necessary)) {
            taxRate = 0.01;
        } else {
            taxRate = 0.09;
        }
        return Math.round(this.price * ( 1 + taxRate ));
    }
}
