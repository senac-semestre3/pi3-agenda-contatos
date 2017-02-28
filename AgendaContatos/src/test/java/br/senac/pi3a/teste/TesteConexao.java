package br.senac.pi3a.teste;

import br.senac.pi3a.dao.DBConnector;
import br.senac.pi3a.dao.DaoContato;
import br.senac.pi3a.model.Contato;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willian Vieira
 */
public class TesteConexao {

    public static void main(String[] args) throws RuntimeException, Exception {
        DBConnector conexao = new DBConnector();

        conexao.getConexaoDB();

        Contato c = new Contato();
        c.setNome("Teste");
        c.setEmail("email@email");
        c.setSexo('c');
        c.setDataNascimento(Date.valueOf("2017-01-01")); // insere data teste
        c.setFavorito(true); 
        c.setTipoTelefone(2);
        DaoContato daoc = new DaoContato();

        daoc.insereContato(c);

        List<Contato> contatos = DaoContato.listarTodos("selec * from contato");

        

        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());

        }

        System.out.println(conexao.statusConexao());

    }
}
