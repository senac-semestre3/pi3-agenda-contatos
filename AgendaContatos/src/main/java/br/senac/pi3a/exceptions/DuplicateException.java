/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.exceptions;

/**
 *
 * @author Willian Vieira
 */
public class DuplicateException extends Exception{
    
    // exibe a mensagem de elementos duplicados
    public DuplicateException(String message) { super(message); }
}

