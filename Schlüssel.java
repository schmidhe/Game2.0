
public class Schlüssel extends Gegenstand
{
   Gegenstand Gegenstand= new Gegenstand();
    boolean verschlossentür;
    public Schlüssel()
    {
     aufhebbar=true;
    Name ="Schlüssel";
    verschlossentür=false;
    }
    
    public String gebName(){
    return Name;
    
    }
   
}

