package edu.ucalgary.ensf409;

public class Client {
    private int clientID;
    private String clientType = "";
    private int recProtein;
    private int recGrain;
    private int recFV; // FV = fruit veggies
    private int recCalories;
    private int recOther;

    public Client(int id){
        this.clientID = id;
    }

    public int getClientID(){
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
}
