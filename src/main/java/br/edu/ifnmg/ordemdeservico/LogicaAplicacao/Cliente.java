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
@Table(name = "Cliente")
@DiscriminatorValue(value = "1")
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Endereco endereco;

    public Cliente() {
        super();
        this.endereco = new Endereco();
    }

    public Cliente(String nome, String email, String telefone, Documento DocumentoIdentificacao, PessoaTipo tipo, String numDocumento) {
        super(nome, email, telefone, DocumentoIdentificacao, tipo, numDocumento);
        this.endereco = new Endereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
