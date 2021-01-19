
package hangman;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author patok
 */
public class mainobesenec {

    public static String [] slova = {"AUTO","MOTORKA","PREMIER","SKOLA","PES","MACKA","KVIETOK","ANTARKTIDA","MIAMI","BRATISLAVA"};
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<String> arr = new ArrayList<>();
    
    public static void printBoard(ArrayList<String>arr, int zivot){
        for(String x: arr){
            System.out.print(x);
        }
        
        System.out.println(" " + zivot + "zostavajuce zivoty");
    
    }
    
    
    public static boolean checkWinner(ArrayList<String>arr, String slovo, int zivot){
    
        String winnerCheck = "";
        
        for(String x: arr){
            winnerCheck+=x;
        }
        
        if(winnerCheck.equals(slovo)){
            System.out.println("Vyhral si !!!");
            return false;
        }
        else if(zivot==0){
            System.out.println("Nezostal žiadny život...");
            System.out.println("GAME OVER !!");
            return false;
        }
        
    return true;
    }

    
   public static void main(String[] args){
   
       while(true){
       
           String slovo = "";
           arr.clear();
           
           int zivot = 8;
           
           System.out.println("Vitajte v hre Obesenec !!");
           System.out.println();
           System.out.println("Stiskni n pre začatie novej hry.");
           System.out.println("Stiskni q pre ukončenie hry.");
           String menu = scanner.nextLine();
           
           
           if(menu.equals("q")){
           
               System.out.println("Ukončovanie.....");
               break;
           }
           else if (menu.equals("n")){
           
               int index = random.nextInt(slova.length);
               slovo += slova[index];
               
               for(int i = 0; i<slovo.length(); i++){
               
                   arr.add("_");
                   
               }
               
               printBoard(arr, zivot);
               
               
               while(checkWinner(arr, slovo, zivot)){
               
                   System.out.println("Zadajte písmeno: (A-Z)");
                   
                   String answer = scanner.nextLine();
                   
                   if(!Pattern.matches("[A-Z]", answer)){
                        System.out.println("Iba veľké písmená");
                        continue;
                  
                        
               }
                   
                   
                   char pismeno = answer.charAt(0);
                   
                    if(arr.contains(answer)){
                   
                       System.out.println("Už zadané.");
                   }
                   else{
                       for(int i = 0; i<slovo.length(); i++){
                           if(slovo.charAt(i) == pismeno){
                           
                               arr.remove(i);
                               arr.add(i, answer);
                           }
                       }
                       
                       if(!arr.contains(answer)){
                       
                           zivot-=1;
                       }
                          
                   }
                   
                   printBoard(arr, zivot);
                   System.out.println();
                   
                   
               }
               
           
           }
           else{
           
               System.out.println("Neznámy príkaz");
               continue;
           
           }
       
       }
   }
    
    
    
}
