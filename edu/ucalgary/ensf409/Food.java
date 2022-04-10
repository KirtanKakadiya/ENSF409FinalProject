package edu.ucalgary.ensf409;




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

   
}
