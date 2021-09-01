/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Persistencia;

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
        // consulta JPQL padrão
        String jpql = "select o from Administrador o";
        
        // Dicionario de parametros
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        // Verifico quais os valores que existem no obj
        if(obj != null){
            if(obj.getUsuario() != null & !obj.getUsuario().isEmpty()){
                parametros.put("usuario", obj.getUsuario());
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
