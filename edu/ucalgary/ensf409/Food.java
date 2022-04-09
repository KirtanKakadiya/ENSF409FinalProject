package edu.ucalgary.ensf409;

import javax.swing.plaf.nimbus.State;
import java.sql.*;


public class Food {
    private String itemID = "";
    private String foodName = "";
    private Nutrition nutritionalFacts;

    public Food(String itemID, String foodName, Nutrition nutritionalFacts){
        this.itemID = itemID;
        this.foodName = foodName;
        this.nutritionalFacts = nutritionalFacts;
    }

    public String getItemID(){
        return this.itemID;
    }

    public String getFoodName(){
        return this.foodName;
    }

    public Nutrition getNutritionalFacts(){
        return this.nutritionalFacts;
    }
    
    //private Nutrition nutritonalFacts = new Nutrition();

    public void initializeConnection() throws SQLException {
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "student", "ensf");
        } catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("Cannot connect to the database!");
        }
    }

    public void getData(String tableName) throws SQLException{
        try {
            Statement myStatement = dbConnect.createStatement();
        
            results = myStatement.executeQuery("SELECT Name,GrainContent,FVContent,ProContent,Other FROM "+ tableName);
            while(results.next()){
                System.out.println(results.getString("Name") + " " + results.getString("GrainContent") + " " + results.getString("FVContent") + " " + results.getString("ProContent") + " " + results.getString("Other") + " ");

            }
            myStatement.close();
        
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void main(String[] args) {
        Food myJDBC = new Food();


        //1 mark - initializeConnection method must create a connection to the database, may not take in any arguments or return any values
        // Must throw an SQLException if connection cannot be made
        myJDBC.initializeConnection();

        myJDBC.getData("DAILY_CLIENT_NEEDS");
    }
}
