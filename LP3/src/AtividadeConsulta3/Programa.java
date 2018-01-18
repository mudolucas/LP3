/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadeConsulta3;

import ProvaConsulta2ºBi.ConectaBanco;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author mudo
 */
public class Programa {
    Scanner sc;
    ConectaBanco cb;
    
    public Programa(){
        sc = new Scanner (System.in);
        cb = new ConectaBanco();
    }
    
    public void cadastrarCompra(){
        System.out.println("------CADASTRO DE COMPRA------");
        imprimirProdutos();
        imprimirVendas();
        System.out.println("Digite o id de uma venda");
        int idv = sc.nextInt();
        System.out.println("Digite o id de dois produtos");
        int idp1 = sc.nextInt();
        int idp2 = sc.nextInt();
        String comando = "insert into produtovenda(idproduto, idvenda) values("+idp1+","+idv+");";
        cb.executaSql(comando);
        comando = "insert into produtovenda(idproduto, idvenda) values("+idp2+","+idv+");";
        cb.executaSql(comando);
        System.out.println("Cadastro Realizado com sucesso");
    }
    
    public void cadastrarLote(){
        System.out.println("-------CADASTRO DE LOTE-------");
        imprimirFabricante();
        System.out.println("Informe o id do fabricante a ser vinculado");
        int idf = sc.nextInt();
        System.out.println("Informe os dados do lote");
        System.out.print("Numero: ");int num = sc.nextInt();
        sc.reset();
        System.out.println("\nData de fabricacao(ano-mes-dia): "); String data = sc.next();
        String comando = "insert into lote(dataDeFabricacao, idfabricante, numero) values('"+data+"',"+idf+","+num+")";
        cb.executaSql(comando);
    }
    
    public void buscaVenda(){
        System.out.println("------BUSCA VENDA--------");
        System.out.println("Informe o id da venda");
        int idv = sc.nextInt();
        String comando = "select v.id, dia, hora, p.nome, l.id from venda v, produto p, lote l, produtovenda pv, loteproduto lp"
        + " where pv.idproduto = p.id and pv.idvenda = v.id and lp.idlote = l.id and lp.idproduto = p.id and v.id="+idv;
        ResultSet rs = cb.buscaDados(comando);
        try{
            while (rs.next()){
                int id = rs.getInt(1);
                String dia = rs.getString(2);
                String hora = rs.getString(3);
                String nome = rs.getString(4);
                int idl = rs.getInt(5);
                System.out.println("["+id+"] "+dia+" "+hora+" "+nome+" "+idl);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void imprimirProdutos(){
        int id; String nome;
        String comando = "select * from produto";
        ResultSet rs = cb.buscaDados(comando);
        System.out.println("------PRODUTOS");
        try{
            while(rs.next()){
               id = rs.getInt(1);
               nome = rs.getString(2);
                System.out.println("["+id+"]  "+nome);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void imprimirVendas(){
        int id; String dia, hora;
        String comando = "select * from venda";
        ResultSet rs = cb.buscaDados(comando);
        System.out.println("------Venda");
        try{
            while(rs.next()){
               id = rs.getInt(1);
               dia = rs.getString(2);
               hora = rs.getString(3);
                System.out.println("["+id+"]  "+dia+"  "+hora);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void imprimirFabricante(){
        int id; String nome;
        String comando = "select * from fabricante";
        ResultSet rs = cb.buscaDados(comando);
        System.out.println("------Fabricantes");
        try{
            while(rs.next()){
               id = rs.getInt(1);
               nome = rs.getString(2);
               System.out.println("["+id+"]  "+nome);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
}
