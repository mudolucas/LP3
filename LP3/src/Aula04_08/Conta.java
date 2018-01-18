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
public class Conta {
      private double saldo;
    
    public boolean realizarSaque(double valor){
        if (saldo >= valor){
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    public void realizarDivisao(int valor, int parcelas){
        try{//tenta executar
            System.out.println(valor/parcelas);
        }
        catch (Exception e){//Adiciona uma exceção na execução, ou seja, caso de erro, o codigo nao sera encerrado
            e.printStackTrace();
            e.toString();//Coloca numa String a mensagem de erro
            //System.out.println(e);
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
