/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseAbstrata_27_10;

/**
 *
 * @author mudo
 */
public class Principal {
    public static void main(String[] args) {
        Jogo j = new Jogo(10);
        
        j.imprimir();
        j.carregarModelo();
        j.processarDados();
        j.executar();
    }
}
