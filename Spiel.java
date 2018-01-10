


import java.util.Scanner;
public class Spiel
{   
    private Scanner console = new Scanner(System.in);
    private Scanner consol = new Scanner(System.in);
    private String Klasse;
    private String Input;
    private String Name;
    private Magier Magier=new Magier();
    private Schütze Schütze=new Schütze();
    private Assassine Assassine=new Assassine();
    private Kämpfer Kämpfer=new Kämpfer();
    private Welt map=new Welt();
    private Gegenstand[][] Welt=new Gegenstand[56][37];
    private Parser parser;
    int Koordia=1;
    int Koordib=1;
    int z;
    String f;
    Inhand Inhand=new Inhand();
    Mensch Mensch=new Mensch();
    Boxen Kämpfen=new Boxen();
    Monster Monster=new Monster();
    Boden Boden =new Boden();
    Wand Wand =new Wand();
    Goblin Goblin=new Goblin();
    Wolf Wolf=new Wolf();
    Dämon Dämon=new Dämon(); 
    Endboss Endboss=new Endboss();
    String Tageszeit;
    int Counter;
    public Spiel()
    {
        parser = new Parser();
        Tageszeit="Tag";
        Spielen();
    }

    public void Spielen(){
        map.Erstellemap();
        Wählen();
       

        
    
    }

    public void Wählen(){
        System.out.println("Hey, Herzlich Willkommen bei unserem AdventureGame");
        System.out.println("Welcher Klasse möchtest du beitreten? Du kannst Magier, Assassine, Kämpfer oder Schütze werden!");
        Klasse= console.next();
        System.out.println("Du bist ein "+Klasse+ ". Los gehts!");
            switch (Klasse){
                        case "Magier": Magier.setMensch(Mensch);break;
                       case"Schütze":        Schütze.setMensch(Mensch);break;
            
                   case"Assassine":     Assassine.setMensch(Mensch);break;
            
                   case"Kämpfer":       Kämpfer.setMensch(Mensch);break;
                   default: System.out.println("Das geht leider nicht.");Wählen();break;
            
            }
            
      
        
            
        
        getName();
    
    }

    public void getName(){

        String Frage;
        System.out.println("Wie heißt du denn?");
        Name= console.next();
        System.out.println("Du bist also "+ Klasse +" "+ Name+" oder?");Frage= console.next();
        if(Frage.equalsIgnoreCase("Ja")){
             System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Hier eine Botschaft vom König:");
         System.out.println("Der böse Zauberer hat uns gefangen genommen, du musst uns helfen indem du den Zauberer findest und uns befreist!");
                   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            game1();

        }
        else{getName();}
       
    }

