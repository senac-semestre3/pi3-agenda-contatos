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

    private int id_contato;
    private String nome;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private int sexo;
    private boolean favorito;
    private int tipoTelefone;

    public Contato() {
        this.favorito = false;
    }

    // geters e seters
    public int getIdContato() {
        return id_contato;
    }

    public void setIdContato(int id_contato) {
        this.id_contato = id_contato;
    }

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

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
