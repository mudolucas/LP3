/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula24_11_InterfaceGrafica;

import javax.swing.JOptionPane;
public class Exercicio1 {
    public static void main(String[] args) {
        String op1;
        Object operacoes[]={"Adicao","Subtracaco","Divisao","Multiplicacao"};        
        String opcoes[]={"Sim","Nao"};
        do{
            Object operacao = JOptionPane.showInputDialog(null,"Qual operacao deseja realizar?","Operacoes",3,null,operacoes,"Adicao");
            String valor1 = JOptionPane.showInputDialog(null,"Informe um valor","",-1);
            String valor2 = JOptionPane.showInputDialog(null,"Informe um valor","",-1);
            float n1 = Float.parseFloat(valor1);
            float n2 = Float.parseFloat(valor2);
            if (operacao == "Adicao"){
                JOptionPane.showMessageDialog(null, "A soma eh: "+(n1+n2), "Resultado", 1);
            }
            else if (operacao=="Subtracao"){
                JOptionPane.showMessageDialog(null, "A diferenca eh: "+(n1-n2), "Resultado", 1);
            }
            else if (operacao=="Divisao"){
                JOptionPane.showMessageDialog(null, "A divisao eh: "+(n1/n2), "Resultado", 1);
            }
            else if (operacao=="Multiplicacao"){
                JOptionPane.showMessageDialog(null, "O produto eh: "+(n1*n2), "Resultado", 1);
            }
            Object op = JOptionPane.showInputDialog(null,"Deseja continuar?","Encerrar",3,null,opcoes,"sim");
            op1 = op.toString();
            
        }while(op1!="Nao");
    }
}
