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
    private Food foodItem;
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

    public void getDataFromAvailableFood() throws SQLException{
        initializeConnection();
        try {
            Statement myStatement = dbConnect.createStatement();
            results = myStatement.executeQuery("SELECT * FROM available_food");

            while(results.next()){
                int wholeGrain = Integer.parseInt(results.getString("GrainContent"));

                int fruitVeggie = Integer.parseInt(results.getString("FVContent"));
                int protein = Integer.parseInt(results.getString("ProContent"));
                int other = Integer.parseInt(results.getString("Other"));
                int calories = Integer.parseInt(results.getString("Calories"));

                nutritionalFacts = new Nutrition(wholeGrain,fruitVeggie,protein,other,calories);
                foodItem = new Food(results.getString("ItemID"), results.getString("Name"), nutritionalFacts);
                insertItem(foodItem);
                
            }
            myStatement.close();
        
        } catch (Exception e) {
            System.out.println("failed");
            //TODO: Need to make it so it print an error message in the GUI but the program doesnt terminate
    }

    }

    public void deleteItemFromAvailableFood(String itemID) throws SQLException{
        initializeConnection();
        try{
            String query = "DELETE FROM available_food WHERE ItemID = (?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, itemID);

            int rowCount = myStmt.executeUpdate();
            if(rowCount == 0){
                throw new SQLException( "No rows were changed");
            }
            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
            //we need to handle if deletion doesnt work
        }

    }


  

    
}






