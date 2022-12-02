package Eddie.Riley;

import java.util.ArrayList;

public class MobilePhone {
    ArrayList<Contacts> ContactList = new ArrayList<Contacts>();

    public MobilePhone(){
    }

    //add a new contact
    public void addContact(Contacts newContact){
        this.ContactList.add(newContact);
    }
    //remove contact
    public void removeContact(Contacts removableContact){
        this.ContactList.remove(removableContact);
    }

    public ArrayList<Contacts> getContactList() {
        return ContactList;
    }

    //looking for contact by name
    public int searchForContactName(String name){
        int position = -1;
       for(int i = 0;i<this.ContactList.size();i++){

           if(this.ContactList.get(i).getName().equals(name))
               position = i;
           }
        System.out.println(position);
         return position;

    }

    //looking for contact by phone number

}
