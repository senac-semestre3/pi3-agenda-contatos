/*Dados para cadastro
 * Nome
 * Data de nascimento
 * Telefone
 * E-mail
 */
package br.senac.pi3a.model;

import java.util.Date;

/**
 *
 * @author everton
 */
public class Contato {
    private String nome;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private char sexo;

    
    // geters e seters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
}
