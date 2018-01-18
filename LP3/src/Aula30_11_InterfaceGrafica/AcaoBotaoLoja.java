/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula30_11_InterfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class AcaoBotaoLoja implements ActionListener {
    String acao;
    JTextField t1,t2;
    public AcaoBotaoLoja(String acao){
        this.acao = acao;
    }
    
    public AcaoBotaoLoja(JTextField t1, JTextField t2, String acao){
        this.acao = acao;
        this.t1 = t1;
        this.t2 = t2;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if (acao.equals("SAIR")){
           JOptionPane.showMessageDialog(null, "VOLTE SEMPRE!");
           System.exit(0);
       }
       else{
           if(acao.equals("CADASTRAR PRODUTO")){
               String nome=null;
               ConectaBanco cb = new ConectaBanco();
               float v2 = Float.parseFloat(t2.getText());
               nome = t1.getText();
               if (nome.equals("")){
                       nome = JOptionPane.showInputDialog(null,"Digite o Nome do produto", "Nome", 0);
               }
               String slq = "insert into produto(valor,nome) values("+v2+",'"+nome+"')";
               cb.executaSql(slq);
               JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso", "Cadastro", 3);
           }
           if(acao.equals(null)){
               String vs = JOptionPane.showInputDialog(null,"Digite seu nome", "Nome", -1);
           }
       }
    }
    
    
    
}
