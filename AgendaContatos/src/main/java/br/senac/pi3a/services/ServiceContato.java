/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.services;

import br.senac.pi3a.dao.DaoContato;
import br.senac.pi3a.exceptions.ContatoException;
import br.senac.pi3a.exceptions.DataSourceException;
import br.senac.pi3a.model.Contato;
import java.util.List;

/**
 *
 * @author everton
 */
public class ServiceContato {
    //Insere um contato na fonte de dados
    public static void inserirContato(Contato contato)
            throws ContatoException, DataSourceException {
        //Validacoes Dados Pessoais
        if (contato == null) {
            throw new ContatoException("Não foi informado um contato");
        }
        if (contato.getNome() == null || contato.getNome().equals("")) {
            throw new ContatoException("É necessário informar um nome para o contato");
        }
        if (contato.getSobrenome() == null || contato.getSobrenome().equals("")) {
            throw new ContatoException("É necessário informar o sobrenome do contato");
        }
        if (contato.getTelefone() == null || contato.getTelefone().equals("")) {
            throw  new ContatoException("É necessário informar o telefone para o contato");
        }
        if (contato.getSexo() == 0) {
            throw  new ContatoException("É necessário informar o sexo do contato");
        }
        if (contato.getDataNascimento() == null || contato.getDataNascimento().equals("")) {
            throw  new ContatoException("É necessário informar a data de nascimento do contato");
        }
        
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoContato daoContato = new DaoContato();
            daoContato.inserirContato(contato);
        }catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    // Editar o contato
    public static void editarContato(Contato contato)
            throws ContatoException, DataSourceException {
        
        if (contato == null) {
            throw new ContatoException("Não foi informado um contato");
        }
        if (contato.getNome() == null || contato.getNome().equals("")) {
            throw new ContatoException("É necessário informar um nome para o contato");
        }
        if (contato.getSobrenome() == null || contato.getSobrenome().equals("")) {
            throw new ContatoException("É necessário informar o sobrenome do contato");
        }
        if (contato.getTelefone() == null || contato.getTelefone().equals("")) {
            throw  new ContatoException("É necessário informar o telefone para o contato");
        }
        if (contato.getSexo() == 0) {
            throw  new ContatoException("É necessário informar o sexo do contato");
        }
        if (contato.getDataNascimento() == null || contato.getDataNascimento().equals("")) {
            throw  new ContatoException("É necessário informar a data de nascimento do contato");
        }
        
        try {
            //Realiza a chamada de inserção na fonte de dados
            
            DaoContato.editarContato(contato);
            
        }catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Realiza a pesquisa de um contato por nome na fonte de dados
    public static List<Contato> procurarContatoNome(String str)
            throws ContatoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do banco.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            
            if (str == null || str.equals("")) {
                return DaoContato.listarTodos();
            }
            return DaoContato.listaPorNome(str);
            
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Realiza a pesquisa de um contato por telefone
    public static List<Contato> procurarContatoTelefone(String str)
            throws ContatoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do banco.
            //Caso contrário, realiza uma pesquisa com o parâmetro

            return DaoContato.listaPorTelefone(str);
            
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Para obter um contato
    public static Contato obterContato(int id)
        throws ContatoException, DataSourceException {
        
        try {
            return DaoContato.obter(id);
            
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Excluir contato
    public static void excluirContato(int id)
            throws ContatoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do cliente informado
            DaoContato.excluirContato(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    
}
