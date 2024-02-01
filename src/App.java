import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 1. compiling 
// javac --source-path src -d bin src/*  
// 2. run
// java -cp bin App
// 3. packaging to jar
//jar -c -v -f day01.jar -e App . (in bin folder) 
//4. run the jar package
//java -cp day01.jar App


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        List<String> cartItem = new ArrayList<>();

        Console cons = System.console();
        
        String input = "";
        
        while(!input.equals("quit")){
            input = cons.readLine(">");
            input = input.toLowerCase();

            if(input.equals("list")){
                
                if(cartItem.size()>0){
                    for(int i = 0; i < cartItem.size(); i++){
                        //System.out.println((i+1) + " : " + cartItem.get(i));
                        System.out.printf("%d. %s\n", (i+1), cartItem.get(i));
                    }
                } else{
                    System.out.println("Your cart is empty.");
                }
            }

            if(input.startsWith("add")){
                input = input.replace(',',' '); //replace , to space

                Scanner scan = new Scanner(input.substring(4));
                String stringVal = "";
                while (scan.hasNext()){
                    stringVal = scan.next();
                    cartItem.add(stringVal);
                }
            }

            if(input.startsWith("delete")){
                Scanner scan = new Scanner(input.substring(6));
                String stringVal ="";

                while(scan.hasNext()){
                    stringVal = scan.next();
                    
                    int cartPosition = Integer.parseInt(stringVal);
                    cartPosition = cartPosition -1; 

                    if(cartPosition < cartItem.size()){
                        String removedItem = cartItem.remove(cartPosition);
                        System.out.println(removedItem + " removed from cart.");                    
                    }else{
                        System.out.println("Incorrect item index");
                    }
                
                }
            }

        }

        System.out.println("Bye! See you again...");

    }
}
