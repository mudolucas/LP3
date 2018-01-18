/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProvaConsulta2ºBi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AcaoBotao implements ActionListener {
    String acao;
    JTextField t1,t2,t3,t4;
    ConectaBanco cb = new ConectaBanco();
    
    public AcaoBotao(String acao){
        this.acao = acao;
    }
    
    public AcaoBotao(JTextField t1, JTextField t2, JTextField t3, String acao){
        this.acao = acao;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }
    
    public AcaoBotao(JTextField t1, JTextField t2,  String acao){
        this.acao = acao;
        this.t1 = t1;
        this.t2 = t2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (acao.equals("SAIR")){
            JOptionPane.showMessageDialog(null, "Volte sempre, meu xero <3");
            System.exit(0);
        }
        else{
            if (acao.equals("CADASTRAR")){
                String nome = t1.getText();
                float n1 = Float.parseFloat(t2.getText());
                float n2 = Float.parseFloat(t3.getText());
                float media = (n1+n2)/2;
                String sql = "insert into aluno(nome,media) values('"+nome+"',"+media+")";
                cb.executaSql(sql);
                JOptionPane.showMessageDialog(null,"Cadastrado com sucesso", "Cadastro", 3);
                //CADASTRAR
            }
            else if (acao.equals("BUSCAR")){
                float n1 = Float.parseFloat(t1.getText());
                float n2 = Float.parseFloat(t2.getText());
                float media = (n1+n2)/2;
                String sql = "select nome from aluno where media="+media;
                ResultSet rs = cb.buscaDados(sql);
                try{
                    while(rs.next()){
                        String nome = rs.getString(1);
                        JOptionPane.showMessageDialog(null,nome, "Alunos com media="+media, 3);
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            else if (acao.equals("ATUALIZAR")){
                float media=0;
                String nome = t1.getText();
                float rec = Float.parseFloat(t2.getText());
                String sql = "select media from aluno where nome='"+nome+"'";
                ResultSet rs = cb.buscaDados(sql);
                try{
                    while(rs.next()){
                        media = rs.getFloat(1);
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                if (rec>media){
                    sql="update aluno set media="+rec+" where nome='"+nome+"'";
                    cb.executaSql(sql);
                    JOptionPane.showMessageDialog(null,"Nota atualizada", "Atualização", 3);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Não atualizado: Nota da recuperação inferior a media", "Atualização", 0);
                }
            }
        } 
    }
    
}
