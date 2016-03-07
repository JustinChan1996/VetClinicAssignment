/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetenaryclinic;
import java.util.*;

/**
 *
 * @author Justin
 */
/**
 * 
 * The VetClinic class is the container class of the package which stores all the pet objects in an arraylist data structure.
 */
public class VetClinic {
    
    /* Define attributes */
    /* Name of the clinic */
    private String name;
    /* Collection of pet objects */
    private ArrayList<Pet> pets = new ArrayList<Pet>();
    
    /**
     * Constructor with no arguments 
     */
    public VetClinic()
    {
        
    }
    
    /** Constructor with arguments 
     *
     * @param name Name of the clinic
     * 
     */
    public VetClinic(String name)
    {
        this.setName(name);
    }

    /**
     * Return the name of the clinic
     * @return The name of the clinic
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the clinic
     * @param name The name of the clinic
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the arrayList of all the pet objects
     * @return the arrayList of all the pets objects
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }

    /**
     * Add a pet object to the container class
     * @param pets Add a pet object to the container class
     */
    public void setPets(Pet pets) {
        this.getPets().add(pets);
    }
    
    /* toString method */
    public String toString()
    {
        return "Clinic name " + this.getName() + " has " + getPets().size() + " pets registered in the system ";
    }
}
