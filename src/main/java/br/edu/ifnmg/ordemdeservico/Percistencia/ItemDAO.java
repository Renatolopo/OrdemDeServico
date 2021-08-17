/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Percistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Item;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.ItemRepositorio;
import java.util.Hashtable;
import java.util.List;

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
        
        String filtros = "";
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
            if(obj.getNome().length() > 0){
                filtros += "i.nome like :nome";
                parametros.put("nome", obj.getNome()+"%");
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
