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
/**
 * This class implements the Comparator interface to sort objects of the Pet class by sorting according to pet type and then followed by age 
 */
public class PetComparator implements Comparator<Pet>
{
    /**
     * 
     * @param LHS First pet object to be compared
     * @param RHS Second pet object to be compared
     * @return the order according to the pet type and then age. The order of the pet type begins with Dog and followed up by Cat.
     */
    public int compare(Pet LHS, Pet RHS)
    {
        /* Compare the type of pet. If they are the same class, then compare the age */
        if (LHS.getClass() == RHS.getClass())
        {
            return (((Pet) LHS).findAge()) - (((Pet) RHS).findAge());
        }
        else if ((LHS instanceof Dog) && (RHS instanceof Cat))
        {
            return -1;
        }
        else
        {
            return 1;
        }
        
            
    }
}
