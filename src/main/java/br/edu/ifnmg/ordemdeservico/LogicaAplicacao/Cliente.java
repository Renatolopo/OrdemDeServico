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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Endereco endereco;

    public Cliente() {
        super();
        this.id = 0L;
        this.endereco = new Endereco();
    }

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(String nome, String email, String telefone, Documento DocumentoIdentificacao, PessoaTipo tipo, String numDocumento) {
        super(nome, email, telefone, DocumentoIdentificacao, tipo, numDocumento);
        this.id = 0L;
        this.endereco = new Endereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
