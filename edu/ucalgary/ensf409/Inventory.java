/*
@Authors: Manraj Singh, Kartik Sharma, Sajan Hayer, Kirtan Kakadiya
@Version: 1.0
@Since: 1.0
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;

public class Inventory {
    private static Food foodItem;
    private String foodQuantity = "";
    private static ArrayList<Inventory> items = new ArrayList<>();
    private Nutrition nutritionalFacts;
    private Connection dbConnect;
    private ResultSet results;

    public Inventory(Food foodItem) throws IllegalArgumentException{
        this.foodItem = foodItem;
        //this.foodQuantity = foodQuantity;
    }
    public Inventory(){}
    public void insertItem(Food item) throws IllegalArgumentException{
        Inventory inventoryItem = new Inventory(item);
        items.add(inventoryItem);
    }

    public void initializeConnection() throws SQLException {
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/food_inventory", "root", "ensf409");
            System.out.println("connection succeful");
        } catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("Cannot connect to the database!");
        }
    }

    public String getDataFromAvailableFood() throws SQLException{
        StringBuilder output = new StringBuilder(300);
        try {
            Statement myStatement = dbConnect.createStatement();
            //System.out.println("markes");
            results = myStatement.executeQuery("SELECT * FROM available_food");

            while(results.next()){
                int wholeGrain = Integer.parseInt(results.getString("GrainContent"));

                int fruitVeggie = Integer.parseInt(results.getString("FVContent"));
                int protein = Integer.parseInt(results.getString("ProContent"));
                int other = Integer.parseInt(results.getString("Other"));
                int calories = Integer.parseInt(results.getString("Calories"));
                System.out.println( results.getString("ItemID") + " " + results.getString("Name") + " " + fruitVeggie + " "+ protein +" "+other + " " +calories);

                nutritionalFacts = new Nutrition(wholeGrain,fruitVeggie,protein,other,calories);
                foodItem = new Food(results.getString("ItemID"), results.getString("Name"), nutritionalFacts);
                insertItem(foodItem);
                //System.out.println(results.getString("Name") + " " + results.getString("GrainContent") + " " + results.getString("FVContent") + " " + results.getString("ProContent") + " " + results.getString("Other") + " ");
                
            }
            myStatement.close();
        
        } catch (Exception e) {
            System.out.println("failed");
            //TODO: Need to make it so it print an error message in the GUI but the program doesnt terminate
    }
    return output.toString().trim();

    }

    public void deleteItemFromAvailableFood(String itemName) throws SQLException{
        try{
            String query = "DELETE FROM available_food WHERE Name = (?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, itemName);

            int rowCount = myStmt.executeUpdate();
            if(rowCount!= 1){
                throw new SQLException();
            }
            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
            //we need to handle if deletion doesnt work
        }

    }


    
    public static void main(String[] args) throws SQLException {
        Inventory myJDBC = new Inventory();
        myJDBC.initializeConnection();

        
        System.out.println(myJDBC.getDataFromAvailableFood());


    }

    
}






