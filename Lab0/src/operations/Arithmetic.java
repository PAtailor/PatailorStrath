
package operations;

public class Arithmetic {
public Arithmetic(){
this.first_number=10;
this.second_number=5;
}
public Arithmetic(int first, int second){
this.first_number = first;
this.second_number = second;
}
    //data members
private int first_number,second_number;
    // member functions
public int sum(){return first_number+second_number;}
public int difference(){return first_number-second_number;}
public int product(){return first_number*second_number;}

public int getFirst_number() {return first_number;}
public int getSecond_number() {return second_number;}

public void setFirst_number(int first_number) {
this.first_number = first_number;}

public void setSecond_number(int second_number) {
this.second_number = second_number;}

}
