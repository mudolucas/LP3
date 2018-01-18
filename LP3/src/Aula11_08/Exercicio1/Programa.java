/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula11_08.Exercicio1;

import java.sql.ResultSet;
import java.util.Scanner;
/**
 *
 * @author Lucas Mudo
 */
public class Programa {
    static Scanner sc = new Scanner (System.in);
    static int cont;
    static ConectaBanco cb = new ConectaBanco();
    
    public Programa(){
        //ConectaBanco cb = new ConectaBanco();
        String comando = "select count(*) from pessoa";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while (rs.next()){
                cont = rs.getInt("count");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void inserirDados(){
        System.out.println("--- CADASTRO ---");
        System.out.println("Informe um nome, a idade e a quantidade de filhos ");
        String nome = sc.next();
        int idade = sc.nextInt();
        int qntdFilhos = sc.nextInt();
        String inserir = "insert into pessoa values("+cont+", '"+nome+"', "+idade+", "+qntdFilhos+")";
        cb.executaSql(inserir);
        System.out.println("Cadastro realizado com sucesso");
        cont++;
    }
    
    protected void exibirDados(){
        System.out.println("--- EXIBICAO DE DADOS ---");
        String comando = "select * from pessoa order by id";
        ResultSet rs = cb.buscaDados(comando);
        try{
            System.out.println("Id  Nome  Filhos");
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                int qnt = rs.getInt("numeroDeFilhos");
                System.out.println(id+"  "+nome+"  "+idade+"  "+qnt);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void buscarCadastro(){
        System.out.println("--- BUSCA DE CADASTRO ---");
        System.out.println("Informe o nome a ser buscado");
        String nome = sc.next();
        String comando = "select * from pessoa where nome like '"+nome+"'";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.println("Registros encontrados");
                int id = rs.getInt("id");
                String n = rs.getString("nome");
                int idade = rs.getInt("idade");
                int qnt = rs.getInt("numeroDeFilhos");
                System.out.println(id+"  "+nome+"  "+idade+"  "+qnt);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void removerCadastro(){
        System.out.println("--- REMOVER CADASTRO---");
        System.out.println("Informe o nome do cadastro a ser removido");
        String nome = sc.next();
        String comando = "delete from pessoa where nome like '"+nome+"'";
        cb.executaSql(comando);
        System.out.println("Cadastro excluido com sucesso");
    }
    
    protected void atualizarCadastro(){
        String comando, atualizar = "";
        int num=0;
        System.out.println("--- ATUALIZAR CADASTRO ---");
        System.out.println("Informe o nome do cadastro a ser atualizado");
        String nome = sc.next();
        System.out.println("Qual campo deseja atualizar \n[1]Nome \n[2]Idade \n[3]Num de Filhos");
        int op = sc.nextInt();
        System.out.println("Digite o novo valor");
        if (op == 1){
            atualizar = sc.next();
        }
        else{
            num = sc.nextInt();
        }
        if (op == 1){
            comando = "update pessoa set nome='"+atualizar+"' where nome='"+nome+"'";
        }
        else if (op == 2){
            comando = "update pessoa set idade='"+num+"' where nome='"+nome+"'";
        }
        else{
            comando = "update pessoa set numeroDeFilhos='"+num+"' where nome='"+nome+"'";
        }
        cb.executaSql(comando);
        System.out.println("Caddastro atualizado com sucesso");
    }
    
    protected void sair(){
        System.out.println("ATE BREVE");
        cb.finalizarConexao();
    }
    
    
}
