/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.dao;

import static br.senac.pi3a.dao.DBConnector.FecharConexao;
import static br.senac.pi3a.dao.DBConnector.getConexaoDB;
import br.senac.pi3a.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                + "tipo_telefone, "
                + "email, "
                + "sexo,"
                + "favorito,"
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
            //Insere na query o tipo de telefone
            stmt.setInt(4, contato.getTipoTelefone());
            //Insere na query o email
            stmt.setString(5, contato.getEmail());
            //Insere na query o sexo
            stmt.setInt(6, contato.getSexo());
            //Seta na query se é favorito ou não 
            stmt.setBoolean(7, contato.getFavorito());
            //Executa SQL Statement
            stmt.execute();
            //Fecha
            stmt.close();

            FecharConexao();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FecharConexao();
        }

    }

    //retorna uma lista de contatos
    public static List<Contato> listarTodos(String sql) throws
            SQLException, Exception {
        //Cria lista de contatos
        List<Contato> contatos = new ArrayList<Contato>();
        //Abre conexão
        Connection con = getConexaoDB();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os contatos encotrados na lista de contatos inicialmente declarada.
            while (result.next()) {
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
            FecharConexao();

        } catch (Exception e) {

        }
        //Retorna a lista de clientes do banco de dados
        return contatos;
    }

    public static List<Contato> listaPorId(int id_contato) {
        List<Contato> contatos = new ArrayList<Contato>();
        Connection con = getConexaoDB();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato WHERE id_contato = " + id_contato + ";");

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Contato contato = new Contato();
                contato.setIdContato(result.getInt("id_contato"));
                contato.setNome(result.getString("nome"));
                contato.setDataNascimento(result.getDate("data_nasc"));
                contato.setTelefone(result.getString("telefone"));
                contato.setTipoTelefone(result.getInt("tipo_telefone"));
                contato.setEmail(result.getString("email"));
                contato.setSexo(result.getString("sexo").charAt(0));
                contato.setFavorito(result.getBoolean("favorito"));

                contatos.add(contato);

            }
            result.close();
            stmt.close();
            FecharConexao();
        } catch (Exception e) {

        } finally {
            FecharConexao();
        }
        return contatos;
    }

    public static List<Contato> listaPorNome(String nome) {
        List<Contato> contatos = new ArrayList<Contato>();

        Connection con = getConexaoDB();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato WHERE nome LIKE '%" + nome + "%'");
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Contato contato = new Contato();
                contato.setIdContato(result.getInt("id_contato"));
                contato.setNome(result.getString("nome"));
                contato.setDataNascimento(result.getDate("data_nasc"));
                contato.setTelefone(result.getString("telefone"));
                contato.setTipoTelefone(result.getInt("tipo_telefone"));
                contato.setEmail(result.getString("email"));
                contato.setSexo(result.getString("sexo").charAt(0));
                contato.setFavorito(result.getBoolean("favorito"));

                contatos.add(contato);

            }

            result.close();
            stmt.close();
            FecharConexao();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            FecharConexao();
        }
        return contatos;
    }

    public static List<Contato> listaPorTelefone(int telefone) {
        List<Contato> contatos = new ArrayList<Contato>();
        Connection con = getConexaoDB();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato  WHERE telefone LIKE '%" + telefone + "%';");
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Contato contato = new Contato();
                contato.setIdContato(result.getInt("id_contato"));
                contato.setNome(result.getString("nome"));
                contato.setDataNascimento(result.getDate("data_nasc"));
                contato.setTelefone(result.getString("telefone"));
                contato.setTipoTelefone(result.getInt("tipo_telefone"));
                contato.setEmail(result.getString("email"));
                contato.setSexo(result.getString("sexo").charAt(0));
                contato.setFavorito(result.getBoolean("favorito"));

                contatos.add(contato);

            }

            result.close();
            stmt.close();
            FecharConexao();
        } catch (Exception e) {

        } finally {
            FecharConexao();

        }
        return contatos;

    }
}
