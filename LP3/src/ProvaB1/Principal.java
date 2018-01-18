/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProvaB1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author mudo
 */
public class Principal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prova");
        frame.setLayout(new GridLayout(4,4));
        
        
        JLabel label1 = new JLabel("Nome: ");
        JLabel label2 = new JLabel("Mês: ");
        JLabel label3 = new JLabel("Alimentação: ");
        JLabel label4 = new JLabel("Transporte: ");
        JLabel label5 = new JLabel("Lazer: ");
        JLabel label6 = new JLabel("Moradia: ");
        JTextField name = new JTextField();
        JTextField mes = new JTextField();
        JTextField alimentacao = new JTextField();
        JTextField trans = new JTextField();
        JTextField lazer = new JTextField();
        JTextField moradia = new JTextField();
        JButton b1 = new JButton("Cadastrar");
        JButton b2 = new JButton("Maior Gasto");
        JButton b3 = new JButton("Buscar");
        JButton b4 = new JButton("Atualizar");
        
        
        frame.add(label1);
        frame.add(name);
        frame.add(label2);
        frame.add(mes);
        frame.add(label3);
        frame.add(alimentacao);
        frame.add(label4);
        frame.add(trans);
        frame.add(label5);
        frame.add(lazer);
        frame.add(label6);
        frame.add(moradia);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        
        b1.addActionListener(new AcaoBotao(name,mes,alimentacao,trans,lazer,moradia,"CADASTRAR"));
        b2.addActionListener(new AcaoBotao(name,"MAIOR"));
        b3.addActionListener(new AcaoBotao(name, "BUSCAR"));
        
        
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//tela centralizada
    }
}
