/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import br.edu.ifnmg.ordemdeservico.Apresentacao.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renato
 */
public class RepositorioFactory {
    
    private static Properties propriedades = new Properties();
    private static AdministradorRepositorio administrador;
    private static ClienteRepositorio cliente;
    private static EnderecoRepositorio endereco;
    private static ItemRepositorio item;
    private static OrdemDeServicoRepositorio ordemDeServico;
    private static PessoaRepositorio pessoa;
    private static PrestadorDeServicoRepositorio prestadorDeServico;
    private static ServicoRepositorio servico;
    
    static{
        FileReader leitorArquivo = null;
        
        try {
            File arquivoPropriedades = new File("config.properties");
            leitorArquivo = new FileReader(arquivoPropriedades);
            propriedades.load(leitorArquivo);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                leitorArquivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static Object getInstancia(String nomeclasse){
        try{
            Class classe = Class.forName(nomeclasse);
            Object instancia =  classe.getDeclaredConstructor().newInstance();
            
            return instancia;
            
        } catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static AdministradorRepositorio getAdministradorRepositorio(){
        if(administrador == null){
            String nomeclasse = propriedades.getProperty("AdministradorRepositorio");
            administrador = (AdministradorRepositorio) getInstancia(nomeclasse);
        }
        return administrador;
    }
    
    public static ClienteRepositorio getClienteRepositorio(){
        if(cliente == null){
            String nomeclasse = propriedades.getProperty("ClienteRepositorio");
            cliente = (ClienteRepositorio) getInstancia(nomeclasse);
        }
        return cliente;
    }
    
    public static EnderecoRepositorio getEnderecoRepositorio(){
        if(endereco == null){
            String nomeclasse = propriedades.getProperty("EnderecoRepositorio");
            endereco = (EnderecoRepositorio) getInstancia(nomeclasse);
        }
        return endereco;
    }
    
    public static ItemRepositorio getItemRepositorio(){
        if(item == null){
            String nomeclasse = propriedades.getProperty("ItemRepositorio");
            item = (ItemRepositorio) getInstancia(nomeclasse);
        }
        return item;
    }
    
    public static OrdemDeServicoRepositorio getOrdemDeServicoRepositorio(){
        if(ordemDeServico == null){
            String nomeclasse = propriedades.getProperty("OrdemDeServicoRepositorio");
            ordemDeServico = (OrdemDeServicoRepositorio) getInstancia(nomeclasse);
        }
        return ordemDeServico;
    }
    
    public static PessoaRepositorio getPessoaRepositorio(){
        if(pessoa == null){
            String nomeclasse = propriedades.getProperty("PessoaRepositorio");
            pessoa = (PessoaRepositorio) getInstancia(nomeclasse);
        }
        return pessoa;
    }
    
    public static PrestadorDeServicoRepositorio getPrestadorDeServicoRepositorio(){
        if(prestadorDeServico == null){
            String nomeclasse = propriedades.getProperty("PrestadorDeServicoRepositorio");
            prestadorDeServico = (PrestadorDeServicoRepositorio) getInstancia(nomeclasse);
        }
        return prestadorDeServico;
    }
    
    public static ServicoRepositorio getServicoRepositorio(){
        if(servico == null){
            String nomeclasse = propriedades.getProperty("ServicoRepositorio");
            servico = (ServicoRepositorio) getInstancia(nomeclasse);
        }
        return servico;
    }
}
