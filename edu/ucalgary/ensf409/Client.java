package edu.ucalgary.ensf409;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;


public class Client {
    private String clientID;
    private String clientType = ""; //dont hink we need this now
    private int recProtein = 0;
    private int recGrain = 0;
    private int recFV = 0; 
    private int recCalories = 0;
    private int recOther = 0;

    private int numberOfChildOver8 = 0;
    private int numberOfChildUnder8 = 0;
    private int numberOfFemales = 0;
    private int numberOfMales = 0;
    

    private HashMap<String,Nutrition> familyList = new HashMap<String,Nutrition>(); 

    private Connection dbConnect;
    private ResultSet results;

    public Client(
        String id, 
        int numberOfMales, 
        int numberOfFemales, 
        int numberOfChildOver8,
        int numberOfChildUnder8) throws SQLException
    {
            this.clientID = id;
            this.numberOfMales = numberOfMales;
            this.numberOfFemales = numberOfFemales;
            this.numberOfChildUnder8= numberOfChildUnder8;
            this.numberOfChildOver8 = numberOfChildOver8;

            getDataFromDatabase();
            setClientDailyNeedValues();
    }

    

    public String getClientID(){
        return this.clientID;
    }

    public String getClientType(){
        return this.clientType;
    }

    public int getProtein(){
        return this.recProtein;
    }

    public int getGrain(){
        return this.recGrain;
    }

    public int getFV(){
        return this.recFV;
    }

    public int getCalories(){
        return this.recCalories;
    }

    public int getOther(){
        return this.recOther;
    }

    public void setClientDailyNeedValues(){
        if(numberOfMales != 0){
            Nutrition maleNeeds = familyList.get("Adult Male");
            recProtein += (maleNeeds.getProteinPercentage()) * numberOfMales;
            recFV += (maleNeeds.getFVPercentage()) * numberOfMales;
            recGrain += (maleNeeds.getGrainPercentage()) * numberOfMales;
            recOther += (maleNeeds.getOtherPercentage()) * numberOfMales;
            recCalories += (maleNeeds.getDailyCalories()) * numberOfMales;
        }

        if(numberOfFemales != 0){
            Nutrition femaleNeeds = familyList.get("Adult Female");
            recProtein += (femaleNeeds.getProteinPercentage()) * numberOfFemales;
            recFV += (femaleNeeds.getFVPercentage()) * numberOfFemales;
            recGrain += (femaleNeeds.getGrainPercentage()) * numberOfFemales;
            recOther += (femaleNeeds.getOtherPercentage()) * numberOfFemales;
            recCalories += (femaleNeeds.getDailyCalories()) * numberOfFemales;
        }

        if(numberOfChildOver8 != 0){
            Nutrition childrenOver8Needs = familyList.get("Child over 8");
            recProtein += (childrenOver8Needs.getProteinPercentage()) * numberOfChildOver8;
            recFV += (childrenOver8Needs.getFVPercentage()) * numberOfChildOver8;
            recGrain += (childrenOver8Needs.getGrainPercentage()) * numberOfChildOver8;
            recOther += (childrenOver8Needs.getOtherPercentage()) * numberOfChildOver8;
            recCalories += (childrenOver8Needs.getDailyCalories()) * numberOfChildOver8;
        }

        if(numberOfChildUnder8 != 0){
            Nutrition chilrenUnder8Needs = familyList.get("Child under 8");
            recProtein += (chilrenUnder8Needs.getProteinPercentage()) * numberOfChildUnder8;
            recFV += (chilrenUnder8Needs.getFVPercentage()) * numberOfChildUnder8;
            recGrain += (chilrenUnder8Needs.getGrainPercentage()) * numberOfChildUnder8;
            recOther += (chilrenUnder8Needs.getOtherPercentage()) * numberOfChildUnder8;
            recCalories += (chilrenUnder8Needs.getDailyCalories()) * numberOfChildUnder8;
        }
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
    
    public void getDataFromDatabase() throws SQLException{
        initializeConnection();
        try {
            Statement myStatement = dbConnect.createStatement();
            results = myStatement.executeQuery("SELECT * FROM daily_client_needs");

            while(results.next()){
                int wholeGrain = Integer.parseInt(results.getString("WholeGrains"));
                int fruitVeggie = Integer.parseInt(results.getString("FruitVeggies"));
                int protein = Integer.parseInt(results.getString("Protein"));
                int other = Integer.parseInt(results.getString("Other"));
                int calories = Integer.parseInt(results.getString("Calories"));  
                Nutrition nutritionValues = new Nutrition(wholeGrain, fruitVeggie, protein, other, calories);
                familyList.put(results.getString("Client"), nutritionValues);
                
            }
            myStatement.close();
        
        } catch (Exception e) {
            System.out.println("failed");
            //TODO: Need to make it so it print an error message in the GUI but the program doesnt terminate
    }
    

    }



}

