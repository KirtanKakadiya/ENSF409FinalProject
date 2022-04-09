/*
@Authors: Manraj Singh, Kartik Sharma, Sajan Hayer, Kirtan Kakadiya
@Version: 1.0
@Since: 1.0
 */

package edu.ucalgary.ensf409;

public class Nutrition {
    private int wholeGrainPercentage = 0;
    private int fruitVeggiePercentage = 0;
    private int proteinPercentage = 0;
    private int otherPercentage = 0;
    private int dailyCalories = 0;

    public Nutrition(int wholeGrain, int fruitVeggie, int protein, int other, int calories){
        this.wholeGrainPercentage = wholeGrain;
        this. fruitVeggiePercentage = fruitVeggie;
        this.proteinPercentage = protein;
        this.otherPercentage = other;
        this.dailyCalories = calories;
    }

    public int getGrainPercentage(){
        return this.wholeGrainPercentage;
    }

    public int getFVPercentage(){
        return this.fruitVeggiePercentage;
    }

    public int getProteinPercentage(){
        return this.proteinPercentage;
    }

    public int getOtherPercentage(){
        return this.otherPercentage;
    }

    public int getDailyCalories(){
        return this.dailyCalories;
    }

}
