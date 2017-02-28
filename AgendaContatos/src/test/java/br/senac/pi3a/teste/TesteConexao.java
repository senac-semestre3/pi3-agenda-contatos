/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.teste;

import br.senac.pi3a.dao.DBConnector;
import br.senac.pi3a.dao.DaoContato;
import br.senac.pi3a.exceptions.DuplicateException;
import br.senac.pi3a.model.Contato;
import java.sql.Date;

/**
 *
 * @author Willian Vieira
 */
public class TesteConexao {

    public static void main(String[] args) throws DuplicateException {
        DBConnector conexao = new DBConnector();

        conexao.getConexaoDB();

        Contato c = new Contato();
        c.setNome("Teste");
        c.setEmail("email@email");
        c.setSexo('c');
        c.setDataNascimento(Date.valueOf("2017-01-01")); // insere data teste
        c.setFavorito(true);
        DaoContato daoc = new DaoContato();

        daoc.insereContato(c);

        System.out.println(conexao.statusConexao());

    }
}
