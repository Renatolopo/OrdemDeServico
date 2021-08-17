/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Percistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Servico;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.ServicoRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class ServicoDAO extends DataAccessObject<Servico> implements ServicoRepositorio{

    public ServicoDAO(Class type) {
        super(type);
    }

    @Override
    public List<Servico> Buscar(Servico obj) {
        String jpql = "select s from Servico s";
        String filtros = "";
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
            if(obj.getDescricao().length() > 0){
                filtros += "s.descricao like :descricao";
                parametros.put("descricao", obj.getDescricao()+"%");
            }
          
        }
        
        if(filtros.length() > 0)
            jpql = jpql + " where " + filtros;
        
        Query consulta = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet()){
            consulta.setParameter(chave, parametros.get(chave));
        }
        return consulta.getResultList();
    }
    
}
