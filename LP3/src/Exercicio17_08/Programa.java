/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio17_08;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Programa {
    static Scanner sc = new Scanner (System.in);
    static ConectaBanco cb = new ConectaBanco();
    
    protected Programa(){
        int aux = 0;
        String comando = "select count(*) from categoria";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while (rs.next()){
                aux = rs.getInt("count");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if (aux == 0){
            System.out.println("Para prosseguir é necessário cadastrar pelo menos uma categoria. Por favor, insira o nome de uma");
            String nome = sc.next();
            comando = "insert into categoria(categoria) values('"+nome+"')";
            cb.executaSql(comando);
        }
    }
    
    protected void inserirDados(){
        System.out.println("--- CADASTRO ---");
        System.out.println("Informe um nome, o id da categoria, a altura e o peso do atleta ");
        System.out.print("Nome: "); String nome = sc.next();
        System.out.println("Categorias disponiveis");
        exibirCategorias();
        System.out.print("idCategoria: "); int idCategoria = sc.nextInt();
        System.out.print("Altura: "); float altura = sc.nextFloat();
        System.out.print("Peso: "); float peso = sc.nextFloat();
        String inserir = "insert into aluno(nome,idCategoria,peso,altura) values ('"+nome+"',"+idCategoria+","+peso+","+altura+");";
        cb.executaSql(inserir);
        System.out.println("Cadastro realizado com sucesso");
    }
    
    protected void inserirCategoria(){
        System.out.println("Informe o nome da categoria ser inserida");
        System.out.print("Nome: "); String nome = sc.next();
        String inserir = "insert into categoria(categoria) values("+nome+");";
        cb.executaSql(inserir);
    }
     
    protected void exibirDados(){
        System.out.println("---  EXIBIR DADOS  -----");
        String comando = "select * from aluno order by id";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idCategoria = rs.getInt("idCategoria");
                float altura = rs.getFloat("altura");
                float peso = rs.getFloat("peso");
                float imc = peso/(altura*altura);
                System.out.println(id+"  "+nome+"  "+idCategoria+"  "+altura+"  "+peso+"  "+imc);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void exibirCategorias(){
        System.out.println("---  EXIBIR CATEGORIAS  -----");
        ResultSet rs = cb.buscaDados("Select * from categoria");
        try{
            while(rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("categoria");
            System.out.println("["+id+"] "+nome);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void buscarCadastro(){
        System.out.println("--- BUSCA CADASTRO ---");
        System.out.println("Digite a altura e o peso");
        System.out.print("Altura: "); float altura = sc.nextFloat();
        System.out.print("Peso: "); float peso = sc.nextFloat();
        String comando = "select * from aluno where altura>"+altura+" and peso>"+peso;
        ResultSet rs = cb.buscaDados(comando);
        try{
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idCategoria = rs.getInt("idCategoria");
                altura = rs.getFloat("altura");
                peso = rs.getFloat("peso");
                float imc = peso/(altura*altura);
                System.out.println(id+"  "+nome+"  "+idCategoria+"  "+altura+"  "+peso+"  "+imc);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void buscarCategoria(){
        System.out.println("--- BUSCAR CATEGORIA  ---");
        System.out.println("Digite o ID da categoria desejada para a busca");
        exibirCategorias();
        System.out.print("idCategoria: "); int id = sc.nextInt();
        ResultSet rs = cb.buscaDados("select nome from aluno e where e.idCategoria =categoria.id and e.idCategoria="+id);
        try{
            System.out.println("Estudantes na categoria selecionada:");
            while(rs.next()){
                System.out.println(rs.getString("nome"));
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
        String comando = "delete from aluno where nome like '"+nome+"'";
        cb.executaSql(comando);
        System.out.println("Cadastro excluido com sucesso");
    }
    
    protected void atualizarCadastro(){
        String comando, atualizar = "";
        float num=0;
        System.out.println("--- ATUALIZAR CADASTRO ---");
        System.out.println("Informe o nome do cadastro a ser atualizado");
        String nome = sc.next();
        System.out.println("Qual campo deseja atualizar \n[1]Nome \n[2]Peso \n[3]Altura");
        int op = sc.nextInt();
        System.out.println("Digite o novo valor");
        if (op == 1){
            atualizar = sc.next();
        }
        else{
            num = sc.nextFloat();
        }
        if (op == 1){
            comando = "update aluno set nome='"+atualizar+"' where nome='"+nome+"'";
        }
        else if (op == 2){
            comando = "update aluno set peso='"+num+"' where nome='"+nome+"'";
        }
        else{
            comando = "update aluno set altura='"+num+"' where nome='"+nome+"'";
        }
        cb.executaSql(comando);
        System.out.println("Caddastro atualizado com sucesso");
    }
    
    protected void sair(){
        cb.finalizarConexao();
    }
}

