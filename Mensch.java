import java.util.Scanner;

import java.util.Random;


public class Mensch

{

    

    public int Kraft=20;

    int Ausdauer;

    int Leben=100;

    int Intelligenz;


    Gegenstand[] Inventar=new Gegenstand[10];
 Random randomGenerator = new Random();

    Gegenstand Gegenstand=new Gegenstand();
int Rüstung;
    public Mensch(){
   

             

    

    

    





    

    

}

public void addiereKraft(int z){

    Kraft=Kraft+z;

}
public void addiereRüstung(int z){

   Rüstung=Rüstung+z;
   Leben=Leben+Rüstung;
}
public void nehme(int l,Gegenstand b){
   
    Inventar[l]=b;
    
}  
public void dropItems(int i){
   
    

   
        
    System.out.println("Du hast im Fach "+i+ "ein"+Inventar[i].getName());
    
    
    
    
    }
  
     public void addiereLeben(int z){
        Leben=Leben+z;
        
        
        
        
        }        
    
    
    
    
public int gebLeben(){

        return Leben;   

    }
    public void setAusdauer(int g){
    Ausdauer=g;
    
    
    }
public void setRüstung(int l)
{   


    Rüstung=l;
    
}
    public void setLeben(int l)
{   


    Leben=l;}
    public void setKraft(int l)
{   


    Kraft=l;}
        public void setIntelligenz(int l)
{   


    Intelligenz=l;}
    public int getRüstung()
{   


    return Rüstung;}
    public int getLeben()
{   


    return Leben;}
    public int getKraft()
{   


    return Kraft;}
    public Gegenstand getInventar(int h){
    return Inventar[h];
    }
      public int gebSchaden(){

        return Kraft;

    }
   

    public void Aua(int b){

        Leben=Leben-b;

    }

          
}