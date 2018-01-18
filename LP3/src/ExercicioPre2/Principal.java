/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicioPre2;

import java.util.Scanner;

/**
 *
 * @author Mudo
 */
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Programa p = new Programa();
        int op=0;
        
        do{
            System.out.println("Escolha uma opcao\n [1]Remocao \n[2]Insercao \n[3]Busca \n[4]Atualizacao \n[0]SAIR");
            op = sc.nextInt();
            if(op==1){
                p.remocaoDados();
            }
            else if(op==2){
                p.inserir();
            }
            else if(op==3){
                p.buscaDados();
            }
            else if(op==4){
                p.atualizaDados();
            }
            
        }while(op!=0);
        
    }
}
