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

public class Principal {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Teste");
        frame.setLayout(new GridLayout(3,3));
        
        JLabel label1 = new JLabel("Valor 1: ");
        JLabel label2 = new JLabel("Valor 2: ");
        JTextField text = new JTextField();
        JTextField text1 = new JTextField();
        JButton b1 = new JButton("Somar");
        JButton b2 = new JButton("Sair");
        JButton b3 = new JButton("Subtrair");
        JButton b4 = new JButton("Multiplicar");
        JButton b5 = new JButton("Dividir");
        
        frame.add(label1);
        frame.add(text);
        frame.add(b2);
        frame.add(label2);
        frame.add(text1);
        frame.add(b1);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        
        b1.addActionListener( new AcaoBotao(text,text1,"SOMA"));
        b3.addActionListener( new AcaoBotao(text,text1,"SUBTRAIR"));
        b5.addActionListener( new AcaoBotao(text,text1,"DIVIDIR"));
        b4.addActionListener( new AcaoBotao(text,text1,"MULTIPLICAR"));
        b2.addActionListener(new AcaoBotao("SAIR"));
        //frame.setSize(400,400);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//tela centralizada
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
