package lab3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CrudOperations {
    private int student_id;
    private String first_name,last_name,gender,degree_programme;
//getter methods
    public int getStudent_id() {return student_id;}
    public String getFirst_name() {return first_name;}
    public String getLast_name() {return last_name;}
    public String getGender() {return gender;}
    public String getDegree_programme() {return degree_programme;}
    
//setter methods    
    public void setStudent_id(int student_id) {this.student_id = student_id;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}
    public void setGender(String gender) {this.gender = gender;}
    public void setDegree_programme(String degree_programme) {this.degree_programme = degree_programme;}
    
//Processing gender...converting to int
public int processGender (String g){if(g.equalsIgnoreCase("M")){return 1;}return 0;}
//Processing gender...converting to String
public String processGender(int g){if (g == 1 ){return "M";}return "F";}
    


public boolean save(){
PreparedStatement pst = null;
Connection con = new DBConnector().con;
    
try{
    pst = con.prepareStatement("INSERT INTO "
            + "student_details(student_id,first_name,last_name,gender,degree_programme) "
            + "VALUES(?,?,?,?,?)");
    pst.setInt(1,getStudent_id());
    pst.setString(2,getFirst_name());
    pst.setString(3,getLast_name());
    pst.setInt(4,processGender(getGender()));
    pst.setString(5,getDegree_programme());           
    pst.executeUpdate();
    con.commit();
            return true;}
         
        catch (SQLException ex) {Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,"SQLException: " + ex.getMessage()+ "\nSQLState: " + ex.getSQLState()+
        "\nVendorError: " + ex.getErrorCode());}
    return true;}

public boolean remove(){
PreparedStatement pst = null;
Connection con = new DBConnector().con;
try{
pst = con.prepareStatement("DELETE FROM student_details WHERE student_id = ?");
pst.setInt(1,getStudent_id());
int remDel = pst.executeUpdate();
if (remDel == 1)
{System.out.println("Student with Id " + getStudent_id() + " has been removed successfully." );
con.commit();
}
else{System.out.println("Student ID " + getStudent_id()+" does not exist" );}}
catch (SQLException ex) {Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,"SQLException: " + ex.getMessage()+ "\nSQLState: " + ex.getSQLState()+
        "\nVendorError: " + ex.getErrorCode());}
return true;}

public boolean update(){
// This method updates the record in the database
ResultSet rs = null;
PreparedStatement pst = null;
Connection con = new DBConnector().con;
Scanner updIn = new Scanner(System.in);
   
// Check that the record exists
try{
pst = con.prepareStatement("SELECT * FROM student_details WHERE student_id = ?");
pst.setInt(1,getStudent_id());
rs = pst.executeQuery();
// If the record exists, ask user which parameter they would like to update
if (rs.next())
{ System.out.println(""
        + "Which field would you like to update:\n"
        + "1. Student ID\n"
        + "2. First name\n"
        + "3. Last Name\n"
        + "4. Gender\n"
        + "5. Programme" );

int upd = updIn.nextInt();
// Depending on their selection, use setter to set value, and update database
switch (upd){

case 1:
System.out.println("Enter new ID for the student:");
int i = updIn.nextInt();
pst = con.prepareStatement("UPDATE student_details SET student_id = ? WHERE student_id = " + getStudent_id());
pst.setInt(1,i);
pst.executeUpdate();
break;

case 2 :
System.out.println("Enter new first name for the student:");
String name = updIn.next();
pst = con.prepareStatement("UPDATE student_details SET "+ "first_name = ? WHERE student_id = " + getStudent_id());
pst.setString(1,name);
pst.executeUpdate();
break;

case 3 :
System.out.println("Enter new last name for the student:");
String lname = updIn.next();
pst = con.prepareStatement("UPDATE student_details SET last_name = ? where student_id = " + getStudent_id());
pst.setString(1,lname);
pst.executeUpdate();
break;

case 4 :
System.out.println("Enter new gender for the student:");
String g = updIn.next();
pst = con.prepareStatement("UPDATE student_details SET gender = ? where student_id = " + getStudent_id());
pst.setInt(1,processGender(g));
pst.executeUpdate();
break;

case 5 :
System.out.println("Enter new degree programme for the student:");
String prog = updIn.next();
pst = con.prepareStatement("UPDATE student_details SET degree_programme = ? where student_id = "+ getStudent_id());
pst.setString(1,prog);
pst.executeUpdate();
break;

default:
System.out.println("Invalid parameter selected");
}
//to commit updates
con.commit();
}

else{System.out.println("That StudentID does not exist on our system.");}}

catch (SQLException ex) {Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,"SQLException: " + ex.getMessage()+ "\nSQLState: " + ex.getSQLState()+
        "\nVendorError: " + ex.getErrorCode());}

return true;
}

public boolean oldRecord(int reg_number) {
ResultSet rs = null; 
PreparedStatement pst = null;
Connection con = new DBConnector().con;
CrudOperations trans = new CrudOperations();
        
try{
//Get the record from the database;
pst = con.prepareStatement("SELECT * FROM student_details WHERE student_id = ?");
pst.setInt(1,getStudent_id());
rs = pst.executeQuery();
// extracting the details to be filled in the old 
while (rs.next()){
setStudent_id(rs.getInt(1));
setFirst_name(rs.getString(2));
setLast_name(rs.getString(3));
setGender(processGender(rs.getInt(4)));
setDegree_programme(rs.getString(5));
                    
pst = con.prepareStatement("INSERT INTO student_old "
                            + "(student_id, first_name, last_name, gender, "
                            + "degree_programme) VALUES (?,?,?,?,?)");    
                            pst.setInt(1,getStudent_id());
                            pst.setString(2,getFirst_name());
                            pst.setString(3,getLast_name());
                            pst.setInt(4,processGender(getGender()));
                            pst.setString(5,getDegree_programme());
                            int oldentry = pst.executeUpdate();
                        
// Commit to be success
//failure is rollback.
if (oldentry == 1){con.commit();return true;}
else {con.rollback();return false;}}}
catch (SQLException ex) {Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,"SQLException: " + ex.getMessage()+ "\nSQLState: " + ex.getSQLState()+
        "\nVendorError: " + ex.getErrorCode());}
return true;}
}

