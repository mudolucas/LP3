/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProvaB1;

import ProvaConsulta2ºBi.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AcaoBotao implements ActionListener {
    String acao;
    JTextField t1,t2,t3,t4,t5,t6;
    ConectaBanco cb = new ConectaBanco();
        
    public AcaoBotao(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, String acao){
        this.acao = acao;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
    }
    
    AcaoBotao(JTextField t1, String acao) {
        this.acao = acao;
        this.t1 = t1;
    }
    
    public AcaoBotao(JTextField t1, JTextField t2,  String acao){
        this.acao = acao;
        this.t1 = t1;
        this.t2 = t2;
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (acao.equals("CADASTRAR")){
            String nome = t1.getText();
            int mes = Integer.parseInt(t2.getText());
            float ali = Float.parseFloat(t3.getText());
            float trans = Float.parseFloat(t4.getText());
            float lazer = Float.parseFloat(t5.getText());
            float mora = Float.parseFloat(t6.getText());
            if (ali > 800.0 || trans > 600.0 || lazer > 300.0 || mora > 600.0){
                JOptionPane.showMessageDialog(null,"Voce estourou as contas esse mes, tome cuidado", "Alerta", 0);
            }
            String sql = "insert into pessoa(nome,mes,alimentacao,transporte,lazer,moradia) values('"+nome+"',"+mes+","+ali+","+trans+","+lazer+","+mora+")";
            cb.executaSql(sql);
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso", "Cadastro", 3);
            
        }
        else if (acao.equals("MAIOR")){
            String meses[] = {"","Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
            String sql = "select mes from pessoa where alimentacao+transporte+lazer+moradia = any (select max(alimentacao+transporte+lazer+moradia) from pessoa where nome='Joao');";
            ResultSet rs = cb.buscaDados(sql);
            try{
                while(rs.next()){
                    int mes = rs.getInt(1);
                    JOptionPane.showMessageDialog(null,"O maior gasto foi em: "+meses[mes], "Maior gasto", 3);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if (acao.equals("BUSCAR")){
            String meses[] = {"","Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
            String nome = t1.getText();
            String sql = "select * from pessoa where nome='"+nome+"'";
            ResultSet rs = cb.buscaDados(sql);
            try{
                while(rs.next()){
                    int mes = rs.getInt(3);
                    float ali = rs.getFloat(4);
                    float trans = rs.getFloat(5);
                    float lazer = rs.getFloat(6);
                    float moradia = rs.getFloat(7);
                    JOptionPane.showMessageDialog(null,"Alimentação: "+ali +"\nTransporte: "+trans+"\nLazer: "+lazer+"\nMoradia: "+moradia+"", meses[mes], 3);
                    
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
}
