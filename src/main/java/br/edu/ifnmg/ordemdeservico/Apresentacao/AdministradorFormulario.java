/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Apresentacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Administrador;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.AdministradorRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Documento;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PessoaTipo;
import br.edu.ifnmg.ordemdeservico.Persistencia.AdministradorDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author renato
 */
public class AdministradorFormulario extends javax.swing.JFrame {
    
    Administrador administrador;
    AdministradorRepositorio repositorio;

    /**
     * Creates new form AdministradorEditar
     */
    public AdministradorFormulario(Administrador a) {
        this.administrador = a;
        
        //this.repositorio = RepositorioFactory.getAdministradorRepositorio();
        this.repositorio = new AdministradorDAO();
        initComponents();
        this.setComponentes();
      
    }

    private AdministradorFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void setComponentes(){
        this.lblId.setText(this.administrador.getId().toString());
        this.txtLogin.setText(this.administrador.getUsuario());
        this.txtSenha.setText(this.administrador.getSenha());
        this.txtNome.setText(this.administrador.getNome());
        this.txtEmail.setText(this.administrador.getEmail());
        this.txtTelefone.setText(this.administrador.getTelefone());
        this.txtDocumentoIdentificacao.setText(this.administrador.getNumDocumento());
    }
    
    private void getComponentes(){        
        this.administrador.setUsuario(this.txtLogin.getText());
        this.administrador.setSenha(String.valueOf(txtSenha.getPassword()));
        this.administrador.setNome(this.txtNome.getText());
        this.administrador.setEmail(this.txtEmail.getText());
        this.administrador.setTelefone(this.txtTelefone.getText());
        
        String itemSelecionado = this.CaixaTipoDocumento.getSelectedItem().toString();
        if(itemSelecionado == "CPF"){
            this.administrador.setDocumentoIdentificacao(Documento.cpf);
        }else{
            this.administrador.setDocumentoIdentificacao(Documento.cnpj);
        }
        
        this.administrador.setNumDocumento(this.txtDocumentoIdentificacao.getText());
        this.administrador.setTipo(PessoaTipo.Administrador);
        
            
    }
    
    private void getComponentesRemover(){
        Administrador a  = new Administrador();
        a.setUsuario(this.txtLogin.getText());
        this.administrador = repositorio.Buscar(a).get(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        CaixaTipoDocumento = new javax.swing.JComboBox<>();
        txtDocumentoIdentificacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar");

        jPanel1.setBackground(new java.awt.Color(245, 246, 247));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Id:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Usuário:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Senha:");

        lblId.setForeground(new java.awt.Color(0, 0, 0));
        lblId.setText("0");

        txtLogin.setBackground(new java.awt.Color(255, 255, 255));

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));

        btnSalvar.setBackground(new java.awt.Color(117, 168, 255));
        btnSalvar.setForeground(new java.awt.Color(0, 0, 0));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/icons8-salvar-30.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(117, 168, 255));
        btnRemover.setForeground(new java.awt.Color(0, 0, 0));
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/icons8-excluir-30.png"))); // NOI18N
        btnRemover.setToolTipText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(117, 168, 255));
        btnVoltar.setForeground(new java.awt.Color(0, 0, 0));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/icons8-sair-30.png"))); // NOI18N
        btnVoltar.setToolTipText("Sair");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome:");

        txtNome.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email:");

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telefone:");

        txtTelefone.setBackground(new java.awt.Color(255, 255, 255));

        CaixaTipoDocumento.setBackground(new java.awt.Color(245, 246, 247));
        CaixaTipoDocumento.setForeground(new java.awt.Color(0, 0, 0));
        CaixaTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "CNPJ" }));
        CaixaTipoDocumento.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                CaixaTipoDocumentoComponentAdded(evt);
            }
        });
        CaixaTipoDocumento.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CaixaTipoDocumentoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtDocumentoIdentificacao.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(CaixaTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblId)
                            .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtNome)
                            .addComponent(txtEmail)
                            .addComponent(txtDocumentoIdentificacao, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txtTelefone)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblId))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumentoIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaixaTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemover)
                    .addComponent(btnSalvar)
                    .addComponent(btnVoltar))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CaixaTipoDocumentoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CaixaTipoDocumentoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaTipoDocumentoAncestorAdded

    private void CaixaTipoDocumentoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_CaixaTipoDocumentoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaTipoDocumentoComponentAdded

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        this.getComponentesRemover();
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente remover o Administrador atual?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){
            if(repositorio.Apagar(this.administrador)){
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Aconteceu um problema ao remover os dados!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente Salvar os dados do Administrador?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){

            this.getComponentes();
            if(repositorio.Salvar(this.administrador)){
                JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                this.setComponentes();
            }else{
                JOptionPane.showMessageDialog(this, "Aconteceu um erro ao salvar os dados!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(this, "Operação cancelada", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(AdministradorFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CaixaTipoDocumento;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtDocumentoIdentificacao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}