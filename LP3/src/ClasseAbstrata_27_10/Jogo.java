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
public class Jogo extends Modelo{
    
    public Jogo(int i){
        super (i);
    }
    
    @Override
    public void carregarModelo(){
        System.out.println("Carregando modelo jogo");
    }
    @Override
    public void processarDados(){
        System.out.println("Processando dados jogo");
    }
    
    public void imprimir(){
        System.out.println(id);
    }
    
}
