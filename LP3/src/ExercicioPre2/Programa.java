/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicioPre2;

import java.util.Scanner;
import java.sql.ResultSet;
/**
 *
 * @author mudo
 */
public class Programa {
    ConectaBanco cb;
    Scanner sc;
    static int cont;
    
    public Programa(){
        cb = new ConectaBanco();
        sc = new Scanner (System.in);
        String comando = "select count(*) from funcionario";
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
    protected void remocaoDados(){
        String n=null;
        int id=0;
        System.out.println("--------REMOCAO---------");
        System.out.println("Digite o nome do produto");
        System.out.print("Nome: "); String nome = sc.nextLine();
        String comando = "select nome, id from produto where nome='"+nome+"'";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                n = rs.getString("nome");
                id = rs.getInt("id");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if (n != null){
            comando = "delete from produtoloja where idproduto="+id;
            cb.executaSql(comando);
            comando = "delete from produto where id="+id;
            cb.executaSql(comando);
        }
        else{
            System.out.println("PRODUTO NAO ENCONTRADO");
        }
    }
    
    protected void inserir(){
        System.out.println("---------INSERIR-----------");
        System.out.println("Digite o nome de um fornecedor");
        String nomef = sc.nextLine();
        sc.reset();
        int idf = buscaFornecedorId(nomef);
        System.out.println("Informe o nome do produto");
        String nomep = sc.nextLine();
        cont++;
        String comando = "insert into produto(id,nome,idfornecedor) values ("+cont+",'"+nomep+"',"+idf+")";
        cb.executaSql(comando);
    }
    
    protected int buscaFornecedorId(String nome){
        int id = 0;
        String comando = "select id from fornecedor where nome='"+nome+"'";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                id = rs.getInt("id");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    
    protected void buscaDados(){
        int num = 0;
        System.out.println("--------BUSCA DADOS--------");
        System.out.println("Informe o valor do produto e o nome do fornecedor");
        System.out.print("Nome Fornecedor"); String nomef = sc.nextLine();
        System.out.print("Valor:");float valor = sc.nextFloat();
        System.out.println("");
        String comando="select count (produtoloja.id) from produtoloja, produto, fornecedor where idproduto in (select p.id from produto p where p.valor="+valor+") " +
        "and idproduto = produto.id and produto.idfornecedor in (select f.id from fornecedor f where f.nome='"+nomef+"') and produto.idfornecedor = fornecedor.id ";        
        ResultSet rs= cb.buscaDados(comando);
        try{
            while(rs.next()){
                num = rs.getInt("count");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Registros relacionados: "+num);
    }
    
    protected void atualizaDados(){
        System.out.println("--------ATUALIZACAO-------");
        System.out.println("Informe o nome e a idade do funcionario a ser atualizado");
        System.out.print("Nome: "); String nomef = sc.nextLine();
        System.out.print("Idade: "); int idf = sc.nextInt();
        System.out.println("\nInforme os novos dados");
        System.out.print("Novo nome: "); String n = sc.nextLine();
        System.out.print("Nova idade: "); int i = sc.nextInt();
        String comando = "update funcionario set nome='"+n+"' where nome='"+nomef+"'";
        cb.executaSql(comando);
        comando = "update funcionario set idade="+i+" where idade="+idf;
        cb.executaSql(comando);
    }
}

