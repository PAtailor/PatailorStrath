package lab3;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {

public static void main(String[] args) throws SQLException {
DBConnector a = new DBConnector(); 
Scanner entry = new Scanner(System.in);
    System.out.println("Please select what you want to do. Reply with:"
            + "\nA. To add new record."
            + "\nD. To delete/remove a record."
            + "\nU. To update a record"
            + "\nPlease ensure your choice is in captial letters");
String enter = entry.nextLine();

switch(enter){
case "A":System.out.println("You have chosen to add a new record");
int student_id;
//random string to create input for loop
String lo = null;
do{
String first_name,last_name,gender,degree_programme;
    System.out.println("Enter your student id");student_id = entry.nextInt();entry.nextLine();
    System.out.println("Enter your first name");first_name = entry.nextLine();
    System.out.println("Enter your last name");last_name = entry.nextLine();
    System.out.println("Enter your gender\nenter m or f\n");gender = entry.nextLine();
    System.out.println("Enter your degree programme");degree_programme = entry.nextLine();
//setter to get the value
    CrudOperations newentry = new CrudOperations();
    newentry.setStudent_id(student_id);
    newentry.setFirst_name(first_name);
    newentry.setLast_name(last_name);
    newentry.setGender(gender);
    newentry.setDegree_programme(degree_programme);
//to save the values
    newentry.save();
    System.out.println("To add a new record type n to exit type anything else.");
    lo = entry.nextLine();
}
  while("n".equals(lo));
a.closeDB();
    break;

case "D":System.out.println("You have chosen to delete or remove a record");
    CrudOperations del = new CrudOperations();
    System.out.println("Please input ID number to delete record");
    student_id = entry.nextInt();
    del.setStudent_id(student_id);
    boolean commit = del.oldRecord(student_id);
    if(commit) {del.remove();}
    
break;

case "U":System.out.println("You have chosen to update a record");
CrudOperations upd = new CrudOperations();
System.out.println("Please enter the Student ID that you need to update:");
student_id = entry.nextInt();
upd.setStudent_id(student_id);
commit = upd.oldRecord(student_id);
if (commit){upd.update();}
break;

default:System.out.println("Invalid choice");
        }

DBConnector close = new DBConnector();
close.closeDB();
}
}