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

public class AcaoBotao implements ActionListener {
    String acao;
    JTextField t1,t2;
    
    public AcaoBotao(String acao){
        this.acao = acao;
    }
    
    public AcaoBotao(JTextField t1, JTextField t2, String acao){
        this.acao = acao;
        this.t1 = t1;
        this.t2 = t2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (acao.equals("SAIR")){
            JOptionPane.showMessageDialog(null, "Volte sempre");
            System.exit(0);
        }
        else{
            float v1 = Float.parseFloat(t1.getText());
            float v2 = Float.parseFloat(t2.getText());
            if (acao.equals("SOMA")){
                JOptionPane.showMessageDialog(null, "Total: "+(v1+v2));
            }
            else if (acao.equals("SUBTRAIR")){
                JOptionPane.showMessageDialog(null, "Total: "+(v1-v2));
            }
            else if (acao.equals("DIVIDIR")){
                JOptionPane.showMessageDialog(null, "Total: "+(v1/v2));
            }
            else if (acao.equals("MULTIPLICAR")){
                JOptionPane.showMessageDialog(null, "Total: "+(v1*v2));
            }
        } 
    }
    
}
