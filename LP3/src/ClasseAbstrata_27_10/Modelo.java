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
public abstract class Modelo {
    public Modelo(int i){
    this.id = i;
    }
    
    int id;
    public abstract void carregarModelo();
    public abstract void processarDados();
    
    public void executar(){
        System.out.println("Executando modelo...");
    }
}
