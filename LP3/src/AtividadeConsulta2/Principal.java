/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadeConsulta2;

import java.util.Scanner;

/**
 *
 * @author mudo
 */
public class Principal {
       public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Programa p = new Programa();
        int op=0;
        
        do{
            System.out.println("Escolha uma opcao\n [1]Conta Shows \n[2]Cancelamento Shows \n[3]Busca Banda \n[0]SAIR");
            op = sc.nextInt();
            if(op==1){
                p.contaShows();
            }
            else if(op==2){
                p.cancelamentoShows();
            }
            else if(op==3){
                p.buscaBanda();
            }
            
        }while(op!=0);
        
    }
}
