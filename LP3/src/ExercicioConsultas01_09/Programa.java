/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicioConsultas01_09;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Mudo
 */
public class Programa {
    static Scanner sc = new Scanner (System.in);
    ConectaBanco cb;
    
    public Programa(){
        cb = new ConectaBanco();
    }
    
    //Apresente o nome de todos os ciclistas cadastrados,
    //o modelo de todas as bicicletas que eles possuem e o nome dos acessórios de cada bicicleta.
    protected void busca1 (){
        String comando = "select c.nome as ciclista, modelo, a.nome as acessorio from ciclista c, acessorio a, bicicleta b,  bicicletaacessorio ba, bicicletaciclista bc where c.id = bc.idciclista and b.id = bc.idbicicleta\n" +
        "and b.id = ba.idbicicleta and a.id = ba.idacessorio;";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                String ciclista = rs.getString("ciclista");
                String bike = rs.getString("modelo");
                String acessorio = rs.getString("acessorio");
                System.out.println(ciclista+"\t"+bike+"\t"+acessorio);
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
    }
    
    //Apresente o nome de todos os ciclistas que possuem alguma bicicleta
    //que custa mais de R$ 500,00 e que contém algum acessório com nome 'Luva em gel'.
    protected void busca2(){
        String comando = "select c.nome from ciclista c, bicicleta b, acessorio a, "+
        "bicicletaacessorio ba, bicicletaciclista bc where c.id = bc.idciclista and b.id = bc.idbicicleta "+
        "and b.id = ba.idbicicleta and a.id = ba.idacessorio and b.valor > 0.500 and a.nome = 'Luva com gel'";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.println(rs.getString("nome"));
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
    }
    
    /*Apresente o nome de todos os ciclistas e o roteiro dos treinos que eles realizam.
    Os dados deverão ser apresentados apenas para ciclistas que possuem alguma biciclet
    a do modelo 'Pivot Vault Ciclocross*/
    protected void busca3(){
        String comando = "select c.nome, t.roteiro from ciclista c, treino t, bicicleta b, bicicletaciclista bc,"
        + " treinociclista tc where c.id = bc.idciclista and b.id = bc.idbicicleta and " +
        "c.id = tc.idciclista and t.id = tc.idtreino and b.modelo = 'Pivot Vault Ciclocross'";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(2));
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
    }
    
    //Apresente o modelo de todas as bicicletas que custas mais de R$ 1.000,00. 
    //A bicicleta também deve possuir algum acessório chamado 'Sapatilha'.
    protected void busca4(){
        String comando = "select b.modelo from bicicleta b, bicicletaacessorio ba,"
        + " acessorio a where b.id=ba.idbicicleta and a.id=ba.idacessorio and b.valor>1.000 and a.nome = 'Sapatilha'";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.println(rs.getString("modelo"));
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
    }
    
    protected void busca5(){
        String comando = "select c.nome, b.modelo from ciclista c, bicicleta b, bicicletaciclista bc,"+
        "treino t, treinociclista tc, grupodeciclistas gc where c.id = bc.idciclista and b.id = bc.idbicicleta and "+
        "c.id = tc.idciclista and t.id = tc.idtreino and c.idgrupo = gc.id and t.roteiro = 'Treino noturno na avenida X'"
        + " and gc.nome='Feras do pedal' and b.valor>15.000";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(2));
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
    }
    
    protected void sair(){
        cb.finalizarConexao();
    }
}
