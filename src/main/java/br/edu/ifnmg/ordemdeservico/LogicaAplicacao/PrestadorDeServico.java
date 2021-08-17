/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author renato
 */
@Entity
public class PrestadorDeServico extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String areaDeAtuacao;
    private ArrayList<Servico> servicos;

    public PrestadorDeServico() {
        this.id = 0L;
        this.areaDeAtuacao = "";
        this.servicos = new ArrayList<>();
    }
    
    
    public PrestadorDeServico(String areaDeAtuacao, ArrayList<Servico> servicos, String nome, String email, String telefone, Documento DocumentoIdentificacao, PessoaTipo tipo) {
        super(nome, email, telefone, DocumentoIdentificacao, tipo);
        this.areaDeAtuacao = areaDeAtuacao;
        this.servicos = servicos;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
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
        if (!(object instanceof PrestadorDeServico)) {
            return false;
        }
        PrestadorDeServico other = (PrestadorDeServico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServico[ id=" + id + " ]";
    }
    
}
