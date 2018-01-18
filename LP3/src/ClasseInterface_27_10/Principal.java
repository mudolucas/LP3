/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseInterface_27_10;

/**
 *
 * @author mudo
 */
public class Principal {
    public static void main(String[] args) {
        Exemplo e = new Exemplo ("Rua x, 666");
        
        e.exibirEndereco();
        e.atualizarEndereco();
        e.alterar();
        e.excluir();
        e.incluir();
    }
}
