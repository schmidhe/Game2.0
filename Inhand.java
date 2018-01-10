

/**
 * Beschreiben Sie hier die Klasse Inhand.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Inhand
{
    Gegenstand Inhand=new Gegenstand();
    Schwert Schwert=new Schwert();
        Bogen Bogen=new Bogen();
        Schild Schild=new Schild();
        Apfel Apfel=new Apfel();
    public Inhand()
    {Inhand=null;
        
    }
    public Gegenstand getInhand(){
        return Inhand;
        
    }
    public void setInhand(Mensch pMensch,Gegenstand l,int Slot){
        
        if(Inhand==Schwert){pMensch.addiereKraft(-30);}
        else if(Inhand==Bogen){pMensch.addiereKraft(-15);}
        else if(Inhand==Schild){pMensch.addiereRüstung(-15);}
        else if(Inhand==Apfel){Inhand=null;}
    
        Gegenstand f=new Gegenstand();
        f=pMensch.getInventar(Slot);
        pMensch.nehme(Slot,Inhand);
        Inhand=f;
        
         if(Inhand==Schwert){pMensch.addiereKraft(30);}
        else if(Inhand==Bogen){pMensch.addiereKraft(15);}
        else if(Inhand==Schild){pMensch.addiereRüstung(15);}
        else if(Inhand==Apfel){pMensch.addiereLeben(40);}
        
        
    }
   }


