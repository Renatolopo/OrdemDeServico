/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Apresentacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Administrador;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Documento;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Pessoa;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaTipo;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.RepositorioFactory;
import br.edu.ifnmg.ordemdeservico.Persistencia.PessoaDAO;

/**
 *
 * @author renato
 */
public class Main {
    public static void criaBase(){
        PessoaRepositorio repop = new PessoaDAO();
        repop.Salvar(new Administrador("Froid","terra plana", "Froid", "realganjaboy@Alaska", "234325", Documento.cpf, PessoaTipo.Administrador));
        repop.Salvar(new Administrador("Raffa Moreira","777", "BC Raff", "lilraffbro@777", "8324721312", Documento.cpf, PessoaTipo.Administrador));
    }
    
    public static void main(String[] args){
        
        PessoaRepositorio repo = RepositorioFactory.getPessoaRepositorio();
        
        //Pessoa p = new Pessoa();
        
        //PessoaDAO repo  =  new PessoaDAO();
        
        for(Pessoa p : repo.Buscar(null)){
            System.out.println(p.getNome());
        }
      
    }
    
}