    public void  game1(){

        while (Koordia!=24 || Koordib!=43 && Mensch.getLeben()>0) {
             
            
            System.out.println("Was willst du machen?");
            Command command = parser.getCommand();
            action(command);
          
        
        }
        if(Mensch.getLeben()<0){
            System.out.println("Okay, du hast das Spiel abgebrochen...Drücke eine beliebige Taste um das Spiel vollständig zu beenden. Bis zum nächsten Mal!");
        int z=console.nextInt();
        System.exit(1);}
        else{ Kämpfen.boxen(Mensch,Endboss);}
        
        
        
        
        
        
        
    }     
    private void Counter(){
    
        if(Counter%3 ==0){
              
                     Tageszeit="Nacht";Mensch.addiereKraft(-10);System.out.println("Jetzt ist es Nacht.Du bist schwächer!");
              
            }
                if(Counter%4 ==0){
              
                  
                    Tageszeit="Tag";Mensch.addiereKraft(10);System.out.println("Jetzt ist es Tag.Du bist stärker!");
                
            }
    
    }
    private boolean action(Command command) 
    {    
        Counter++;
        Counter();
        boolean wantToQuit = false;
        if(command.isUnknown()) {
            System.out.println("Bitte was?");

        }
        
            String commandWord = command.getCommandWord();
       
        
        switch  (commandWord) {
            case "hilfe": helfe();
                          break;
             case "Rüstung": Rüstung();
                          break;
              case "Leben": Leben();
                          break;
               case "Kraft": Kraft();
                          break;        
               case "Quit": Quit();
                          break;           
               case "getInhand": getInhand();  break;
               case "Inhand":Inhand();   break;
               case "hinlegen":legehin();
                            break;
               case "Items":Rucksack();
                            break;
            case "gehe":
                  String direction = command.getSecondWord();
                  if ("norden".equalsIgnoreCase(direction)) {
                      geheN(command);
                  }
                   if ("osten".equalsIgnoreCase(direction)) {
                      geheO(command);
                  }
                   if ("westen".equalsIgnoreCase(direction)) {
                      geheW(command);
                  }
                   if ("süden".equalsIgnoreCase(direction)) {
                      geheS(command);
                  }
                  break;
                   
           
            default:
                System.out.println(String.format("Unknown command {}", commandWord));
        }
        Check();
        return wantToQuit;
    }    
    public void Quit(){
    
        System.out.println("Okay, du hast das Spiel abgebrochen...Drücke eine beliebige Taste um das Spiel vollständig zu beenden. Bis zum nächsten Mal!");
        int z=console.nextInt();
       System.exit(1);
    
    
    
    }
    public void getInhand(){
        System.out.println("Du hast in der Hand ein "+Inhand.getInhand().getName() );
    
    
    }
     public void Inhand(){
         int Slot;
         System.out.println("Welchen Slot in die Hand?");
         Slot=console.nextInt();
         
         
         Inhand.setInhand(Mensch,Mensch.getInventar(Slot),Slot);
    
    
    }
    private void helfe(){
    System.out.println("Hier sind alle Kommandos:");
    System.out.println("Im Kampf: Angriff1, Angriff2, Rückzug");
    System.out.println("Sonst: gehe Norden, gehe Süden, gehe Westen, gehe Osten, Inhand, getInhand, Rucksack, Items, Leben, Kraft, Rüstung, hinlegen");
    
    
    
    }
    private void legehin(){
    
    System.out.println("Welchen Slot möchtest du leeren?");
    int slot=console.nextInt();
    map.set(Koordia,Koordib,Mensch.getInventar(slot));
    System.out.println("Du hast jetzt Platz in Slot "+slot);
    
    
    
    }
    private void Rucksack(){
        System.out.println("Welchen Slot möchtest du benutzen?");
        int slot=console.nextInt();
      
        Mensch.dropItems(slot);
    
    }
    private void nehme(int b,Gegenstand n){
   Mensch.nehme(b,n);}
    public void Leben(){
    
    System.out.println("Du hast noch "+Mensch.getLeben()+"Lebenspunkte.");
    
    }
     public void Rüstung(){
    
    System.out.println("Du hast noch "+Mensch.getRüstung()+"Rüstung.");
    
    }
     public void Kraft(){
    
    System.out.println("Du hast noch "+Mensch.getKraft()+"Kraft.");
    
    }
    private void Check(){
       if(map.aufhebbar(Koordia,Koordib)==true){
        
           System.out.println("Du kannst hier etwas aufheben");
           System.out.println("Möchtest du "+map.getName(Koordia,Koordib)+"aufheben ?");
            String Wahl=console.next();
            switch(Wahl){
                case "Ja":System.out.println("In welchen Slot?"); int D=console.nextInt();      
                nehme(D,map.mapget(Koordia,Koordib));
                map.set(Koordia,Koordib,Boden);
                break;
                case "Nein":System.out.println("Okay");
                break;
           
                
           
           
        }}
      else{System.out.println("Hier ist nichts zum Aufheben. ");}  
        if(map.Monster(Koordia,Koordib)==true){
            switch(map.mapget(Koordia,Koordib).getName()){
            case"Goblin":
        
            Kämpfen.boxen(Mensch,Goblin);
            map.set(Koordia,Koordib,Boden);break;
          case"Wolf":
        
        Kämpfen.boxen(Mensch,Wolf);
         map.set(Koordia,Koordib,Boden);break;
              case"Dämon":
        
        Kämpfen.boxen(Mensch,Dämon);
         map.set(Koordia,Koordib,Boden);break;
        } 
        
        
        
        
        
        
    }}
 

       private void geheN(Command command){
           if (map.mapget(Koordia-1, Koordib).getdurchgehbar()==true){
            Koordia=Koordia-1;
            System.out.println("Du bist bei "+Koordia+" " + Koordib);

        
            }
            else{System.out.println("Das geht hier leider nicht.");}
        
        
        }
        
        private void geheO(Command command){


                if (map.mapget(Koordia, Koordib+1).getdurchgehbar()==true){
          Koordib=Koordib+1;
            System.out.println("Du bist bei "+Koordia+" " + Koordib);

        
            }
            else{System.out.println("Das geht hier leider nicht.");}
        
    
            }  
        
            private void geheS(Command command){
                  if (map.mapget(Koordia+1, Koordib).getdurchgehbar()==true){
            Koordia=Koordia+1;
            System.out.println("Du bist bei "+Koordia+" " + Koordib);

        
            }
            else{System.out.println("Das geht hier leider nicht.");}
          

        
        
    
            }  
            private void geheW(Command command){

          
                if (map.mapget(Koordia, Koordib-1).getdurchgehbar()==true){
                    Koordib=Koordib-1;
            System.out.println("Du bist bei "+Koordia+" " + Koordib);

        
            }
            else{System.out.println("Das geht hier leider nicht.");}

        
        
    
            }  
        
        
        
        
        }
  
    

