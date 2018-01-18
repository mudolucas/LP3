/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio17_08;

import java.util.Scanner;

/**
 *
 * @author Lucas Mudo
 */
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Programa p = new Programa();
        int op = 0;
        
        do{
            System.out.println("-----   MENU   -----");
            System.out.println("[1]Cadastrar Aluno \n[2]Cadastrar categoria \n[3]Exibir dados inseridos");
            System.out.println("[4]Buscar cadastro \n[5]Buscar Categoria \n[6]Remover cadastro \n[7]Atualizar Cadastro \n[8]SAIR");
            op = sc.nextInt();
            
            if(op ==1){
                p.inserirDados();
            }
            else if(op == 2){
                p.inserirCategoria();
            }
            else if(op == 3){
                p.exibirDados();
            }
            else if (op == 4){
                p.buscarCadastro();
            }
            else if (op == 5){
                p.buscarCategoria();
            }
            else if (op == 6){
                p.removerCadastro();
            }
            else if (op == 7){
                p.atualizarCadastro();
            }
            else if (op == 8){
                p.sair();
            }
        }while(op != 8);
        System.out.println("Obrigado por estar conosco");
    }
}

