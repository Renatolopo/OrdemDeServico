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
@Table(name = "Endereco")
@DiscriminatorValue(value = "1")
public class Endereco1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String complemento;

    public Endereco1() {
        this.id = 0L;
        this.rua = "";
        this.bairro = "";
        this.numero = "";
        this.cidade = "";
        this.complemento = "";
    }

    public Endereco1(Long id, String rua, String bairro, String numero, String cidade, String complemento) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.complemento = complemento;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco1)) {
            return false;
        }
        Endereco1 other = (Endereco1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rua;
    }
    
}
