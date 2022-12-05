package Eddie.Riley;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    public ArrayList<Contact> myContacts;

    MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);

        if (foundPosition < 0) {
            System.out.println(oldContact.getName() +
                    " is not in the system!");
            return false;
        }
        else if(findContact(newContact.getName())>-1){
            System.out.println("New Contact " + newContact.getName() + ", already exists...." +
                    "NOT updated!");
            return false;
        }

        for(int i = 0;i<this.myContacts.size();i++){
            System.out.println(contactsAreEqual(this.myContacts.get(i),newContact));
            if(contactsAreEqual(this.myContacts.get(i),newContact)){
                System.out.println(newContact.getName() + ", is already a contact, can't add!");
                return false;
            }
        }


        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;

    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }

        }
        return -1;

    }

    private String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    private Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + " -> "
                    + this.myContacts.get(i).getPhoneNumber());
        }
    }


    public boolean contactsAreEqual(Contact contactI, Contact contactII) {
        String name1 = contactI.getName();
        String ph1 = contactI.getPhoneNumber();
        String name2 = contactII.getName();
        String ph2 = contactII.getPhoneNumber();

        if(name1.equals(name2) && ph1.equals(ph2)){
            return true;
        }
        else
            return false;

        }
    }
