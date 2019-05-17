/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tn0786647
 */
public class Bread 
{
    String breadType;
    int calories;
    public final static String MOTTO = "The Staff of Life";
    
    public Bread() 
    {	
    }
    
    public Bread (String breadType, int calories)
    {
        this.breadType = breadType;
        this.calories = calories;
    }
    
    public String getBreadType()
    {
        return breadType;
    }
    
    public int getCalories()
    {
        return calories;
    }
    
    public void printBread()
    {
        System.out.println(breadType + ": " + calories + " calories.");
    }
    
}
