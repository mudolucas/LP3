/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProvaConsulta2ºBi;

import Aula30_11_InterfaceGrafica.AcaoBotaoLoja;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Principal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Loja");
        frame.setLayout(new GridLayout(6,2));
        
        
        JLabel label1 = new JLabel("Nome: ");
        JLabel label2 = new JLabel("Nota: ");
        JLabel label3 = new JLabel("Nota 2: ");
        JLabel label4 = new JLabel("Nota da Rec: ");
        JTextField name = new JTextField();
        JTextField nota1 = new JTextField();
        JTextField nota2 = new JTextField();
        JTextField rec = new JTextField();
        JButton b1 = new JButton("Cadastrar");
        JButton b2 = new JButton("Buscar");
        JButton b3 = new JButton("Atualizar Média");
        JButton b4 = new JButton("SAIR");
        
        frame.add(label1);
        frame.add(name);
        frame.add(label2);
        frame.add(nota1);
        frame.add(label3);
        frame.add(nota2);
        frame.add(label4);
        frame.add(rec);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        
        b1.addActionListener(new AcaoBotao(name, nota1,nota2,"CADASTRAR"));
        b2.addActionListener(new AcaoBotao(nota1,nota2,"BUSCAR"));
        b3.addActionListener(new AcaoBotao(name,rec,"ATUALIZAR"));
        b4.addActionListener(new AcaoBotao("SAIR"));
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//tela centralizada
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
