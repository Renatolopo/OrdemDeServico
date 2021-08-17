/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author renato
 */
@Entity
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descricao;
    private String diagnostico;
    private String resolucao;
    private ArrayList<Item> itens;
    private String status;
    private String observacao;
    private PrestadorDeServico prestadorDeServico;
    private ArrayList<OrdemDeServico> ordemDeServico;

    public Servico() {
        this.id = 0L;
        this.descricao = "";
        this.diagnostico = "";
        this.resolucao = "";
        this.itens = new ArrayList<>();
        this.status = "";
        this.observacao = "";
        this.prestadorDeServico = new PrestadorDeServico();
        this.ordemDeServico = new ArrayList<>();
    }

    public Servico(Long id, String descricao, String diagnostico, String resolucao, ArrayList<Item> itens, String status, String observacao, PrestadorDeServico prestadorDeServico, ArrayList<OrdemDeServico> ordemDeServico) {
        this.id = id;
        this.descricao = descricao;
        this.diagnostico = diagnostico;
        this.resolucao = resolucao;
        this.itens = itens;
        this.status = status;
        this.observacao = observacao;
        this.prestadorDeServico = prestadorDeServico;
        this.ordemDeServico = ordemDeServico;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public PrestadorDeServico getPrestadorDeServico() {
        return prestadorDeServico;
    }

    public void setPrestadorDeServico(PrestadorDeServico prestadorDeServico) {
        this.prestadorDeServico = prestadorDeServico;
    }

    public ArrayList<OrdemDeServico> getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(ArrayList<OrdemDeServico> ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
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
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
