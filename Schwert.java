
public class Schwert extends Gegenstand
{
   
   
    public Schwert()
    {
     aufhebbar=true;
     Name="Schwert";
     draufgehbar=true;
    }
    public String gebNam(){
    return Name;
    
    }
    public void Inhandbonus(Mensch Mensch){
    
        Mensch.setKraft(10);
    
    }
       public void Aushandabzug(Mensch Mensch){
    
        Mensch.setKraft(-10);
    
    }
}

