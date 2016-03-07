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
 * 
 * The Dose object contains all the information of each time the pet receives a dosage of a certain drug from the vet.
 * The accumulated dosage of drugs in the pet class is calculated based on the all the information in the arraylist of dose clases.
 * 
 */
public class Dose {
    
    /* Define attributes */
    /* Name of drug administered to the pet */
    private String nameOfDrug;
    /* Date when drug is admnistered */
    private Date date;
    /* Dose of the drug in miligrams */
    private double doseInGrams;
    
    /**
     * Constructor with no arguments
    */
    public Dose()
    {
        
    }

    /**
     * Constructor with arguments
     * @param nameOfDrug name of drug administered to the pet
     * @param date Date when drug is administered to the pet
     * @param doseInGrams the dose of drug administered to the pet in miligrams 
    */
    public Dose(String nameOfDrug, Date date, double doseInGrams) {
        this.setNameOfDrug(nameOfDrug);
        this.setDate(date);
        this.setDoseInGrams(doseInGrams);
    }

    /**
     * return the name of drug administered to the pet
     * @return the name of drug administered to the pet
     */
    public String getNameOfDrug() {
        return nameOfDrug;
    }

    /**
     * Set the name of the drug administered to the pet
     * @param nameOfDrug the name of the drug administered to the pet
     */
    public void setNameOfDrug(String nameOfDrug) {
        this.nameOfDrug = nameOfDrug;
    }

    /**
     * return the date when the dose of drug is administered to the pet
     * @return the date when the dose of drug is administered to the pet
     */
    public Date getDate() {
        return date;
    }

    /**
     * set the date when the dose of drug is administered to the pet
     * @param date the date when the dose of drug is administered to the pet
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * return the dose of drugs in miligrams 
     * @return the dose of drugs in miligrams 
     */
    public double getDoseInGrams() {
        return doseInGrams;
    }

    /**
     * Set the dose of drug in miligrams
     * @param doseInGrams the dose of drug in miligrams
     */
    public void setDoseInGrams(double doseInGrams) {
        this.doseInGrams = doseInGrams;
    }
    
    /* toString method */
    public String toString()
    {
        /* Use DecimalFormat class to format all the decimal output to 2 decimal places */
        DecimalFormat decimal = new DecimalFormat(".00");
        /* Use simpleDateFormat to parse the date object to its appropriate output */
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dob = format.format(this.getDate());
        return "Date: " +  dob + "\n" + "Name of drug: " + this.getNameOfDrug() + "\n" + "Dose in miligrams: " + decimal.format(this.getDoseInGrams()) + "\n";
    }
    
    
    
   
    
    
}
