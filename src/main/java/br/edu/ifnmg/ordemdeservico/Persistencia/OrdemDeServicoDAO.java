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
import javax.persistence.Query;

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
      
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
            if(obj.getMotivoDaChamada().length() > 0){
                parametros.put("motivoDaChamada", obj.getMotivoDaChamada()+"%");
            }
            
        }
        if(!parametros.isEmpty()){
            String filtros = "";
            jpql += " where ";
            for(String campo : parametros.keySet()){
                if(!filtros.isEmpty())
                    filtros += " and ";
                jpql += "o." + campo + "= :" + campo;
            }
            jpql += filtros;
        }
      
        Query sql = this.manager.createQuery(jpql);
        
        if(!parametros.isEmpty()){
            for(String campo: parametros.keySet()){
                sql.setParameter(campo, parametros.get(campo));
            }
        }
        return sql.getResultList();
    }
    
}
