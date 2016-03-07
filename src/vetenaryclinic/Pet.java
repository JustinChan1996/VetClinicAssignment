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

/* To do list */
/**/

import java.util.*;
import java.text.*;
/**
 * The pet class stores the attributes of each pet that has been registered with veterinary clinic. 
 * It is an abstract class which has a generalization- specialization relationship with a sub class which is identified by 
 * the type of pet. The information which is required to initialize a pet object of are the name of pet, the petID , the weight of the pet(in kg), 
 * and the Date of birth of the pet in Day/Month/Year format. The petID will be given by the system whenever to each new pet that
 * registers with the system while the accumulated Dose of drugs(in miligrams) administered to each pet will be updated whenever a dose of drugs is taken during a
 * consultation. The abstract method which will be implemented in the pet class is the getDose method which calculates the drug dose taken by
 * each pet based on the type of pet it belongs to.
 * 
 * 
*/
abstract public class Pet implements Comparable<Pet> {
    
    /* Define attributes */
    private int petID;
    private String name;
    private double weight;
    private Date dob;
    private double accumulatedDose;
    private ArrayList<Dose> doses = new ArrayList<Dose>();
    
    /**
     * Constructor without arguments 
     */
    public Pet()
    {
    }
    
    /**
     * Constructor with arguments 
     * @param petID auto generated petID
     * @param name name of the pet
     * @param weight weight of the pet in kilograms
     * @param dob date of birth of the pet 
     */
    public Pet(int petID, String name, double weight, Date dob)
    {
        this.setName(name);
        this.setPetID(petID);
        this.setWeight(weight);
        this.setDob(dob);
    }

    /**
     * Return the pet ID of the pet
     * @return the petID of the pet
     */
    public int getPetID() {
        return petID;
    }

    /**
     * Set the petID of the pet
     * @param petID the petID of the pet
     */
    public void setPetID(int petID) {
        this.petID = petID;
    }

    /**
     * Return the name of the pet
     * @return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the pet
     * @param name the name of the pet
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the weight of the pet in kilograms
     * @return the weight of the pet in kilograms
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set the weight of the pet in kilograms
     * @param weight the weight of the pet in kilograms
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Return the date of birth of the pet
     * @return the date of birth of the pet 
     */
    public Date getDob() {
        return dob;         
    }

    /**
     * Set the date of birth of the pet
     * @param dob Set the date of birth of the pet
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Return the accumulated dose of drugs administered in miligrams for the pet
     * @return the accumulated dose of drugs administered in miligrams for the pet
     */
    public double getAccumulatedDose() {
        return accumulatedDose;
    }
    
    /**
     *  Set the accumulated dose of drugs administered to the pet
     * @param dose Dose class of the pet object
     */
    private void setAccumulatedDose(Dose dose) 
    {
        this.accumulatedDose = this.accumulatedDose + dose.getDoseInGrams();
    }
    
        /**
         * Add a dose object each time the vet administers a certain drug to the pet.
     * @param dose Add a dose object each time the vet administers a certain drug to the pet.
     */
    public void setDoses(Dose dose)
    {
        this.getDoses().add(dose);
        /* Update the accumulatedDose attribute whenever a dose object is added to the pet object */
        this.setAccumulatedDose(dose);
    }
    
        /**
         * return the arraylist of the dose objects in the pet class.
     * @return the arraylist of the dose objects in the pet class.
     */
    public ArrayList<Dose> getDoses() {
        return doses;
    }
    
    /**
     * Find the age of the pet in number of months
     * @return the age of the pet in number of months
     */
    public int findAge()
    {
        /* Use SimpleDateFormat class to parse the date object to its parts which are year,month and day */
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        /* Parse the current date to Year, month and day */
        Date now = new Date();
        int intCurrentYear = Integer.parseInt(year.format(now));
        int intCurrentMonth = Integer.parseInt(month.format(now));
        /* Parse the birth date to Year, month and day */
        int intBirthYear = Integer.parseInt(year.format(this.getDob()));
        int intBirthMonth = Integer.parseInt(month.format(this.getDob()));;
        /* calculate the months interval in months */
        int AgeDifference = 0;
	if (intCurrentYear == intBirthYear)
	{
		AgeDifference = intCurrentMonth - intBirthMonth;
	}
	else if (intCurrentYear > intBirthYear)
	{
		/* Find the year difference first */
		AgeDifference = (intCurrentYear - intBirthYear - 1) * 12;
		/* Find the difference between the birth month and the last month */
		AgeDifference = AgeDifference + (12 - intBirthMonth);
		/* Then, find the month interval from the begining of the year to now */
		AgeDifference = AgeDifference + (intCurrentMonth);
		
	}
	return AgeDifference;
    }
    
    /**
      *
      * Abstract method to calculate drug dosage for a certain animal 
      */
    abstract double getDose();
    
    /** 
     * Compare the pet objects by the accumulated dose of drugs administered
     * @param obj the Pet object to compare with
     * @return the order by comparing the accumulatedDose attribute
     */
    public int compareTo(Pet obj)
    {
        int dose1 = (int) this.getAccumulatedDose();
        int dose2 = (int) obj.getAccumulatedDose();
        return dose1 - dose2;
    }
    
}
