import java.io.*;
import java.util.*;
import java.math.*;
import java.nio.*;
import java.nio.file.Files;




public class RPN {

  public static void main(String[] entradas) throws IOException {
        Stack<String> pilha = new Stack<String>();
    
        File texto = new File("Calc1.stk");
        byte[] dados = Files.readAllBytes(texto.toPath());
        String expr[] = new String(dados).split("\n");
        String resultado; 
     
        
        int aux = 0;
        
        do {
            if (expr[aux].equals("=")) {
                resultado = pilha.pop();
                System.out.println(resultado);
            }
            else{
    
                boolean numero = expr[aux].matches("[0-9]*");
               
                if(numero){
                    pilha.push(expr[aux]);
                }
                else {
                    BigDecimal segundo = new BigDecimal(pilha.pop());
                    BigDecimal primeiro = new BigDecimal(pilha.pop());
    
                    if (expr[aux].equals("+")) {
                        primeiro = primeiro.add(segundo);
                        pilha.push(primeiro.toString());
                    }
                    if (expr[aux].equals("-")){
                             primeiro = primeiro.subtract(segundo);
                        pilha.push(primeiro.toString());
                    }
                    if (expr[aux].equals("*")){
                             primeiro = primeiro.multiply(segundo);
                        pilha.push(primeiro.toString());
                                    }
                    if (expr[aux].equals("/")){
                             primeiro = primeiro.divide(segundo);
                        pilha.push(primeiro.toString());
                    }             
                } 
            }  
            aux ++;       
        } while(aux < expr.length);
    }
}