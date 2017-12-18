package lab1;

public class JavaLessonTesting {

public static void main(String[] args) throws InvalidAgeException {
checkAge(12); 

}
public static void checkAge(int age)throws InvalidAgeException {
try{if (age<18){throw new InvalidAgeException("");}
else{System.out.println("You are eligible to vote");}}
catch(InvalidAgeException ex){System.err.println("You must be 18yrs old to vote"); }
}
public static class InvalidAgeException extends Exception{
    public InvalidAgeException(String customMessage){
    super(customMessage);}}
}

