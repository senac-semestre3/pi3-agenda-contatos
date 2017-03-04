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

    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private int tipoTelefone;
    private String email;
    private int sexo;
    private Date dataNascimento;
    private boolean favorito;
    

    public Contato() {
        this.favorito = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    
    
    
    
}
