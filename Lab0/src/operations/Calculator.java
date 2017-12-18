package operations;

public class Calculator extends Arithmetic{
public int sub;

@Override
public int difference(){

if (getFirst_number()>getSecond_number())
     
{sub = getFirst_number()-getSecond_number();
    return sub;}
    return 0;}

public int difference(int a){
if (getSecond_number()>getFirst_number())
     
{sub = getSecond_number()-getFirst_number();
    return sub;}
return 0;}
  

}
