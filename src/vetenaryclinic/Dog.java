/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetenaryclinic;

/**
 *
 * @author Justin
 */

import java.util.*;
import java.text.*;
/**
 * The Dog class is a Pet object to store information of a dog patient which is identified by breed.
 * 
 */
public class Dog extends Pet{
    
    /* Define attributes */
    private String breed;
    
    /** Constructor with no arguments 
     * 
     */
    public Dog()
    {
        super();
    }
    
    /** Constructor with arguments
     * 
     * @param petId pet Id of the dog
     * @param name Name of the dog
     * @param weight Weight of the dog in kilograms
     * @param dob Date of birth of the dog
     * @param breed Breed of the dog
     */
    public Dog(int petId, String name, double weight, Date dob, String breed)
    {
        super(petId, name, weight, dob);
        this.setBreed(breed);
    }

    /**
     * Return the breed of the dog
     * @return the breed of the dog
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Set the breed of the dog
     * @param breed the breed of the dog
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    /* toString method */
    public String toString()
    {
        /* Use DecimalFormat class to format all the decimal output to 2 decimal places */
        DecimalFormat decimal = new DecimalFormat(".00");
        /* Use simpleDateFormat to parse the date object to its appropriate output format */
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dob = format.format(super.getDob());
        return "Pet ID: " + super.getPetID() + "\n" + "Dog name: " + super.getName() + "\n" + "Breed: " + this.getBreed() + "\n" + "Weight(kg): " + decimal.format(super.getWeight()) + "\n" + "Date of birth: " + dob + "\n" +  "AccumulatedDose(mg): " + decimal.format(super.getAccumulatedDose()) + "\n";
    }
   
    /**
     * Calculate drug dosage for the dog 
     * @return the drug dosage in miligrams that will be administered to the dog based on its age and weight
     */
    public double getDose()
    {
        double dose = 0;
        /* If the age is less than 3 months or the accumulated dose is greater than 750mg, the dose is 0 */
        if ((super.findAge() < 3 )|| (super.getAccumulatedDose() > 750))
        {
            dose = 0;
        }
        /* If the age is greater than 12 months and less than 2 kg, the dose is 12 + 0.65 * weight */
        else if ((super.findAge() > 12) && (super.getWeight() < 2))
        {
            dose = (6 + (0.75 * (super.getWeight())));
        }
        /* Else, the dose is 12 + 0.65kg * weight */
        else
        {
            dose = (12 + (0.65 * (super.getWeight())));
        }
        return dose;
        
    }
    
    
    
    
    
    
    
}
