/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseInterface_27_10;

import java.util.Scanner;

/**
 *
 * @author mudo
 */
public class Exemplo implements Cadastro, Endereco {
   String endereco;
   Scanner sc;
   
   public Exemplo(String n){
       sc = new Scanner(System.in);
       endereco = n;
   }
    
   @Override
   public void exibirEndereco(){
       System.out.println(endereco);
   }
   @Override
   public void atualizarEndereco(){
       System.out.println("Digite o novo endereco");
       String n = sc.nextLine();
       endereco = n;
   }
   @Override
   public void incluir(){
       System.out.println("Incluir");
   }
   @Override
   public void alterar(){
       System.out.println("Alterar");
   }
   @Override
   public void excluir(){
       System.out.println("Excluir");
   }
   
}
