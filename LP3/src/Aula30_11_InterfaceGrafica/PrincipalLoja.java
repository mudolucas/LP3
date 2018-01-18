/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula30_11_InterfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class PrincipalLoja {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Loja");
        frame.setLayout(new GridLayout(3,2));
        
        
        JLabel label1 = new JLabel("Nome: ");
        JLabel label2 = new JLabel("Valor: ");
        JTextField text = new JTextField();
        JTextField text1 = new JTextField();
        JButton b1 = new JButton("Enviar");
        JButton b2 = new JButton("Sair");
        
        frame.add(label1);
        frame.add(text);
        frame.add(label2);
        frame.add(text1);
        frame.add(b1);
        frame.add(b2);
        
        b1.addActionListener(new AcaoBotaoLoja(text, text1,"CADASTRAR PRODUTO"));
        b2.addActionListener(new AcaoBotaoLoja("SAIR"));
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//tela centralizada
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
