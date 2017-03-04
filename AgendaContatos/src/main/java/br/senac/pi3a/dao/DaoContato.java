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

    //Insere o contato
    public void inserirContato(Contato contato) throws RuntimeException {
        String sql = "INSERT INTO contato ("
                + "nome, "
                + "sobrenome, "
                + "telefone, "
                + "tipo_telefone, "
                + "email, "
                + "sexo, "
                + "data_nasc, "
                + "favorito)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try ( // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Converte a data de nascimento do java para dataSql
            java.util.Date dataUtil = contato.getDataNascimento();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            //Seta valores para inserção
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getSobrenome());
            stmt.setString(3, contato.getTelefone());
            stmt.setInt(4, contato.getTipoTelefone());
            stmt.setString(5, contato.getEmail());
            stmt.setInt(6, contato.getSexo());
            stmt.setDate(7, dataSql);
            stmt.setBoolean(8, contato.getFavorito());

            //Executa SQL Statement
            stmt.execute();
            //Fecha

            FecharConexao();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FecharConexao();
        }

    }

    //Obtém uma instância da classe "Contato" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static Contato obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM contato WHERE (id = " + id + ")";

        Connection con = getConexaoDB();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os contatos 
            //encotrados na lista de contatos inicialmente declarada.
            while (result.next()) {
                Contato contato = new Contato();

                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setSobrenome(result.getString("sobrenome"));
                contato.setTelefone(result.getString("telefone"));
                contato.setTipoTelefone(result.getInt("tipo_telefone"));
                contato.setEmail(result.getString("email"));
                contato.setSexo(result.getInt("sexo"));
                contato.setDataNascimento(result.getDate("data_nasc"));
                contato.setFavorito(result.getBoolean("favorito"));

                return contato;

            }

            result.close();
            stmt.close();
            FecharConexao();

        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            FecharConexao();
        }
        return null;
    }

    //retorna uma lista de contatos
    public static List<Contato> listarTodos() throws
            SQLException, Exception {

        String sql = "SELECT * FROM contato";

        //Cria lista de contatos
        List<Contato> contatos = new ArrayList<>();
        //Abre conexão
        Connection con = getConexaoDB();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os contatos 
            //encotrados na lista de contatos inicialmente declarada.
            while (result.next()) {
                Contato contato = new Contato();
                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setSobrenome(result.getString("sobrenome"));
                contato.setTelefone(result.getString("telefone"));
                contato.setTipoTelefone(result.getInt("tipo_telefone"));
                contato.setEmail(result.getString("email"));
                contato.setSexo(result.getInt("sexo"));
                contato.setDataNascimento(result.getDate("data_nasc"));
                contato.setFavorito(result.getBoolean("favorito"));

                contatos.add(contato);

            }

            result.close();
            stmt.close();
            FecharConexao();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            FecharConexao();
        }

        //Retorna a lista de clientes do banco de dados
        return contatos;
    }

    // Retorna a lista buscada pelo nome
    public static List<Contato> listaPorNome(String nome) {
        List<Contato> contatos = new ArrayList<Contato>();

        Connection con = getConexaoDB();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato WHERE nome LIKE '%" + nome + "%'");
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Contato contato = new Contato();
                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setTelefone(result.getString("telefone"));
                contato.setTipoTelefone(result.getInt("tipo_telefone"));
                contato.setEmail(result.getString("email"));
                contato.setSexo(result.getInt("sexo"));
                contato.setDataNascimento(result.getDate("data_nasc"));
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

    // Retorna a busca pelo telefone
    public static List<Contato> listaPorTelefone(String telefone) {
        List<Contato> contatos = new ArrayList<>();
        Connection con = getConexaoDB();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato  WHERE telefone LIKE '%" + telefone + "%';");
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Contato contato = new Contato();
                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setTelefone(result.getString("telefone"));
                contato.setTipoTelefone(result.getInt("tipo_telefone"));
                contato.setEmail(result.getString("email"));
                contato.setSexo(result.getInt("sexo"));
                contato.setDataNascimento(result.getDate("data_nasc"));
                contato.setFavorito(result.getBoolean("favorito"));

                contatos.add(contato);

            }

            result.close();
            stmt.close();
            FecharConexao();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            FecharConexao();

        }
        return contatos;
    }

    // Deleta o contato
    public static void excluirContato(int id) {
        Connection con = DBConnector.getConexaoDB();

        try {
            PreparedStatement stmt = con.prepareStatement("DELETE from contato WHERE id =" + id + ";");// E aqui por contato.getIdContato()
            stmt.executeUpdate();
            stmt.close();
            FecharConexao();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            FecharConexao();
        }
    }

    //Edita contato
    public static void editarContato(Contato contato) {

        Connection con = DBConnector.getConexaoDB();

        String sql = "UPDATE contato SET "
                + "nome= ?,"
                + "sobrenome= ?,"
                + "telefone= ?,"
                + "tipo_telefone= ?, "
                + "email= ?, "
                + "sexo= ?, "
                + "data_nasc= ?,"
                + "favorito= ? "
                + "WHERE id = ?";

        try ( // prepared statement para inserção
                PreparedStatement stmt = con.prepareStatement(sql)) {

            //Converte a data de nascimento do java para dataSql
            java.util.Date dataUtil = contato.getDataNascimento();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            //Seta valores para inserção
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getSobrenome());
            stmt.setString(3, contato.getTelefone());
            stmt.setInt(4, contato.getTipoTelefone());
            stmt.setString(5, contato.getEmail());
            stmt.setInt(6, contato.getSexo());
            stmt.setDate(7, dataSql);
            stmt.setBoolean(8, contato.getFavorito());
            stmt.setInt(9, contato.getId());

            //Executa SQL Statement
            stmt.executeUpdate();
            //Fecha
            FecharConexao();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            FecharConexao();
        }
    }
}
