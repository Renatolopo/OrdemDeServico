/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author renato
 */
@Entity
@Table(name = "Administradores")
@DiscriminatorValue(value = "1")
public class Administrador extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String usuario;
    
    private String senha;
    
         
    public Administrador(){
        super();
        this.usuario = "";
        this.senha = "";
    }

    public Administrador(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Administrador(String usuario, String senha, String nome, String email, String telefone, Documento DocumentoIdentificacao, PessoaTipo tipo) {
        super(nome, email, telefone, DocumentoIdentificacao, tipo);
        this.usuario = usuario;
        this.senha = senha;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return usuario;
    }
    
    
}
