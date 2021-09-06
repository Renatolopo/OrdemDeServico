/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Persistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Item;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.ItemRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class ItemDAO extends DataAccessObject<Item> implements ItemRepositorio{
    public ItemDAO(){
        super(Item.class);
    }

    @Override
    public List<Item> Buscar(Item obj) {
        String jpql = "select i from Item i";
        
        // Dicionario de parametros
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        // Verifico quais os valores que existem no obj
        if(obj != null){
            if(obj.getId() != null & obj.getId() != 0L){
                parametros.put("id", obj.getId());
                
            }

            if(obj.getNome().length() > 0){
                parametros.put("nome", obj.getNome()+"%");
            }
          
        }
        
        // crio a parte da jpql que existem no obj
        if(!parametros.isEmpty()){
            String filtros = "";
            jpql += " where ";
            for(String campo : parametros.keySet()){
                if(!filtros.isEmpty())
                    filtros += " and ";
                jpql += " i." + campo + "= :" + campo;
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
