package Eddie.Riley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        //initiate your mobile phone object!
        MobilePhone myPhone = new MobilePhone();
        //display initial menu!
        boolean exit = false;
        int choice;
        displayMenu();

        while (!exit) {
            System.out.print("Enter your menu choice plz: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    displayMenu();
                    break;
                case 1:
                    addNewContact(myPhone);
                    break;
                case 2:
                    updateContact(myPhone);
                    break;
                case 3:
                    deleteContact(myPhone);
                    break;
                case 4:
                    searchForContact(myPhone);
                    break;
                case 5:
                    listContacts(myPhone);
                    break;
                default:
                    exit = true;

            }

        }


    }

    public static void displayMenu() {
        System.out.println("       Welcome to Samsung T-Mobile!");
        System.out.println(" 0. Print Menu");
        System.out.println(" 1. Add New Contact");
        System.out.println(" 2. Update existing Contact");
        System.out.println(" 3. Remove Contact");
        System.out.println(" 4. Search for/find existing Contact");
        System.out.println(" 5. List Contacts");
        System.out.println(" 6. Exit");
    }

    public static void addNewContact(MobilePhone myPhone) {
        scanner.nextLine();
        System.out.print("Enter Name of contact: ");
        String name = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter phone number of contact: ");
        String phoneNumber = scanner.nextLine();
        scanner.nextLine();


        Contacts newContact = new Contacts();
        newContact.setName(name);
        newContact.setPhoneNumber(phoneNumber);
        myPhone.addContact(newContact);
    }

    public static void updateContact(MobilePhone phone) {
        String newPhoneNumber;
        String filler = scanner.nextLine();
        System.out.println("Plz to enter name of contact to modify: ");
        String name = scanner.nextLine();


        int position = phone.searchForContactName(name);

        if (position >= 0) {
            System.out.println("Enter new phone number, plz: ");
            newPhoneNumber = scanner.nextLine();
            scanner.nextLine();
            phone.getContactList().get(position).setPhoneNumber(newPhoneNumber);

        } else
            System.out.println("That name is not in this phone, sorry!");
    }

    public static void listContacts(MobilePhone phone) {
        int size = phone.getContactList().size();
        for (int i = 0; i < size; i++) {
            System.out.println(phone.getContactList().get(i));


        }
    }

    public static void searchForContact(MobilePhone phone) {
        String filler = scanner.nextLine();
        System.out.println("Enter name to search for: ");
        String name = scanner.nextLine();
        int position = phone.searchForContactName(name);
        if (position >= 0) {
            System.out.println("This person " + name + ", is in your contacts at position " + (position + 1));
        } else
            System.out.println("This person is not in your contact list.");
    }

    public static void deleteContact(MobilePhone phone){
        scanner.nextLine();
        System.out.println("Enter name of person you wish to delete: ");
        String name = scanner.nextLine();

        int position = phone.searchForContactName(name);
        if(position >=0) {
            phone.removeContact(phone.getContactList().get(position));
        }
    }


        }











