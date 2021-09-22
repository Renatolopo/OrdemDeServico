/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Apresentacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Item;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServico;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServicoRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Servico;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.ServicoRepositorio;
import br.edu.ifnmg.ordemdeservico.Persistencia.PrestadorDeServicoDAO;
import br.edu.ifnmg.ordemdeservico.Persistencia.ServicoDAO;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author renato
 */
public class ServicoFormulario extends javax.swing.JFrame {
    ServicoRepositorio repositorio;
    Servico servico;
    PrestadorDeServicoRepositorio repoPrestadorDeServico;
    PrestadorDeServico prestadorDeServico;
    ArrayList<Item> itens;

    /**
     * Creates new form ServicoFormulario
     */
    public ServicoFormulario(Servico s) {
        this.servico = s;
        this.repositorio = new ServicoDAO();
        this.repoPrestadorDeServico = new PrestadorDeServicoDAO();
        this.itens = new ArrayList<>();
        initComponents();
        
        this.setComponentes();
    }

    private ServicoFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int getIndexDoStatus(String status){
        if(status == "Em andamento"){
            return 0;
        }else if(status == "Pronto"){
            return 1;
        }else{
            return 2;
        }
    }

    
    private void setComponentes(){
        this.lblId.setText(this.servico.getId().toString());
        this.txtDescricao.setText(this.servico.getDescricao());
        this.txtDiagnostico.setText(this.servico.getDiagnostico());
        this.txtResolucao.setText(this.servico.getResolucao());
        this.cbStatus.setSelectedItem(getIndexDoStatus(this.servico.getStatus()));
        this.txtObservacao.setText(this.servico.getObservacao());
        this.lblPrestadorDeServico.setText(this.servico.getPrestadorDeServico().getNome());
        
        // lista de itens
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");   
        modelo.addColumn("nome");
        
        for(Item i : this.servico.getItens()){
            Vector linha = new Vector();
            linha.add(i.getId());
            linha.add(i.getNome());
            
            modelo.addRow(linha);
           
        }
        
        tblItens.setModel(modelo);
          
    }
    
    private void getComponentes(){
        this.servico.setDescricao(this.txtDescricao.getText());
        this.servico.setDiagnostico(this.txtDiagnostico.getText());
        this.servico.setResolucao(this.txtResolucao.getText());
        this.servico.setObservacao(this.txtObservacao.getText());
        this.servico.setStatus(this.cbStatus.getSelectedItem().toString());
        //this.servico.setPrestadorDeServico((PrestadorDeServico) cbPrestadorServico.getSelectedItem());
        this.servico.setPrestadorDeServico(this.prestadorDeServico);
        this.servico.setItens(this.itens);
        
        
    }
    public void setItem(Item item){
        //add o item selecionado
        this.itens.add(item);
        
        //add o item selecionado na tabela
        List<Item> resultado = this.itens;
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");   
        modelo.addColumn("nome");
        
        for(Item i : resultado){
            Vector linha = new Vector();
            linha.add(i.getId());
            linha.add(i.getNome());
            
            modelo.addRow(linha);
           
        }
        
        tblItens.setModel(modelo);
        
    }
    
    public void setPrestador(PrestadorDeServico p){     
        this.prestadorDeServico = p;
        this.lblPrestadorDeServico.setText(this.prestadorDeServico.getNome());
        
    }
    
    private void getComponentesRemover(){
        Servico s = new Servico();
        s.setId(Long.parseLong(this.lblId.toString()));
        this.servico = repositorio.Buscar(s).get(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiagnostico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtResolucao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        btnAddItem = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblPrestadorDeServico = new javax.swing.JLabel();
        btnAddPrestador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 246, 247));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Id:");

        lblId.setForeground(new java.awt.Color(0, 0, 0));
        lblId.setText("0");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descrição:");

        txtDescricao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Diagnostico:");

        txtDiagnostico.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Resolução:");

        txtResolucao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Status:");

        cbStatus.setBackground(new java.awt.Color(255, 255, 255));
        cbStatus.setForeground(new java.awt.Color(0, 0, 0));
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Em andamento", "Pronto", "Cancelado" }));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Observações:");

        txtObservacao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Prestador de Serviço:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Lista de Itens:");

        tblItens.setBackground(new java.awt.Color(255, 255, 255));
        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItens);
        if (tblItens.getColumnModel().getColumnCount() > 0) {
            tblItens.getColumnModel().getColumn(0).setResizable(false);
            tblItens.getColumnModel().getColumn(1).setResizable(false);
        }

        btnAddItem.setBackground(new java.awt.Color(117, 168, 255));
        btnAddItem.setForeground(new java.awt.Color(0, 0, 0));
        btnAddItem.setText("Adicionar");
        btnAddItem.setToolTipText("");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(117, 168, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-salvar-30.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(117, 168, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-excluir-30.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(117, 168, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sair-30.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblPrestadorDeServico.setForeground(new java.awt.Color(0, 0, 0));
        lblPrestadorDeServico.setText("--");

        btnAddPrestador.setBackground(new java.awt.Color(117, 168, 255));
        btnAddPrestador.setForeground(new java.awt.Color(0, 0, 0));
        btnAddPrestador.setText("selecionar");
        btnAddPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPrestadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblId)
                    .addComponent(txtDescricao)
                    .addComponent(txtDiagnostico)
                    .addComponent(txtResolucao)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddItem, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPrestadorDeServico, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(42, 42, 42)
                            .addComponent(btnAddPrestador))
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(40, 40, 40)
                .addComponent(btnExcluir)
                .addGap(40, 40, 40)
                .addComponent(btnSair)
                .addGap(276, 276, 276))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblId))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnAddPrestador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrestadorDeServico))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(btnAddItem))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtResolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPrestadorActionPerformed
        // TODO add your handling code here:
        ServicoSelecionarPrestador tela = new ServicoSelecionarPrestador(this);
        tela.setVisible(true);
    }//GEN-LAST:event_btnAddPrestadorActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        this.getComponentesRemover();
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente remover o Administrador atual?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){
            if(repositorio.Apagar(this.servico)){
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Aconteceu um problema ao remover os dados!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente Salvar os dados do Serviço?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){

            this.getComponentes();
            if(repositorio.Salvar(this.servico)){
                JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                this.setComponentes();
            }else{
                JOptionPane.showMessageDialog(this, "Aconteceu um erro ao salvar os dados!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(this, "Operação cancelada", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
        ServicoAddItem tela = new ServicoAddItem(this);
        tela.setVisible(true);
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void tblItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblItensMouseClicked

    public PrestadorDeServico getPrestadorDeServico() {
        return prestadorDeServico;
    }

    public void setPrestadorDeServico(PrestadorDeServico prestadorDeServico) {
        this.prestadorDeServico = prestadorDeServico;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicoFormulario().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddPrestador;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPrestadorDeServico;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtResolucao;
    // End of variables declaration//GEN-END:variables
}
