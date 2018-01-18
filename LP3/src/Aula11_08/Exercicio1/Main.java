/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula11_08.Exercicio1;

import java.util.Scanner;

/**
 *
 * @author Lucas Mudo
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Programa p = new Programa();
        int op = 0;
        do{
            System.out.println("-----   MENU    -----");
            System.out.println("[1]Inserir cadastro \n[2]Exibir cadastro \n[3]Buscar cadastro \n[4]Remover Cadastro"
            + " \n[5] Atualizar Cadastro \n[0]SAIR");
            op = sc.nextInt();
            if (op==1){
                p.inserirDados();
            }
            else if(op==2){
                p.exibirDados();
            }
            else if(op==3){
                p.buscarCadastro();
            }
            else if(op==4){
                p.removerCadastro();
            }
            else if(op==5){
                p.atualizarCadastro();
            }
            else if(op==6){
                p.sair();
            }
            
        }while(op != 0);
    }
}
