import java.io.*;
import java.util.*;
import java.math.*;
import java.nio.*;
import java.nio.file.Files;

public class RPN {

  public static void main(String[] entradas) throws IOException {
    
        Stack<Interger> pilha = new Stack<Interger>();
        List<Token> tk = new ArrayList<Token>();

        File texto = new File("Calc1.stk");
        Scanner expr = new Scanner(texto);
        int resultado, segundo, primeiro;
      
        do {

            String word = expr.nextLine();

            if (word.equals("=")) {
                resultado = pilha.pop();
                System.out.println(resultado);
            }
            else{
    
                boolean numero = word.matches("[0-9]*");
               
                if(numero){
                    pilha.push(word);
                }
                else {
                    segundo = (pilha.pop());
                    primeiro = (pilha.pop());
    
                    if (word.equals("+")) {
                        tk.add(new Token(TokenType.PLUS,word));
                        primeiro = primeiro.add(segundo);
                        pilha.push(primeiro);
                    }
                    if (word.equals("-")){
                        tk.add(new Token(TokenType.MINUS,word));
                        primeiro = primeiro.subtract(segundo);
                        pilha.push(primeiro);
                    }
                    if (word.equals("*")){
                        tk.add(new Token(TokenType.STAR,word));
                        primeiro = primeiro.multiply(segundo);
                        pilha.push(primeiro);
                                    }
                    if (word.equals("/")){
                        tk.add(new Token(TokenType.SLASH,word));
                        primeiro = primeiro.divide(segundo);
                        pilha.push(primeiro);
                    } 
                    else {
                        throw new IOException("Unexpected character: " + word);
                    }            
                } 
            }  
        } while(word.hasNext());
    }
}