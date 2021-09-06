/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Persistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Cliente;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.ClienteRepositorio;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author renato
 */
public class ClienteDAO extends DataAccessObject<Cliente> implements ClienteRepositorio {

    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> Buscar(Cliente obj) {
        String jpql = "select c from Cliente c";
        
        String filtros = "";
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
            if(obj.getNome().length() > 0){
                filtros += "c.nome like :nome";
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
