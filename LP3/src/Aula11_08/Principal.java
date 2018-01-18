/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula11_08;

import java.sql.ResultSet;

/**
 *
 * @author Lucas Mudo
 */
public class Principal {
    public static void main(String[] args) {
        ConectaBanco cb = new ConectaBanco();
        
        //Inserir dados
        String nomeExemplo = "Jon Snow";
        int i =5;
        String ex = "insert into exemplo values("+i+", '"+nomeExemplo+"', 10)";
	//cb.executaSql(ex);
        
        //Busca de dados
        String comando = "select * from exemplo";//comando que sera exceutado no banco
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                //tipo nome = rs.getTipo("nomeColuna");
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                System.out.println(id+"   "+nome+"   "+idade);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //Update
        String codigo = "update exemplo set idade = 80 where nome like 'Ana'";
        cb.executaSql(codigo);
        
        
    }
}
