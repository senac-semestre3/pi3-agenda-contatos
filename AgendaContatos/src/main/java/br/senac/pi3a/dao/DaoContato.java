/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.dao;

import static br.senac.pi3a.dao.DBConnector.getConexaoDB;
import br.senac.pi3a.model.Contato;
import java.sql.Connection;
import br.senac.pi3a.utils.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void insereContato(Contato contato) throws RuntimeException {
        String sql = "INSERT INTO contato ("
                + "nome, "
                + "data_nasc, "
                + "telefone, "
                + "email, "
                + "sexo,"
                + "favorito,"
                + "tipo_telefone)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

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
            stmt.setInt(7, contato.getTipoTelefone());
            //Executa SQL Statement
            stmt.execute();
            //Fecha
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Contato> listarTodos(String sql) throws
                     SQLException, Exception {
      List<Contato> contatos = new ArrayList<Contato>();

        Connection con = getConexaoDB();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet result =  stmt.executeQuery();
            
            while(result.next()){
                    Contato contato = new Contato();
                    contato.setIdContato(result.getInt("id_contato"));
                    contato.setNome(result.getString("nome"));
                    contato.setDataNascimento(result.getDate("data_nasc"));
                    contato.setEmail(result.getString("email"));
                    contato.setSexo(result.getString("sexo").charAt(0));
                    contato.setFavorito(result.getBoolean("favorito"));
                    contato.setTipoTelefone(result.getInt("tipo_telefone"));
                    
                    contatos.add(contato);
                    
            }
            result.close();
            stmt.close();
            
        } catch (Exception e) {
        }
        //Retorna a lista de clientes do banco de dados
        return contatos; 
    }

}
