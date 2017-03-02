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

//        Contato c = new Contato();
//        c.setNome("Everton");
//        c.setEmail("Everton@email");
//        c.setSexo('m');
//        c.setDataNascimento(Date.valueOf("2017-01-01")); // insere data teste
//        c.setFavorito(true); 
//        c.setTipoTelefone(2);
//        c.setTelefone("11955586");
//        DaoContato daoc = new DaoContato();
//
//        daoc.insereContato(c);

        List<Contato> contatos = DaoContato.listaPorTelefone(888);

        

        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());

        }

//        System.out.println(conexao.statusConexao());

    }
}
