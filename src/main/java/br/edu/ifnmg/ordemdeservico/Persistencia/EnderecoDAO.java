/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Persistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Endereco;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.EnderecoRepositorio;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author renato
 */
public class EnderecoDAO extends DataAccessObject<Endereco> implements EnderecoRepositorio{
    public EnderecoDAO(){
        super(Endereco.class);
    }
    

    @Override
    public List<Endereco> Buscar(Endereco obj) {
        String jpql = "select e from Endereco e";
        
        String filtros = "";
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
            if(obj.getCidade().length() > 0){
                filtros += "e.cidade like :cidade";
                parametros.put("cidade", obj.getCidade()+"%");
            }
            if(obj.getBairro()!= null){
                if(filtros.length() > 0)
                    filtros += " and ";
                filtros += "e.bairro = :bairro";
                parametros.put("bairro", obj.getBairro());
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
