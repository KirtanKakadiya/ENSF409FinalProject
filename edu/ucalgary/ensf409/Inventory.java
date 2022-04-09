/*
@Authors: Manraj Singh, Kartik Sharma, Sajan Hayer, Kirtan Kakadiya
@Version: 1.0
@Since: 1.0
 */

package edu.ucalgary.ensf409;

import java.util.LinkedList;

public class Inventory {
    private Food foodItem;
    private String foodQuantity = "";
    private LinkedList<Inventory> items = new LinkedList<>();

    public Inventory(Food foodItem, String foodQuantity) throws IllegalArgumentException{
        this.foodItem = foodItem;
        this.foodQuantity = foodQuantity;
    }
    
    public void insertItem(Food item, String amount) throws IllegalArgumentException{
        Inventory inventoryItem = new Inventory(item, amount);
        items.add(inventoryItem);
    }
}
