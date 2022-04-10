/*
@Authors: Manraj Singh, Kartik Sharma, Sajan Hayer, Kirtan Kakadiya
@Version: 1.0
@Since: 1.0
 */

package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class finalProjTests {

    public static int ID = 225;
    public static boolean tChoice = true;
    public static String orderName = "FirstOrder";
    public static String orderDate = "04/01/2022";
    public static int size = 4;
    public static String itemID = "22";
    public static String foodName = "Potato";
    public static Nutrition nutriFact;
    public static int wholeGrain = 30;
    public static int fruitVeggiesPer = 15;
    public static int proteinPer = 30;
    public static int otherPer = 25;
    public static int dailyCalories = 400;

    // Test the constructor for ApplicationForm with good input
    @Test
    public void testApplicationFormConstructorGood(){
        ApplicationForm form = new ApplicationForm(tChoice, orderName, orderDate, size); // Intitalize Application Form object
        assertNotNull("ApplicationForm constructor did not create an object when given valid arguments were provided.", form);
    }

    // Test the constructor for ApplicationForm with bad input
    @Test
    public void testApplicationFormConstructorBad(){
        boolean expectedException = false;
        try{
            ApplicationForm form = new ApplicationForm(tChoice, orderName, orderDate, size);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("ApplicationForm constructor did not throw an illegal argument exception when invalid argument were provided.",true, expectedException);
    }

    // Test the constructor for Client with good input
    @Test
    public void testClientConstructorGood(){
        Client client = new Client(ID);
        assertNotNull("Client constructor did not create an object when given valid arguments were provided.", client);
    }

    // Test the constructor for Client with bad input
    @Test
    public void testClientConstructorBad(){
        boolean expectedException = false;
        try{
            Client client = new Client(ID);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("Client constructor did not throw an illegal argument exception when invalid client ID was provided.", true, expectedException);
    }

    // Test the constructor for Hamper with good input
    @Test
    public void testHampersConstructorGood(){
        Client client = new Client(ID);
        Hampers hamper = new Hampers(size, client);
        assertNotNull("Hampers constructor did not create an object when given valid arguments were provided.", hampers);
    }

    // Test the constructor for Hampers with bad input
    @Test
    public void testHampersConstructorBad(){
        boolean expectedException = false;
        Client client = new Client(ID);
        try{
            Hampers hamper = new Hampers(size, client);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("Hampers constructor did not throw an illegal argument exception when illegal size or client provided.",true, expectedException);
    }

    // Test the constructor for GenerateHampers with good input
    @Test
    public void testGenerateHampersGood(){
        Client client = new Client(ID);
        Hampers hamper = new Hampers(size, client);
        GenerateHampers generatedHamper = new GenerateHampers(hamper);
        assertNotNull("GenerateHampers constructor did not create an object when given valid arguments were provided.", generatedHampers);
    }

    // Test the constructor for GenerateHampers with bad input
    @Test
    public void testGenerateHampersBad(){
        boolean expectedException = false;
        Client client = new Client(ID);
        Hampers hamper = new Hampers(size, client);
        try{
            GenerateHampers generatedHamper = new GenerateHampers(hamper);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("GenerateHampers constructor did not throw an illegal argument exception when invalid hampers argument was provided.",true, expectedException);
    }

    // Test the constructor for GenerateOrderForm with good input
    @Test
    public void testGenerateOrderFormGood(){
        ApplicationForm form = new ApplicationForm(tChoice, orderName, orderDate, size);
        GenerateOrderForm orderForm = new GenerateOrderForm(form);
        assertNotNull("GenerateOrderForm constructor did not create an object when given valid arguments were provided.", orderForm);
    }

    // Test the constructor for GenerateOrderForm with bad input
    @Test
    public void testGenerateOrderFormBad(){
        boolean expectedException = false;
        ApplicationForm form = new ApplicationForm(tChoice, orderName, orderDate, size);
        try{
            GenerateOrderForm orderForm = new GenerateOrderForm(form);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("GenerateOrderForm constructor did not throw an illegal argument exception when invalid orderForm argument was provided.", true, expectedException);
    }

    // Test the constructor for Food with good input
    @Test
    public void testFoodGood(){
        Food foodObject = new Food(itemID, foodName, nutriFact);
        assertNotNull("Food constructor did not create an object when given valid arguments were provided.", foodObject);
    }

    // Test the constructor for GenerateHampers with bad input
    @Test
    public void testFoodBad(){
        boolean expectedException = false;
        try{
            Food foodObject = new Food(itemID, foodName, nutriFact);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("Food constructor did not throw an illegal argument exception when one or more invalid arguments were provided.",true, expectedException);
    }

    // Test the constructor for Nutrition with good input
    @Test
    public void testNutritionGood(){
        nutriObject = new Nutrition(grain, veggies, protein, other, calories);
        assertNotNull("Nutrition constructor did not create an object when given valid arguments were provided.", nutriObject);
    }

    // Test the constructor for Nutrition with bad input
    @Test
    public void testNutritionBad(){
        boolean expectedException = false;
        try{
            Nutrition nutriObject = new Nutrition(grain, veggies, protein, other, calories);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("Nutrition constructor did not throw an illegal argument exception when one or more invalid arguments were provided.", true, expectedException);
    }

    // Test the constructor for Inventory with good input
    @Test
    public void testInventoryGood(){
        LinkedList<Food> foodList = new LinkedList<Food>();
        Inventory inventoryObject = new Inventory(foodList);
        assertNotNull("Inventory constructor did not create an object when given valid arguments were provided.", inventoryObject);
    }

    // Test the constructor for Inventory with bad input
    @Test
    public void testInventoryBad(){
        boolean expectedException = false;
        LinkedList<Food> foodList = new LinkedList<Food>();
        try{
            Inventory inventoryObject = new Inventory(foodList);
        }catch(IllegalArgumentException e){
            expectedException = true;
        }
        assertEquals("Inventory constructor did not throw an illegal argument exception when valid food argument was provided.", true, expectedException);
    }

    //Testing getters for the ApplicationForm class
    @Test
    public void testApplicationFormGetters(){
        ApplicationForm form = new ApplicationForm(tChoice, orderName, orderDate, size);

        String name = form.getOrderName();
        String expectedName = "FirstOrder";
        assertEquals("Method getOrderName did not return the expected result: ", expectedName, name);

        String date = form.getOrderDate();
        String expectedDate = "04/01/2022";
        assertEquals("Method getOrderDate did not return the expected result: ", expectedDate, date);

    }

    //Test the getters for the Client class
    @Test
    public void testClientGetters(){
        Client client = new Client(ID);

        //testing getClientID
        int id = client.getClientID();
        int expectedID = 225;
        assertEquals("Method getClientID did not return the expected result: ", expectedID, id);

        //testing getClientType
        String clientType = client.getClientID();
        String expectedClientType = "Adult Male";
        assertEquals("Method getClientType did not return the expected result: ", expectedClientType, clientType);

        //testing getProtein
        int protein = client.getProtein();
        int expectedProtein = 26;
        assertEquals("Method getProtein did not return the expected result: ", expectedProtein, protein);

        //testing getGrain
        int grain = client.getGrain();
        int expectedGrain = 16;
        assertEquals("Method getGrain did not return the expected result: ", expectedGrain, grain);

        //testing getFV
        int FV = client.getFV();
        int expectedFV = 28;
        assertEquals("Method getFV did not return the expected result: ", expectedFV, FV);

        //testing getCalories
        int calories = client.getCalories();
        int expectedCalories = 2500;
        assertEquals("Method getCalories did not return the expected result: ", expectedCalories, calories);

        //testing getOther
        int other = client.getOther();
        int expectedOther = 30;
        assertEquals("Method getOther did not return the expected result: ", expectedOther, other);
    }

    //Testing getters in class Food
    @Test
    public void testFoodGetters(){
        String Name = "Potato";
        Food food = new Food(itemID, Name, nutritionalFacts);

        String itemID = food.getItemID();
        String expectedID = "22";
        assertEquals("Method getItemId did not return the expected result: ", expectedID, itemID);

        String name = food.getFoodName();
        String expectedName = "Potato";
        assertEquals("Method getFoodName did not return the expected result: ", expectedName, name);
    }

    //Testing getters in class Nutrition
    @Test
    public void testNutritionGetters(){
        Nutrition nutrition = new Nutrition(wholeGrain, fruitVeggiesPer, proteinPer, otherPer, dailyCalories);

        int grain = nutrition.getGrainPercentage();
        int expectedgrain = 30;
        assertEquals("Method getGrainPercentage did not return the expected result: ", expectedgrain, grain);

        int fruitVeggies = nutrition.getFVPercentage();
        int expectedFV = 15;
        assertEquals("Method getFVPercentage did not return the expected result: ", expectedFV, fruitVeggies);

        int protein = nutrition.getProteinPercentage();
        int expectedprotein = 30;
        assertEquals("Method getProteinPercentage did not return the expected result: ", expectedprotein, protein);

        int other = nutrition.getOtherPercentage();
        int expectedOther = 25;
        assertEquals("Method getOtherPercentage did not return the expected result: ", expectedOther, other);

        int calories = nutrition.getDailyCalories();
        int expectedCalories = 400;
        assertEquals("Method getDailyCalories did not return the expected result: ", expectedCalories, calories);
    }

    //Testing getters for the Hamper Class
    @Test
    public void testHamperGetters(){
        Client client2 = new Client(ID);
        Hampers hamper = new Hampers(familySize, client2);

        int clientTotalCalories = hamper.getTotalCalsClient();
        int expectedClientTotalCalories = 2500;
        assertEquals("Method getTotalCalsClient did not return the expected result: ", expectedClientTotalCalories, clientTotalCalories);

        int clientTotalProtein = hamper.getTotalProteinClient();
        int expectedClientTotalProtein = 35;
        assertEquals("Method getTotalProteinClient did not return the expected result: ", expectedClientTotalProtein, clientTotalProtein);

        int clientTotalGrains = hamper.getTotalGrainsClient();
        int expectedClientTotalGrains = 25;
        assertEquals("Method getTotalGrainsClient did not return the expected result: ", expectedClientTotalGrains, clientTotalGrains);

        int clientTotalFV = hamper.getTotalFVClient();
        int expectedClientTotalFV = 40;
        assertEquals("Method getTotalFVClient did not return the expected result: ", expectedClientTotalFV, clientTotalFV);

        int clientTotalOther = hamper.getTotalOtherClient();
        int expectedClientTotalOther = 50;
        assertEquals("Method getTotalFVClient did not return the expected result: ", expectedClientTotalOther, clientTotalOther);
    }
}
