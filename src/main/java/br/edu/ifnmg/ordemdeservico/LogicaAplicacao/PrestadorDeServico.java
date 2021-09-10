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
@Table(name = "PrestadorDeServico")
@DiscriminatorValue(value = "2")
public class PrestadorDeServico extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String areaDeAtuacao;

    public PrestadorDeServico() {
        super();
        this.areaDeAtuacao = "";
    }

    public PrestadorDeServico(String areaDeAtuacao, String nome, String email, String telefone, Documento DocumentoIdentificacao, PessoaTipo tipo, String numDocumento) {
        super(nome, email, telefone, DocumentoIdentificacao, tipo, numDocumento);
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }
    
    

    @Override
    public String toString() {
        return this.areaDeAtuacao;
    }
    
}
