
public class Bogen extends Gegenstand
{
  
    boolean verschlossentür;
    public Bogen()
    {
     aufhebbar=true;
     Name="Bogen";
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

