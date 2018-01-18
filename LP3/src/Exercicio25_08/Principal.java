/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio25_08;


import java.util.Scanner;


/**
 *
 * @author Lucas Mudo
 */
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Programa p = new Programa();
        int op = 0;
        do{
            System.out.println("-----   MENU    -----");
            System.out.println("[1]Cadastrar Paciente \n[2]Cadastrar Medico \n[3]Cadastrar Consulta \n[4]Exibir consultas cadastradas;"
            + " \n[5]Buscar Cadastro \n[6]Buscar Especialidade \n[7]Remover cadastro \n[8]Atualizar Cadastro \n[0]SAIR");
            op = sc.nextInt();
            if (op==1){
                p.cadastrarPaciente();
            }
            else if(op==2){
                p.cadastrarMedicos();
            }
            else if(op==3){
                p.cadastrarConsulta();
            }
            else if(op==4){
                p.exibirConsultasCadastradas();
            }
            else if(op==5){
                p.buscarCadastro();
            }
            else if(op==6){
                p.buscarEspecialidade();
            }
            else if (op == 7){
                p.removerCadastro();
            }
            else if (op == 8){
                p.atualizarCadastroMedico();
            }
            
        }while(op != 0);
    }
}

