/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadeConsulta2;

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
        sc = new Scanner(System.in);
        cb = new ConectaBanco();
    }
    
    protected void contaShows(){
        int qntdShows=0, qntdArtis=0;
        System.out.println("------CONTA SHOWS--------");
        System.out.println("Informe o nome da banda");
        String nomeb = sc.nextLine();
        sc.reset();
        String comando="select count(*) from bandashow bs, banda b, shows s "//quantos shows
        + "where bs.idbanda = b.id and b.nome = '"+nomeb+"' and s.id = bs.idshow;";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                qntdShows = rs.getInt("count");
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        comando="select count(*) from banda b, artista a where a.idbanda = b.id and b.nome = '"+nomeb+"'";
        rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                qntdArtis = rs.getInt("count");
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        System.out.println("Shows realizados: "+qntdShows);
        System.out.println("Numero de integrantes: "+qntdArtis);
    }
    
    protected void cancelamentoShows(){
        System.out.println("--------------Cancelamento de Shows-------------");
        System.out.println("Digite o nome do show a ser cancelado");
        String nome = sc.nextLine();
        sc.reset();
        int ids = buscaShowId(nome);
        String comando = "delete from bandashow where idshow ="+ids;
        cb.executaSql(comando);
        comando = "delete from show where id="+ids;
        cb.executaSql(comando);
    }
    
    protected int buscaShowId(String nome){
        int id = 0;
        String comando = "select id from shows where nome='"+nome+"'";
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
    
    protected void buscaBanda(){
        System.out.println("---------BUSCA BANDA----------");
        System.out.println("Informe o nome de um curso");
        String nome = sc.nextLine();
        sc.reset();
        String comando="select b.nome from banda b, artista a, cursoartista ca, curso c "
        + "where c.id = ca.idcurso and a.id=ca.idartista and b.id = a.idbanda and c.nome='"+nome+"'";
        ResultSet rs = cb.buscaDados(comando);
        System.out.println("Bandas que possuem artistas que ja fizeram o curso");
        try{
            while(rs.next()){
                System.out.println(rs.getString("nome"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
