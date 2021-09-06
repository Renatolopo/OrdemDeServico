/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Apresentacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Administrador;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Cliente;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.ClienteRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Documento;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Pessoa;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaTipo;
import br.edu.ifnmg.ordemdeservico.Persistencia.ClienteDAO;
import br.edu.ifnmg.ordemdeservico.Persistencia.PessoaDAO;

/**
 *
 * @author renato
 */
public class Main {
    public static void criaBaseAdm(){
        PessoaRepositorio repop = new PessoaDAO();
        repop.Salvar(new Administrador("Froid","terra plana", "Froid", "realganjaboy@Alaska", "234325", Documento.cpf, PessoaTipo.Administrador, "213231231"));
        repop.Salvar(new Administrador("Raffa Moreira","777", "BC Raff", "lilraffbro@777", "8324721312", Documento.cpf, PessoaTipo.Administrador, "132314141"));
    }
    
    public static void criaBaseCliente(){
        
        ClienteRepositorio repop = new ClienteDAO();
        repop.Salvar(new Cliente("Ribamar", "vasco@", "234325", Documento.cpf, PessoaTipo.Cliente, "567534"));
        Cliente e = new Cliente("Gabgol", "Flamengo@", "8324721312", Documento.cnpj, PessoaTipo.Cliente, "2342");
        repop.Salvar(e);
        //System.out.println(e.getNome());
    }
    
    public static void main(String[] args){
        
        criaBaseCliente();
        
        //PessoaRepositorio repo = RepositorioFactory.getPessoaRepositorio();
        
//        Pessoa p1 = new Pessoa();
//        p1.setNome("Froid");
        
        PessoaDAO repo  =  new PessoaDAO();
        
        for(Pessoa p : repo.Buscar(null)){
            System.out.println(p.getNome());
            //repo.Apagar(p);
        }
      
    }
    
}
