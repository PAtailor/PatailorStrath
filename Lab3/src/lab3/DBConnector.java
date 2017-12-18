package lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnector {
private static String driver = "com.mysql.jdbc.Driver";      
Connection con = null; 

public DBConnector(){
    
//1. Load JDBC Driver
try {Class.forName(driver);JOptionPane.showMessageDialog( null,"JDBC Connected");} 
catch (java.lang.ClassNotFoundException e) {JOptionPane.showMessageDialog( null,"JDBC driver not found");}

//2.Establish the Database Connection
try{con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ics2101","root","");
    con.setAutoCommit(false);}
catch (SQLException ex) {Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null,"SQLException: " + ex.getMessage()+ "\nSQLState: " + ex.getSQLState()+
      "\nVendorError: " + ex.getErrorCode());}

if (con != null) {JOptionPane.showMessageDialog(null,"Connected to database!");}
else {JOptionPane.showMessageDialog(null,"Failed to make connection!");}    
}

public void closeDB() {
    try {con.close();JOptionPane.showMessageDialog(null,"Connection closed");} 
    catch (SQLException ex) {Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);}
}
}

