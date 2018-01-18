/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicioConsultas01_09;

import java.util.Scanner;

/**
 *
 * @author Mudo
 */
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Programa p = new Programa();
        int op = 0;
        do{
            System.out.println("----------------[MENU]---------------");
            System.out.println("[1]Busca1 \n[2]Busca2 \n[3]Busca3 \n[4]Busca4 \n[5]Busca5");
            System.out.println("Opcao:"); op = sc.nextInt();
            System.out.println("------------------------");
            if(op==1){
                p.busca1();
            }
            else if (op==2){
                p.busca2();
            }
            else if (op==3){
                p.busca3();
            }
            else if (op==4){
                p.busca4();
            }
            else if (op==5){
                p.busca5();
            }
            else if (op==0){
                System.out.println("Voce escolheu sair");
                p.sair();
            }
        }while(op!=0);
    }
}
