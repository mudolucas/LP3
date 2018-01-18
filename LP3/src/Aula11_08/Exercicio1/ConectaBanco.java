/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula11_08.Exercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectaBanco {
    private String url, usuario, senha;
    private Connection con;

    public ConectaBanco(){
        url = "jdbc:postgresql://localhost:5432/ExercicioAula11_08";
        usuario = "postgres";
        senha = "testebanco";
        try {	
                Class.forName("org.postgresql.Driver");//como se fosse um import
                con = DriverManager.getConnection(url, usuario, senha);	
                System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    public int executaSql(String sql){//
        int res = 0;
        try{//criar e executar um string no banco de dados
            Statement s = con.createStatement();
            res = s.executeUpdate(sql);// uso para rodar comandos no banco que nao necessitam de retorno			
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return res;
    }
    
    public ResultSet buscaDados(String sql){ 
	try{
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            return rs;
	}
	catch(Exception e){
            e.printStackTrace();
	return null;
	}
    }
    
    public void finalizarConexao(){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}