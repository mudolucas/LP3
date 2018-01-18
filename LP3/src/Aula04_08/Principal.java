/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04_08;

/**
 *
 * @author Lucas Mudo
 */
public class Principal {
    public static void main(String[] args) {
        
        Conta c = new Conta();
        
        c.setSaldo(100);
        
        if (c.realizarSaque(200)){ 
           System.out.println("Saque realizado!");
        }
        else{
            System.out.println("Saque não realizado!");   
        }
        
        System.out.println(c.getSaldo());
        
        c.realizarDivisao(100,2);
        //c.realizarDivisao(100,0);
        System.out.println(c.getSaldo());
        
        ConectaBanco cb = new ConectaBanco();
        String ex = "insert into exemplo values (1,'Ana',10)";//insere os dados no banco
        cb.executaSql(ex);
    }
}

