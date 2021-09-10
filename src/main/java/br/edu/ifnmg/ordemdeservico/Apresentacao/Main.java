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
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaTipo;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServico;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServicoRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.RepositorioFactory;
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
        repop.Salvar(new Cliente("Naruto", "konoha@", "1234", Documento.cpf, PessoaTipo.Cliente, "123"));
        Cliente e = new Cliente("Sasuke", "uchirra@", "576", Documento.cnpj, PessoaTipo.Cliente, "435");
        repop.Salvar(e);
        //System.out.println(e.getNome());
    }
    
    public static void criaBasePrestador(){
        PrestadorDeServicoRepositorio repo = RepositorioFactory.getPrestadorDeServicoRepositorio();
        repo.Salvar(new PrestadorDeServico("pintor", "prestador4", "edhwuefhwye", "32422", Documento.cpf, PessoaTipo.PrestadorDeServico, "2342347"));
    }
    
    
    
    
    
    public static void main(String[] args){
        
        //criaBaseCliente();
        //criaBaseAdm();
        //criaBasePrestador();
        
        //PessoaRepositorio repo = RepositorioFactory.getPessoaRepositorio();

        PrestadorDeServicoRepositorio repo = RepositorioFactory.getPrestadorDeServicoRepositorio();
        
        PrestadorDeServico pres = new PrestadorDeServico();
        pres.setNome("prestador5");
        
        for(PrestadorDeServico p : repo.Buscar(pres)){
            System.out.println(p.getId());
            //repo.Apagar(p);
        }
      
    }
    
}
