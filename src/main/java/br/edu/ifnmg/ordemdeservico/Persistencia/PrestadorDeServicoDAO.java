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
        String jpql = "select o from PrestadorDeServico o";
        
        
        // Dicionario de parametros
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        // Verifico quais os valores que existem no obj
        if(obj != null){
            if(obj.getId() != null & obj.getId() != 0L){
                parametros.put("id", obj.getId());
            }
            
            if(obj.getNome().length() > 0){
                parametros.put("nome", obj.getNome());
            }
          
        }
        
        // crio a parte da jpql que existem no obj
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
            for(String campo : parametros.keySet()){
                sql.setParameter(campo, parametros.get(campo));
            }
        }
        return sql.getResultList();
        
        
    }
    
}
