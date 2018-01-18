/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula24_11_InterfaceGrafica;

import javax.swing.JOptionPane;
public class Principal {
    public static void main(String[] args) {
        
        //(frameRetorno,Mensagem,Título,tipoMsg)
        String nome = JOptionPane.showInputDialog(null,"Informe se  u nome","Digite aqui...",2);
        System.out.println("Nome: " + nome);
        
        Object[] opcoes = {"sim","nao"};
        Object resposta = JOptionPane.showInputDialog(null, "Deseja Finalizar o Programa", "Finalização", JOptionPane.PLAIN_MESSAGE, null, opcoes, "nao");
        
        /* CONVERSÕES
        -int idade = Integer.parseInt(string);
        -double valor = Double.parseDouble(string);
        -float valor2 = Float.parseDouoble(string) 
        */
        
    }
    
}
