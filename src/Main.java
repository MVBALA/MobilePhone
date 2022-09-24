import java.util.Scanner;

public class Main {
    private static Scanner s=new Scanner(System.in);
    private static MobilePhone  mobilePhone =new MobilePhone("98765 32121");
    public static void main(String[] args) {
        boolean quit=false;
        startPhone();
        printActions();
        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = s.nextInt();
            s.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
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
    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name=s.nextLine();
        System.out.println("Enter phone number: ");
        String phone = s.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }
    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name=s.nextLine();
      Contact existingRecord =  mobilePhone.queryContact(name);
      if (existingRecord==null){
          System.out.println("Contact not found");

      }
        System.out.println("Enter new contact name :");
      String newName=s.nextLine();
        System.out.println("Enter new contact phone number");
        String newPhoneNumber = s.nextLine();
        Contact newContact = Contact.createContact(newName,newPhoneNumber);
        if (mobilePhone.updateContact(existingRecord,newContact)){
            System.out.println("Sucessfully updated record");
        } else
        {
            System.out.println("Error updating record");
        }


    }
    private static void startPhone(){
        System.out.println("Starting phone....");
    }
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update  an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = s.nextLine();
        Contact existingRecord = mobilePhone.queryContact(name);
        if (existingRecord == null) {
            System.out.println("Contact not found");

        }
        if (mobilePhone.removeContact(existingRecord)){
            System.out.println("Succesfully removed");
        }else
            System.out.println("Error removing contact");
    }
    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = s.nextLine();
        Contact existingRecord = mobilePhone.queryContact(name);
        if (existingRecord == null) {
            System.out.println("Contact not found");

        }
        System.out.println("Name: " + existingRecord.getName() + " phone number is " + existingRecord.getPhoneNumber());
    }

}