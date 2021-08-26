/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Percistencia;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Administrador;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.AdministradorRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class AdministradorDAO extends DataAccessObject<Administrador> implements AdministradorRepositorio{
    public AdministradorDAO(){
        super(Administrador.class);
    }

    @Override
    public List<Administrador> Buscar(Administrador obj) {
        String jpql = "select a from Administrador a";
        
        String filtros = "";
        
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj.getNome().length() > 0){
            filtros += "a.nome like :nome";
            parametros.put("nome", obj.getNome()+"%");
        }
        if(obj.getTipo() != null){
            if(filtros.length() > 0)
                filtros += " and ";
            filtros += "a.tipo = :tipo";
            parametros.put("tipo", obj.getTipo());
        }
        
        if(filtros.length() > 0)
            jpql = jpql + " were " + filtros;
        
        var query = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet()){
            query.setParameter(chave, parametros.get(chave));
        }
        return query.getResultList();
    }
    
    public boolean autenticar(String login, String senha){
        Query sql = this.manager.createQuery("select o from Administrador o where o.usuario = :login and o.senha = :senha");
        sql.setParameter("login", login);
        sql.setParameter("senha", senha);
        
        System.out.println(sql);
        if(sql.getResultList().size() > 0)
            return true;
        return false;
    }
    
    
    
}
