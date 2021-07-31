/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Apresentacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Pessoa;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaRepositorio;
import br.edu.ifnmg.ordemdeservico.Percistencia.PessoaDAO;

/**
 *
 * @author renato
 */
public class Main {
    public static void main(String[] args){
        PessoaRepositorio repo = new PessoaDAO();  
        
        Pessoa p = new Pessoa();
        p.setNome("Renato");
        p.setEmail("reyugfeya");
        
        if(repo.Salvar(p)){
            System.out.println("Sucesso");
        }else{
            System.out.println("Falhou");
        }
        
    }
    
}
