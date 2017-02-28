/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.dao;

import br.senac.pi3a.model.Contato;
import java.sql.Connection;
import br.senac.pi3a.utils.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.senac.pi3a.exceptions.DuplicateException;

/**
 *
 * @author Willian Vieira
 *
 */
public class DaoContato {

    static int id_contato;

    private final Connection connection;

    public DaoContato() {

        this.connection = new DBConnector().getConexaoDB();
    }

    //public void inserirContato(Contato contato)
    public void insereContato(Contato contato) throws DuplicateException {
        String sql = "INSERT INTO contato ("
                + "nome, "
                + "data_nasc, "
                + "telefone, "
                + "email, "
                + "sexo,"
                + "favorito)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        try {

            // prepared statement para inserção
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //Seta valores para inserção
            //Insere nome
            stmt.setString(1, contato.getNome());
           //Converte a data de nascimento do java para dataSql
            java.util.Date dataUtil = contato.getDataNascimento();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            //Insere na query o resultado da conversão 
            stmt.setDate(2, dataSql);
            //Insere na query o telefone
            stmt.setString(3, contato.getTelefone());
            //Insere na query o email
            stmt.setString(4, contato.getEmail());
            //Insere na query o sexo
            stmt.setString(5, Character.toString(contato.getSexo()));
            //Insere na query o favorito true ou false
            stmt.setBoolean(6, contato.getFavorito()); 
            //Executa SQL Statement
            stmt.execute();
            //Fecha
            stmt.close();

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new DuplicateException("CONTATO EXISTENTE!");
            }
            throw new RuntimeException(e);
        }

    }
}