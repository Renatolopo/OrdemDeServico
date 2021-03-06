/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author renato
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "tipo")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length=250, nullable=false)
    private String nome;
    
    @Column(length=250)
    private String email;
    
    @Column(length=250)
    private String telefone;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Documento DocumentoIdentificacao;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private PessoaTipo tipo;
    
    private String numDocumento;

    public Pessoa() {
        this.id = 0L;
        this.nome = "";
        this.email = "";
        this.telefone = "";
        this.numDocumento = "";
        this.DocumentoIdentificacao = Documento.cpf;
        this.tipo = PessoaTipo.Cliente;
    }

    public Pessoa(String nome, String email, String telefone, Documento DocumentoIdentificacao, PessoaTipo tipo, String numDocumento) {
        this.id = 0L;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.DocumentoIdentificacao = DocumentoIdentificacao;
        this.numDocumento = numDocumento;
        this.tipo = tipo;
        
    }


    public Documento getDocumentoIdentificacao() {
        return DocumentoIdentificacao;
    }

    public void setDocumentoIdentificacao(Documento DocumentoIdentificacao) {
        this.DocumentoIdentificacao = DocumentoIdentificacao;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public PessoaTipo getTipo() {
        return tipo;
    }

    public void setTipo(PessoaTipo tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
