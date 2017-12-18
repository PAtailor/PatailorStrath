package lab1;
import java.util.Scanner;

public class Lab1 {

public static class printer{

public static String printerout(String text){    
System.out.println("Your text is "+text);
return text;}
}   
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
System.out.println("Please input text to output: ");
printer.printerout(scan.nextLine());
}
}