/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author renato
 */
@Entity
public class OrdemDeServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String motivoDaChamada;
    private FormaDePagamento formaDePagamento;
    private Date data;
    private Date fimDoAtendimento;
    private BigDecimal totalDoServico;
    private Cliente1 cliente;
    private ArrayList<Servico> servicos;

    public OrdemDeServico() {
        this.id = 0L;
        this.motivoDaChamada = "";
        this.formaDePagamento = FormaDePagamento.dinheiro;
        this.data = new Date();
        this.fimDoAtendimento = new Date();
        this.totalDoServico = new BigDecimal("0.00");
        this.cliente = new Cliente1();
        this.servicos = new ArrayList<>();
    }

    public OrdemDeServico(Long id, String motivoDaChamada, FormaDePagamento formaDePagamento, Date data, Date fimDoAtendimento, BigDecimal totalDoServico, Cliente1 cliente, ArrayList<Servico> servicos) {
        this.id = id;
        this.motivoDaChamada = motivoDaChamada;
        this.formaDePagamento = formaDePagamento;
        this.data = data;
        this.fimDoAtendimento = fimDoAtendimento;
        this.totalDoServico = totalDoServico;
        this.cliente = cliente;
        this.servicos = servicos;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivoDaChamada() {
        return motivoDaChamada;
    }

    public void setMotivoDaChamada(String motivoDaChamada) {
        this.motivoDaChamada = motivoDaChamada;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getFimDoAtendimento() {
        return fimDoAtendimento;
    }

    public void setFimDoAtendimento(Date fimDoAtendimento) {
        this.fimDoAtendimento = fimDoAtendimento;
    }

    public BigDecimal getTotalDoServico() {
        return totalDoServico;
    }

    public void setTotalDoServico(BigDecimal totalDoServico) {
        this.totalDoServico = totalDoServico;
    }

    public Cliente1 getCliente() {
        return cliente;
    }

    public void setCliente(Cliente1 cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof OrdemDeServico)) {
            return false;
        }
        OrdemDeServico other = (OrdemDeServico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return motivoDaChamada;
    }
    
}
