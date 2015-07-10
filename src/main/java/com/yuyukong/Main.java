package com.yuyukong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //display hardcoded items
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(0, Item.Type.necessary));
        items.add(new Item(0, Item.Type.luxury));
        items.add(new Item(100, Item.Type.necessary));
        items.add(new Item(100, Item.Type.luxury));
        items.add(new Item(2147483647, Item.Type.necessary));
        items.add(new Item(2147483647, Item.Type.luxury));
        displayItems(items);

        //display user input items
        List<Item> moreItems = userInput();
        displayItems(moreItems);
    }

    public static void displayItems(List<Item> items) {
        if (items.size() > 0) {
            System.out.println("There are " + items.size() + " items:");
            for (int i = 0, max = items.size(); i < max; i++) {
                System.out.println((i + 1) + ". Original price is " + items.get(i).getPrice() + " cents.\n   Type is " + items.get(i).getType() + ".\n   Final price is " + items.get(i).calculatePrice() + " cents.");
            }
        } else {
            System.out.println("There is no item.");
        }
    }

    public  static List<Item> userInput() {
        List<Item> items = new ArrayList<Item>();
        Scanner input = new Scanner(System.in);
        String yesOrNo;
        String answer;
        boolean succeed;
        System.out.println("Do u want to enter your own item? yes or no (Type exit to quit at anytime)");
        yesOrNo = input.next().toUpperCase();
        while(yesOrNo.equals("YES")) {
            Item item = new Item();
            System.out.println("Please entry a price.");
            answer = input.next();
            if(answer.toLowerCase().equals("exit")) {
                break;
            }
            try {
                succeed = item.setPrice(Integer.parseInt(answer));
            } catch (Exception e) {
                System.out.println("Number is too big, integer please, starting over.");
                continue;
            }
            if(!succeed) {
                System.out.println("Negative price, starting over.");
                continue;
            }
            System.out.println("Please entry a type.");
            answer = input.next();
            if(answer.toLowerCase().equals("exit")) {
                break;
            }
            succeed = item.setType(answer);
            if(!succeed) {
                System.out.println("Wrong type, starting over.");
                continue;
            } else {
                items.add(item);
            }
            System.out.println("Do u want to enter more items?");
            yesOrNo = input.next().toUpperCase();
        }
        return items;
    }
}
