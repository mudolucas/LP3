/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04_08;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


/**
 *
 * @author Lucas Mudo
 */
public class ConectaBanco {
    private String url, usuario, senha;
    private Connection con;

    public ConectaBanco(){
        url = "jdbc:postgresql://localhost:5432/LP3_04.08";
        usuario = "postgres";
        senha = "rancho1507";
        try {	
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, usuario, senha);	
                System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    public int executaSql(String sql){
        int res = 0;
        try{
                Statement s = con.createStatement();
                res = s.executeUpdate(sql);			
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return res;
    }
}	


