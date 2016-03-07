/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetenaryclinic;

import java.text.*;
import java.util.*;

/**
 *
 * @author Justin
 */

/**
 * The VetClinicConsole is the Controlling class of the whole application which provides a console interface for users to interact with the application.
 */
public class VetClinicConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException
    {
        /* Inititlize scanner object */
        Scanner input = new Scanner(System.in);
        /* Initialize the VetClinic object and assign a name */
        VetClinic vet = new VetClinic("Hands and Paws");
        /* Initialize variable to hold menu option selected by user */
        String menuOption = "";
        while(! menuOption.equals("6"))
        {
            /* Print out the menu options for the user to select */
            System.out.println("Vet Clinic Managment interface by Justin Chan");
            System.out.println(vet);
            System.out.println("Menu options: ");
            System.out.println("1. Add new pet");
            System.out.println("2. Delete existing pet");
            System.out.println("3. List Pets information");
            System.out.println("4. Administer drug to pet");
            System.out.println("5. Update pet information");
            System.out.println("6. Quit application");
            /* Gather input option from the user */
            System.out.print("User option: ");
            menuOption = input.nextLine();
            /* Branch according to the user selected option */
            switch (menuOption) 
            {
                    case "1":
                            /* Declare pet object to reference the subclass of the pet object */
                            /* Add a pet to the system */
                            /* prompt user to enter attributes */
                            /* Ask for pet name */
                            /* Initialzie input attrributes unique for dog and cat class */
                            String breed = "";
                            boolean allergic = true;
                            double weight = 0;
                            Date dob = null;
                            /* Generate pet Id */
                            int petId = vet.getPets().size() + 1;
                            System.out.print("Pet name: ");
                            String petName = input.nextLine();
                            /* Ask for pet type */
                            String petType = "";
                            while(!((petType.equalsIgnoreCase("Dog") || (petType.equalsIgnoreCase("Cat")))))
                            {
                                System.out.print("Pet type(dog or cat): ");
                                petType = input.nextLine();
                                /* Initialize pet object based on pet type */
                            }
                                if (petType.equalsIgnoreCase("Dog"))
                                {
                                    /* Ask user for dog breed */
                                    System.out.print("Dog breed: ");
                                    breed = input.nextLine();
                                }
                                else if (petType.equalsIgnoreCase("Cat"))
                                {
                                    /* Ask user if the cat has any allergies */
                                    String allergy = "";
                                    while (!((allergy.equalsIgnoreCase("true") || (allergy.equalsIgnoreCase("false")))))
                                    {
                                        System.out.print("Presence of allergies(true or false): ");
                                        allergy = input.nextLine();
                                        if (allergy.equalsIgnoreCase("true"))
                                        {
                                            allergic = true;
                                        }
                                        else if (allergy.equalsIgnoreCase("false"))
                                        {
                                            allergic = false;
                                        }
                                        else 
                                        {
                                            System.out.println("Invalid option ");
                                        }
                                    }
                                }
                            do
                            {
                                /* Execption block for entering weight. If exception is triggered, weight will be reseted to zero.*/
                                /* if the weight is zero, the question will be repeated again.*/
                                try
                                {
                                    /* Prompt for weight */
                                    System.out.print("Pet weight(kg): ");
                                    weight = input.nextDouble();
                                }
                                catch(InputMismatchException e)
                                {
                                    /* Handle exception for non numeric character input for weight attribute */
                                    System.out.println("Invalid input type, please enter numeric characters only");
                                    /* Reset the weight attribute to zero */
                                    weight = 0;
                                    input.next();
                                }
                                finally
                                {
                                    /* display error message if weight is negative value */
                                    if(weight < 0)
                                    {
                                        System.out.println("Weight must be a positive number");
                                    }
                                }
          
                            }
                            while(weight <= 0);
                            input.nextLine();
                            /* Exception block for entering date of birth. If exception is triggered, date of birth will be set to the present time */
                            /* if the date of birth is the present time, */ 
                            /* Create an exception flag for the date input. The original state is false but when the ParseException is triggered, 
                            the state turns to true */
                            boolean dateFlag = false;
                            do
                            {
                                try
                                {
                                    /* prompt for date of birth */
                                    System.out.print("Date of birth(dd/MM/yyyy): ");
                                    String dateString = input.nextLine();
                                    /* Use simpleDateFormat to parse the string to the date based on the format dd/MM/yyyy */
                                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                    dob = format.parse(dateString);
                                    /* if no exception is triggered, make sure the exception flag is set to false */
                                    dateFlag = false;
                                }
                                catch(ParseException e)
                                {
                                    /* Handle excpeition for wrong date format input */
                                    System.out.println("Wrong date format, please enter again");
                                    /* change exception flag to true */
                                    dateFlag = true;
                                }
                            }
                            while(dateFlag == true);
                            /* Initialize the pet object based on its subclass */
                            if (petType.equalsIgnoreCase("dog"))
                            {
                                /* if pet type is dog, initialize a dog object */
                                Dog pet = new Dog(petId, petName, weight, dob, breed);
                                /* Add dog object to the VetClinic class */
                                vet.setPets(pet);
                                System.out.println("Dog named " + petName + " successfully registered to the system");
                            }
                            else if (petType.equalsIgnoreCase("cat"))
                            {
                                /* if pet type is cat, initialize a cat object */
                                Cat pet = new Cat(petId, petName, weight, dob, allergic);
                                /* Add dog object to the VetClinic class */
                                vet.setPets(pet);
                                System.out.println("Cat named " + petName + " successfully registered to the system");
                            }
                            break;
                    case "2":
                            try
                            {
                                /* Delete a pet from the system */
                                /* Select name of pet */
                                System.out.print("Pet Id: ");
                                int IdOfPet = input.nextInt();
                                /* variable for array position with the pet's name */
                                /* Initialize it to -1 to indicate no position has been found yet */
                                int pos = -1;
                                /* Loop through the array to check which object pet's name matches the user's input */
                                for(int i = 0; i < vet.getPets().size(); i = i + 1)
                                {
                                    if(vet.getPets().get(i).getPetID() == IdOfPet)
                                    {
                                        pos = i;
                                    }
                                }
                                /* display pet information if the position of the arraylist has been found */
                                if(pos > -1)
                                {
                                    System.out.println();
                                    System.out.println(vet.getPets().get(pos));
                                    input.nextLine();
                                    System.out.print("Confirm deleting pet id " + IdOfPet + " from the system(yes or no): ");
                                    String decision = input.nextLine();
                                    /* Delete pet from the system */
                                    if(decision.equalsIgnoreCase("yes"))
                                    {
                                        vet.getPets().remove(pos);
                                        System.out.println("Pet " + IdOfPet + " has been successfully deleted from the system");
                                    }
                                    else
                                    {
                                        System.out.println("Pet " + IdOfPet + " is not deleted from the system");
                                    }
                                }
                                else
                                {
                                    System.out.println("Pet with pet Id " + IdOfPet + " has not registered with the vet");
                                    input.nextLine();
                                }
                            }
                            catch(InputMismatchException e)
                            {
                                System.out.println("Invalid input ");
                                input.nextLine();
                            }
                            break;
                    case "3":
                            /* List all the pet information in the system */
                            /* prompt user for order of listing */
                            System.out.print("Order for displaying pets information: (i) original order , (ii) accumulated dose, (iii) pet type and age: ");
                            String order = input.nextLine();
                            System.out.println();
                            if (order.equalsIgnoreCase("i"))
                            {
                                /* Display according to original order */
                                for (int i = 0; i < vet.getPets().size();i = i + 1 )
                                {
                                    System.out.println(vet.getPets().get(i));
                                }
                            }
                            else if (order.equalsIgnoreCase("ii"))
                            {
                                /* sort by accumulated dose */
                                /* Clone the original array for sorting purposes */
                                ArrayList<Pet> sortArray = (ArrayList<Pet>)vet.getPets().clone();
                                /* sort the cloned array */
                                Collections.sort(sortArray);
                                /* Display the sorted array */
                                for (int i = 0; i < sortArray.size();i = i + 1 )
                                {
                                    System.out.println(sortArray.get(i));
                                }       
                            }
                            else if (order.equalsIgnoreCase("iii"))
                            {
                                /* Sort according to pet type, then by age */
                                /* Clone the original array for sorting purposes */
                                ArrayList<Pet> sortArray = (ArrayList<Pet>)vet.getPets().clone();
                                /* sort the cloned array */
                                Collections.sort(sortArray, new PetComparator());
                                /* Display the sorted array */
                                for (int i = 0; i < sortArray.size();i = i + 1 )
                                {
                                    System.out.println(sortArray.get(i));
                                }    
                                
                                
                            }
                            else
                            {
                                System.out.println("Invalid selection");
                            }
                            break;
                                    
                            
                    case "4":
                            try
                            {
                                /* Administer a dose of drug to the pet */
                                /* Initialize Variable for position of pet object in the arraylist */
                                int posOfPet = -1;
                                /* Initialize pet Id input variable */
                                int IdOfPet = -1;
                                /* Ask for pet's id number */
                                System.out.print("pet Id: ");
                                IdOfPet = input.nextInt();
                                /* find the pet object with the matching name */
                                for(int i = 0; i < vet.getPets().size(); i = i + 1)
                                {
                                    if(vet.getPets().get(i).getPetID() == IdOfPet)
                                    {
                                        posOfPet = i;
                                    }
                                }
                                /* Only administer the dose if the pet is present, otherwise, quit the operation */
                                if(posOfPet != -1)
                                {
                                    System.out.println("pet of petId " + IdOfPet + " is found in the system ");
                                    /* ask for antibiotic name */
                                    input.nextLine();
                                    System.out.print("Name of antibiotic to be administered: ");
                                    String antibiotic = input.nextLine();
                                    /* initialize date object to present time */
                                    Date now = new Date();
                                    /* calculate antibiotic dose and initialize a dose class */
                                    double doseOfDrug = vet.getPets().get(posOfPet).getDose();
                                    Dose dose = new Dose(antibiotic, now, doseOfDrug);
                                    vet.getPets().get(posOfPet).setDoses(dose);
                                    /* Print dosage information */
                                    System.out.println("Dosage information: ");
                                    System.out.println("");
                                    System.out.println(dose);

                                }
                                else
                                {
                                    System.out.println("Pet of petId " + IdOfPet + " not found in the system");
                                    input.nextLine();
                                }
                            }
                            catch(InputMismatchException e)
                            {
                                System.out.println("Invalid input ");
                                input.nextLine();
                            }
                            break;
                            
                        
                    case "5":
                            try
                            {
                                /* initialize variable for pet Id input variable */
                                int IdOfPet = -1;
                                int position = -1;
                                /* Update pet information */
                                /* User is given option to edit pet's name and weight */
                                /* Prompt user for pet id number */
                                System.out.print("pet Id: ");
                                IdOfPet = input.nextInt();
                                /* find the object in the array which petId matches the user input */
                                for(int i = 0; i < vet.getPets().size(); i = i + 1)
                                {
                                    if(vet.getPets().get(i).getPetID() == IdOfPet)
                                    {
                                        position = i;
                                    }
                                }
                                /* allow user to change pet's details  if the object position of the array is found */
                                if(position != -1)
                                {
                                    /* display pet's details */
                                    System.out.println("pet of petId " + IdOfPet + " is found in the system ");
                                    System.out.println("");
                                    System.out.println(vet.getPets().get(position));
                                    input.nextLine();
                                    String attributeOption;
                                    do
                                    {
                                        /* Display option for user to edit */
                                        System.out.println("Select attribute to edit: ");
                                        System.out.println("1. Name of pet ");
                                        System.out.println("2. Weight of pet");
                                        System.out.println("3. Exit ");
                                        System.out.print("User option: ");
                                        attributeOption = input.nextLine();
                                        /* perform action based on user selection */
                                        if(attributeOption.equals("1"))
                                        {
                                            /* Ask user for new name" */
                                            System.out.print("New name of pet: ");
                                            String newName = input.nextLine();
                                            /* Change name attributte */
                                            vet.getPets().get(position).setName(newName);
                                            System.out.println("Name of pet is changed successfully ");
                                        }
                                        else if(attributeOption.equals("2"))
                                        {
                                            /* Ask user for new weight */
                                            System.out.print("New weight of pet: ");
                                            Double newWeight = input.nextDouble();
                                            /* Change weight attribute */
                                            vet.getPets().get(position).setWeight(newWeight);
                                            System.out.println("Weight attribute is changed successfully");

                                        }
                                        else if(attributeOption.equals("3"))
                                        {
                                            /* return to the main menu */
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("Invalid option");
                                        }

                                    }
                                    while(!attributeOption.equals("3"));
                                }
                                else
                                {
                                    System.out.println("Pet of petId " + IdOfPet + " not found in the system");
                                    input.nextLine();
                                }
                            }
                            catch(InputMismatchException e)
                            {
                                System.out.println("Invalid input ");
                                input.nextLine();
                            }
                            break;
                    case "6":
                            /* Quits the application */
                            System.out.println("Thank you for using the application ");
                            break;
                    default:
                            System.out.println("Invalid option");
                            break;
            }
            
            }
        }
    public static void addPet(Vet vc)
    {
        
    }
    
    public static void DeletePet(VetClinic vc)
    {
        
    }
    
    
}
        