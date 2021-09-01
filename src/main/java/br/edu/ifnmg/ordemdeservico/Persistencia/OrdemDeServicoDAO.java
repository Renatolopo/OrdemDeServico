/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Persistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.OrdemDeServico;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.OrdemDeServicoRepositorio;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author renato
 */
public class OrdemDeServicoDAO extends DataAccessObject<OrdemDeServico> implements OrdemDeServicoRepositorio {
    public OrdemDeServicoDAO(){
        super(OrdemDeServico.class);
    }

    @Override
    public List<OrdemDeServico> Buscar(OrdemDeServico obj) {
        String jpql = "select o from OrdemDeServico o";
        
        String filtros = "";
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
            if(obj.getMotivoDaChamada().length() > 0){
                filtros += "o.motivoDaChamada like :motivoDaChamada";
                parametros.put("motivoDaChamada", obj.getMotivoDaChamada()+"%");
            }
            
        }
         
        if(filtros.length() > 0)
            jpql = jpql + " were " + filtros;
        
        var query = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet()){
            query.setParameter(chave, parametros.get(chave));
        }
        return query.getResultList();
    }
    
}
