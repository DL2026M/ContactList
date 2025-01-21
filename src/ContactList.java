import java.util.ArrayList;
import java.util.Scanner;

// By David Lutch

public class ContactList {
    // Instance Variable
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        // Asks the user about the attributes of the person
        Scanner personOption = new Scanner(System.in);
        System.out.println("Select a type of contact to add: \n1. Student \n2. KitchenStaff");
        int input = personOption.nextInt();
        personOption.nextLine();
        System.out.println("Please fill in the following information. \nFirst Name:");
        String userFirst = personOption.nextLine();
        System.out.println("Last Name:");
        String userLast = personOption.nextLine();
        System.out.println("Phone Number:");
        String userPhone = personOption.nextLine();
        if (input == 1) {
            System.out.println("Grade:");
            int userAge = personOption.nextInt();
            // Adds a new student person to the contacts ArrayList
            contacts.add(new Student(userFirst, userLast, userPhone, userAge));
        }
        else if (input == 2) {
            System.out.println("Salary:");
            double userSalary = personOption.nextDouble();
            personOption.nextLine();
            System.out.println("Skill Level:");
            int userSkill = personOption.nextInt();
            personOption.nextLine();
            System.out.println("Favorite Meal:");
            String userFavorite = personOption.nextLine();
            // Adds a new KitchenStaff person to the contacts ArrayList
            contacts.add(new KitchenStaff(userFirst, userLast, userPhone, userSalary, userSkill, userFavorite));
        }
    }
    // A for-each loop that prints the toString method of every person
    public void printContacts() {
        for (Person anyPerson : contacts) {
            System.out.println(anyPerson.toString());
        }
    }

    public ArrayList<Person> sort(int sortBy) {
        // Creates a temporary variable for swapping
        Person temp;
        int size = contacts.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Creating a new variable every run through so the previous value doesn't get saved
                int sortingVariable;
                if (sortBy == 0) {
                // Sets sorting equal to the lexicographic difference between the first names
                    sortingVariable = (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()));
                }
                else if (sortBy == 1) {
                    sortingVariable = (contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()));
                }
                else {
                    sortingVariable = (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()));
                }
                // Swap the order of the contacts if the lexicographic difference is positive
                if (sortingVariable > 0) {
                    temp = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1, temp);
                }
            }
        }
        return contacts;
    }
    // Checks to see if the first name inputted by the user is a user
    public Person searchByFirstName(String firstName) {
        for (Person person: contacts)
            if (person.getFirstName().equals(firstName)) {
                return person;
            }
        return null;
    }
    public Person searchByLastName(String lastName) {
        for (Person last: contacts)
            // Compares the last name in the contact list to the last name inputted by the user
            if (last.getLastName().equals(lastName)) {
                return last;
            }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person phone: contacts)
            if (phone.getPhoneNumber().equals(phoneNumber)) {
                return phone;
            }
        return null;
    }

    public void listStudents() {
        for (Person s : contacts) {
            // If the person is a student, then print the students to String method
            if (s instanceof Student) {
                System.out.println(s.toString());
            }
        }
    }

    public void run() {
        Scanner running = new Scanner(System.in);
        // Putting input as 10 to start the function (not 0-8)
        int input = 10;
        while (input != 0) {
            System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts " +
                    "By Last Name\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search " +
                    "By First Name\n7. Search By Last Name\n8. Search by Phone Number\n0. Exit");
            input = running.nextInt();
            running.nextLine();
            if (input == 1) {
                addContact();
            }
            else if (input == 2) {
                // Sets a person array list equal to the output of sort
                ArrayList<Person> FirstOrder = sort(0);
                for (Person anyPerson : FirstOrder) {
                    System.out.println(anyPerson.toString());
                }
            }
            else if (input == 3) {
                ArrayList<Person> LastOrder = sort(1);
                for (Person anyPerson : LastOrder) {
                    // Prints each person in the correct order
                    System.out.println(anyPerson.toString());
                }
            }
            else if (input == 4) {
                ArrayList<Person> numberOrder = sort(2);
                for (Person anyPerson : numberOrder) {
                    System.out.println(anyPerson.toString());
                }
            }
            else if (input == 5) {
                listStudents();
            }
            // Searches to see if the name inputted is in the array list
            else if (input == 6) {
                System.out.println("Enter a name: ");
                String first = running.nextLine();
                Person searcherFirst = searchByFirstName(first);
                if (searcherFirst == null) {
                    System.out.println(first + " is not in the list");
                }
                else {
                    System.out.println(searcherFirst.toString());
                }
            }
            else if (input == 7) {
                // Asks the user to input a name
                System.out.println("Enter a last name: ");
                String last = running.nextLine();
                Person searcherLast = searchByLastName(last);
                if (searcherLast == null) {
                    System.out.println(last + " is not in the list");
                }
                else {
                    System.out.println(searcherLast.toString());
                }
            }
            else if (input == 8) {
                System.out.println("Enter a phone number: ");
                String number = running.nextLine();
                Person searcherNumber = searchByPhoneNumber(number);
                if (searcherNumber == null) {
                    System.out.println(number + " is not in the list");
                }
                else {
                    System.out.println(searcherNumber.toString());
                }
            }
        }
    }
    public static void main(String[] args) {
        ContactList newList = new ContactList();
        newList.run();
        }
}
