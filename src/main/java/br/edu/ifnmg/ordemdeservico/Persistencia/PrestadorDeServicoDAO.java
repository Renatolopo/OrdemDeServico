/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Persistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServico;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServicoRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class PrestadorDeServicoDAO extends DataAccessObject<PrestadorDeServico> implements PrestadorDeServicoRepositorio {
    public PrestadorDeServicoDAO(){
        super(PrestadorDeServico.class);
    }
    
    @Override
    public List<PrestadorDeServico> Buscar(PrestadorDeServico obj) {
        String jpql = "select p from PrestadorDeServico p";
        String filtros = "";
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
            if(obj.getNome().length() > 0){
                filtros += "p.nome like :nome";
                parametros.put("nome", obj.getNome()+"%");
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
