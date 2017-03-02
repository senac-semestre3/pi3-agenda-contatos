package br.senac.pi3a.teste;

import br.senac.pi3a.dao.DBConnector;
import br.senac.pi3a.dao.DaoContato;
import br.senac.pi3a.model.Contato;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Willian Vieira
 */
public class TesteConexao {

    public static void main(String[] args) throws RuntimeException, Exception {
        DBConnector conexao = new DBConnector();

        conexao.getConexaoDB();
        conexao.statusConexao();
        
        /*
        Contato c = new Contato();
        c.setNome("Everton");
        c.setEmail("Everton@email");
        c.setSexo(2);
        c.setDataNascimento(Date.valueOf("1993-04-02")); // insere data teste
        c.setFavorito(true); 
        c.setTipoTelefone(2);
        c.setTelefone("11955586");
        DaoContato daoc = new DaoContato();

        daoc.insereContato(c);
        */
        

        System.out.println(conexao.statusConexao());

    }
}
