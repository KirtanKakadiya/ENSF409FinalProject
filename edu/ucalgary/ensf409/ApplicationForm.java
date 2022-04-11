/*
@Authors: Manraj Singh, Kartik Sharma, Sajan Hayer, Kirtan Kakadiya
@Version: 1.0
@Since: 1.0
 */

package edu.ucalgary.ensf409;

public class ApplicationForm {
    private final boolean TRANSPORT_REQUIREMENT;
    private final String ORDER_NAME;
    private final String ORDER_DATE;
    private final int countAdultMales;
    private final int countAdultFemales;
    private final int countChildUnder8;
    private final int countChildOver8;
    private final int hamperChoice;


    public ApplicationForm(boolean transportChoice, String orderName, String orderDate, int numAdultMales,
                           int numAdultFemales, int numChildUnder8, int numChildOver8, int hampChoice){
        this.TRANSPORT_REQUIREMENT = transportChoice;
        this.ORDER_NAME = orderName;
        this.ORDER_DATE = orderDate;
        this.countAdultMales = numAdultMales;
        this.countAdultFemales = numAdultFemales;
        this.countChildUnder8 = numChildUnder8;
        this.countChildOver8 = numChildOver8;
        this.hamperChoice = hampChoice;
    }

    public boolean getTransportRequirement(){
        return TRANSPORT_REQUIREMENT;
    }
    public String getOrderName(){
        return ORDER_NAME;
    }
    public String getOrderDate(){
        return ORDER_DATE;
    }
    public int getCountAdultMales(){
        return countAdultMales;
    }
    public int getCountAdultFemales(){
        return countAdultFemales;
    }
    public int getCountChildUnder8(){
        return countChildUnder8;
    }
    public int getCountChildOver8(){
        return countChildOver8;
    }
    public String getHamperChoice(){
        if (hamperChoice == 0){
            return "Balanced";
        }
        if (hamperChoice == 1){
            return "Calorie Deficit (low calories)";
        }
        if (hamperChoice == 2){
            return "Muscle Building (high protein)";
        }
        else{
            return "Keto (low grains/carbs)";
        }
    }
}
