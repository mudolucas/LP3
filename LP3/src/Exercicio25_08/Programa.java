/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio25_08;


import Exercicio25_08.ConectaBanco;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Lucas Mudo
 */
public class Programa {
    Scanner sc;
    ConectaBanco cb;
    
    public Programa(){
        cb = new ConectaBanco();
        sc = new Scanner (System.in);
    }
    
    
    protected void cadastrarPaciente(){
        System.out.println("--- CADASTRO ---");
        System.out.println("Informe o nome e a idade do paciente ");
        System.out.print("Nome: ");String nome = sc.next();
        System.out.print("Idade: ");int idade = sc.nextInt();
        String inserir = "insert into paciente(nomepaciente,idade) values('"+nome+"', "+idade+")";
        cb.executaSql(inserir);
        System.out.println("Cadastro realizado com sucesso");
    }
    
    protected void cadastrarMedicos(){
        System.out.println("--- CADASTRO DE MEDICOS ---");
        System.out.println("Informe o nome e a especialidade do medico ");
        System.out.print("Nome: ");String nome = sc.next();
        System.out.print("Especialidade: ");String especialidade = sc.next();
        String inserir = "insert into medico(nome,especialidade) values('"+nome+"', '"+especialidade+"')";
        cb.executaSql(inserir);
        System.out.println("Cadastro realizado com sucesso");
    }
    
    protected void cadastrarConsulta(){
        System.out.println("--- CADASTRO DE CONSULTA ---");
        exibirMedicos();
        exibirPacientes();
        System.out.println("Informe o id do medico e o id do paciente ");
        System.out.print("Id Medico: "); int idm = sc.nextInt();
        System.out.print("Id Paciente: "); int idp = sc.nextInt();
        String inserir = "insert into consulta(idmedico, idpaciente) values("+idm+", "+idp+")";
        cb.executaSql(inserir);
        System.out.println("Cadastro realizado com sucesso");
    }
    
    protected void exibirPacientes(){// exibir o nome e o id de cada paciente cadastrado
        System.out.println("--- PACIENTES CADASTRADOS  ----");
        String comando = "select * from paciente order by id";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nomepaciente");
                System.out.println("["+id+"] "+nome);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    protected void exibirMedicos(){//exibi nome e id dos medicos cadastrados
        System.out.println("--- MEDICOS CADASTRADOS  ----");
        String comando = "select * from medico order by id";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                System.out.println("["+id+"] "+nome);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    protected void exibirConsultasCadastradas(){
        System.out.println("--- CONSULTAS CADASTRADAS  ----");
        String comando = "select nomepaciente, nome from medico m , paciente p , consulta c where p.id = c.idpaciente and m.id = c.idmedico";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.print("Paciente: "+rs.getString("nomepaciente"));
                System.out.println("|| \tMedico: "+ rs.getString("nome"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    protected void buscarCadastro(){
        System.out.println("--- BUSCAR CADASTRO ---");
        System.out.println("Digite o nome do paciente");
        System.out.print("Nome: "); String nome = sc.next();
        System.out.println("Especialidade dos medicos que ele ja se consultou:");
        String comando = "select especialidade from medico m, paciente p, consulta c where m.id = c.idmedico and p.id = c.idpaciente and p.nomepaciente='"+nome+"'";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.println(rs.getString("especialidade"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void buscarEspecialidade(){
        System.out.println("----  BUSCAR ESPECIALIDADE ----");
        System.out.println("Digite a especialidade");
        String especialidade = sc.next();
        String comando = "select nome from medico where especialidade='"+especialidade+"';";
        ResultSet rs = cb.buscaDados(comando);
        try{
            while(rs.next()){
                System.out.println(rs.getString("nome"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void removerCadastro(){
        System.out.println("--- REMOVER PACIENTE ---");
        exibirPacientes();
        System.out.println("Digite o id do paciente que vai ser removido");
        int id = sc.nextInt();
        String comando = "delete from consulta where idpaciente="+id;
        cb.executaSql(comando);
        comando = "delete from paciente where id="+id;
        cb.executaSql(comando);
        System.out.println("Paciente excluido com sucesso");
    }
    
    protected void atualizarCadastroMedico(){
        String comando = "";
        System.out.println("--- ATUALIZAR CADASTRO MEDICO ----");
        exibirMedicos();
        System.out.println("Digite o id do medico que deseja atualizar");
        System.out.print("ID: ");int id = sc.nextInt();
        System.out.println("Qual campo deseja atualizar: \n[1]Nome \n[2]Especialidade");
        int op = sc.nextInt();
        System.out.println("Digite o novo valor para o campo");
        System.out.print("Novo valor: ");String atualiza = sc.next();
        if (op == 1){
            comando = "update medico set nome='"+atualiza+"' where id="+id;
        }
        else{
            comando = "update medico set especialidade='"+atualiza+"' where id="+id;
        }
        cb.executaSql(comando);
    }
    
    protected void sair(){
        cb.finalizarConexao();
    }
}
