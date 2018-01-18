/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadeConsulta3;

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
            System.out.println("Escolha uma opcao \n[1]Cadastrar Compra \n[2]Cadastra Lote \n[3]Busca Venda \n[0]SAIR");
            op = sc.nextInt();
            if(op==1){
               p.cadastrarCompra();
            }
            else if(op==2){
                p.cadastrarLote();
            }
            else if(op==3){
                p.buscaVenda();
            }
        }while(op!=0);
        
    }
}
