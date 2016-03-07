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
 *  The Cat class is a Pet object to store information of a cat patient which allergy information is required.
 */
public class Cat extends Pet
{
    /* Define attibute */
    private boolean allergic;
    
    /**
     * Constructor with no arguments 
     */
    public Cat()
    {
        super();
        this.isAllergic();
    }
    
    /**
     * Constructor with arguments 
     * @param petId auto generated pet ID
     * @param name Name of the cat
     * @param weight Weight of the cat in kilograms
     * @param dob Date of birth of the cat
     * @param allergic presence of allergy(true or false)
    */
    public Cat(int petId, String name, double weight, Date dob, boolean allergic )
    {
        super(petId, name, weight, dob);
        this.setAllergic(allergic);
    }

    /**
     * Return the presence of allergy of the cat 
     * @return the presence of allergy
     * 
     */
    public boolean isAllergic() {
        return allergic;
    }

    /**
     * Set the presence of allergy status of the cat
     * @param allergic the presence of allergy
     * 
     */
    public void setAllergic(boolean allergic) {
        this.allergic = allergic;
    }
    
    /* toString method */
    public String toString()
    {
        /* Use DecimalFormat class to format all the decimal output to 2 decimal places */
        DecimalFormat decimal = new DecimalFormat(".00");
        /* Use simpleTextFormat to parse the date to its appropriate output format */
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dob = format.format(super.getDob());
        return "Pet ID: " + super.getPetID() + "\n" + "Cat name: " + super.getName() + "\n" + "Presence of allergy: " + this.isAllergic() + "\n" + "Weight(kg): " + decimal.format(super.getWeight()) +"\n"+ "Date of birth: " + dob + "\n" + "AccumulatedDose(mg): "  + decimal.format(super.getAccumulatedDose()) + "\n";
    }
    
    /* Calculate the drug dosage for the cat */
    /**
     * return the drug dosage in miligrams that will be administered to the cat based on its weight, age and the presence of allergy
     * @return the drug dosage in miligrams that will be administered to the cat based on its weight, age and the presence of allergy
     */
    public double getDose()
    {
        double dose = 0;
        /* The dose is zero if allergy is present or the accumulated dose is greater than 500mg */
        if ((this.isAllergic() == true) || (this.getAccumulatedDose() > 500) )
        {
            dose = 0;
        }
        else
        {
            /* if the cats age is greater than 3 months and weights above 5 kg, the dose is 7 + 0.61 * weight */
            if ((super.findAge() > 3) && (super.getWeight() > 5))
            {
                dose = (7 + (0.61 * super.getWeight()));
            }
            /* Else the dose is 0.81 * weight */
            else 
            {
                dose = 0.81 * super.getWeight();
            }
        }
        return dose;
    }
}
