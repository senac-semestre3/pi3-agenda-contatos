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

/**
 *
 * @author everton
 */
public class ServiceContato {
    //Insere um cliente na fonte de dados
    public static void inserirContato(Contato contato)
            throws ContatoException, DataSourceException {
        //Validacoes Dados Pessoais
        if (contato == null) {
            throw new ContatoException("Não foi informado um cliente");
        }
        if (contato.getNome() == null || contato.getNome().equals("")) {
            throw new ContatoException("É necessário informar um nome para o contato");
        }
        if (contato.getTelefone() == null || contato.getTelefone().equals("")) {
            throw  new ContatoException("É necessário informar o telefone para o contato");
        }
        if (contato.getSexo() == 0) {
            throw  new ContatoException("É necessário informar o sexo do contato");
        }
        
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoContato daoContato = new DaoContato();
            daoContato.insereContato(contato);
        }catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
