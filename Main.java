package Eddie.Riley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("(859) 327-8845");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();

        while(!quit){
            System.out.print("\nEnter action (6 to show available actions.): ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Shutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }

        }


        }


   private static void queryContact(){
       System.out.println("Enter name of contact to query: ");
       String name = scanner.nextLine();
       Contact contactInQuestion = mobilePhone.queryContact(name);
       if(contactInQuestion != null){
           System.out.println("Phone number of contact is: " + contactInQuestion.getPhoneNumber());
           System.out.println("Enjoy!");
       }
       else
           System.out.println("Contact is not in phone, sorry!");
   }
    private static void addNewContact(){
        System.out.println("What is the name of the new contact?");
        String name = scanner.nextLine();
        System.out.println("What is the phone number of the new contact?");
        String phoneNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(name,phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added " + name + " Phone: " + phoneNumber);
        }
        else
            System.out.println("Contact already exists");


    }
    private static void removeContact(){
        System.out.println("Enter name of contact you wish to delete: ");
        String name = scanner.nextLine();
        Contact doomedContact = mobilePhone.queryContact(name);
        if(doomedContact != null){
            mobilePhone.removeContact(doomedContact);
            System.out.println("Contact removed");
        }
        else
            System.out.println("Contact not present in phone");
    }
    private static void updateContact(){
        System.out.println("Enter name of contact you wish to update: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);

        if(existingContactRecord != null){
            System.out.println("Enter new contact name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new phone number");
            String newPhoneNumber = scanner.nextLine();
            Contact replacementContact = Contact.createContact(newName,newPhoneNumber);
                if(mobilePhone.updateContact(existingContactRecord,replacementContact)) {
                    System.out.println("Successfully added contact");
                }
                else
                    System.out.println("Contact not added, something went wrong!");
        }
        else
            System.out.println("Contact not added, something went wrong!");
    }
    private static void startPhone(){
        System.out.println("Starting phone....");
    }
    private static void printActions(){
        System.out.println("\nAvailable Actions:\npress");
        System.out.println("0  -to shut down\n"+
                "1 -to print contacts\n" +
                "2 -to add a new contact\n" +
                "3 -to update and existing contact\n"+
                "4 -to remove an existing contact\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print a list of available actions."
                );

    }





        }










