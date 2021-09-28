/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ordemdeservico.Apresentacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Cliente;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.ClienteRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.FormaDePagamento;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Item;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.OrdemDeServico;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.OrdemDeServicoRepositorio;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Servico;
import br.edu.ifnmg.ordemdeservico.Persistencia.ClienteDAO;
import br.edu.ifnmg.ordemdeservico.Persistencia.OrdemDeServicoDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author renato
 */
public class OrdemDeServicoFormulario extends javax.swing.JFrame {
    ClienteRepositorio clienteRepo;
    Cliente cliente;
    ArrayList<Servico> servicos;
    OrdemDeServicoRepositorio repositorio;
    OrdemDeServico ordemDeServico;

    /**
     * Creates new form OrdemDeServicoFormulario
     */
    public OrdemDeServicoFormulario(OrdemDeServico o) {
        this.clienteRepo = new ClienteDAO();
        this.ordemDeServico = o;
        this.repositorio = new OrdemDeServicoDAO();
        this.servicos = new ArrayList<>();
        initComponents();
        
        this.setComponentes();
    }
    
    private void setComponentes(){
        this.lblId.setText(this.ordemDeServico.getId().toString());
        this.txtCliente.setText(this.ordemDeServico.getCliente().getNome());
        this.txtMotivoDaChamada.setText(this.ordemDeServico.getMotivoDaChamada());
        this.txtDataInicio.setText(this.ordemDeServico.getData().toString());
        this.txtFimDoAtendimento.setText(this.ordemDeServico.getFimDoAtendimento().toString());
        this.txtTotalServico.setText(this.ordemDeServico.getTotalDoServico().toString());
        this.cbFormaDePagamento.setSelectedItem(this.ordemDeServico.getFormaDePagamento().toString());
        
        // Lista de Serviços
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");   
        modelo.addColumn("Descrição");
        
        for(Servico s : this.ordemDeServico.getServicos()){
            Vector linha = new Vector();
            linha.add(s.getId());
            linha.add(s.getDescricao());
            
            modelo.addRow(linha);
           
        }
        
        tblServicos.setModel(modelo);
    }
    private void getComponentes() throws ParseException{
        this.ordemDeServico.setCliente(this.cliente);
        this.ordemDeServico.setMotivoDaChamada(this.txtMotivoDaChamada.getText());
        this.ordemDeServico.setTotalDoServico(new BigDecimal(this.txtTotalServico.getText()));        
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date dataInicio = formato.parse(this.txtDataInicio.getText()); 
        this.ordemDeServico.setData(dataInicio);
        Date dataFim = formato.parse(this.txtFimDoAtendimento.getText()); 
        this.ordemDeServico.setFimDoAtendimento(dataFim);
        
        String itemSelecionado = this.cbFormaDePagamento.getSelectedItem().toString();
        if(itemSelecionado == "Dinheiro"){
            this.ordemDeServico.setFormaDePagamento(FormaDePagamento.dinheiro);
        }
        else if(itemSelecionado == "Cartão Debito"){
            this.ordemDeServico.setFormaDePagamento(FormaDePagamento.cartaoDebito);
        }
        else if(itemSelecionado == "Cartão Credito"){
            this.ordemDeServico.setFormaDePagamento(FormaDePagamento.cartaoCredito);
        }
        else{
            this.ordemDeServico.setFormaDePagamento(FormaDePagamento.boletoBancario);
        }
            
        this.ordemDeServico.setServicos(this.servicos);

    }
    

    
    public void setCliente(Cliente c){
        this.cliente = c;
        this.txtCliente.setText(this.cliente.getNome());
    }

    private OrdemDeServicoFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMotivoDaChamada = new javax.swing.JTextField();
        cbFormaDePagamento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDataInicio = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFimDoAtendimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        btnAddCliente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnAddServico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnGerarRelatorio = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        txtTotalServico = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 246, 247));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Id:");

        lblId.setForeground(new java.awt.Color(0, 0, 0));
        lblId.setText("0");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Motivo da Chamada:");

        txtMotivoDaChamada.setBackground(new java.awt.Color(255, 255, 255));

        cbFormaDePagamento.setBackground(new java.awt.Color(255, 255, 255));
        cbFormaDePagamento.setForeground(new java.awt.Color(0, 0, 0));
        cbFormaDePagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartão Debito", "Cartão Credito", "Boleto Bancário" }));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Forma de Pagamento:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Data Inicio do atendimento:");

        txtDataInicio.setBackground(new java.awt.Color(255, 255, 255));
        txtDataInicio.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicio.setToolTipText("");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Data de Fim do atendimento:");

        txtFimDoAtendimento.setBackground(new java.awt.Color(255, 255, 255));
        txtFimDoAtendimento.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtFimDoAtendimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Total do serviço:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("R$:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cliente:");

        btnAddCliente.setBackground(new java.awt.Color(117, 168, 255));
        btnAddCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnAddCliente.setText("Selecionar");
        btnAddCliente.setPreferredSize(new java.awt.Dimension(35, 23));
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Serviços:");

        btnAddServico.setBackground(new java.awt.Color(117, 168, 255));
        btnAddServico.setForeground(new java.awt.Color(0, 0, 0));
        btnAddServico.setText("Adicionar");
        btnAddServico.setPreferredSize(new java.awt.Dimension(35, 23));
        btnAddServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServicoActionPerformed(evt);
            }
        });

        tblServicos.setBackground(new java.awt.Color(245, 246, 247));
        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição"
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
        jScrollPane1.setViewportView(tblServicos);
        if (tblServicos.getColumnModel().getColumnCount() > 0) {
            tblServicos.getColumnModel().getColumn(0).setResizable(false);
            tblServicos.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSalvar.setBackground(new java.awt.Color(117, 168, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-salvar-30.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(117, 168, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sair-30.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnGerarRelatorio.setBackground(new java.awt.Color(117, 168, 255));
        btnGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/icons8-ordem-de-compra-30.png"))); // NOI18N

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(255, 255, 255));

        txtTotalServico.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalServico.setForeground(new java.awt.Color(0, 0, 0));
        txtTotalServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btnSalvar)
                        .addGap(53, 53, 53)
                        .addComponent(btnSair)
                        .addGap(52, 52, 52)
                        .addComponent(btnGerarRelatorio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalServico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblId))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtMotivoDaChamada))
                            .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFimDoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAddServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblId))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMotivoDaChamada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFimDoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTotalServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(btnAddServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnGerarRelatorio))
                .addContainerGap(69, Short.MAX_VALUE))
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

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        // TODO add your handling code here:
        OrdemDeServicoSelecionarCliente tela = new OrdemDeServicoSelecionarCliente(this);
        tela.setVisible(true);
    }//GEN-LAST:event_btnAddClienteActionPerformed

    private void btnAddServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServicoActionPerformed
        // TODO add your handling code here:
        OrdemDeServicoAddServico tela = new OrdemDeServicoAddServico(this);
        tela.setVisible(true);
        
    }//GEN-LAST:event_btnAddServicoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente Salvar os dados do Serviço?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){

            try {
                this.getComponentes();
            } catch (ParseException ex) {
                Logger.getLogger(OrdemDeServicoFormulario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(repositorio.Salvar(this.ordemDeServico)){
                JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                this.setComponentes();
            }else{
                JOptionPane.showMessageDialog(this, "Aconteceu um erro ao salvar os dados!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(this, "Operação cancelada", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(OrdemDeServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdemDeServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdemDeServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdemDeServicoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdemDeServicoFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddServico;
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbFormaDePagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tblServicos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JFormattedTextField txtFimDoAtendimento;
    private javax.swing.JTextField txtMotivoDaChamada;
    private javax.swing.JFormattedTextField txtTotalServico;
    // End of variables declaration//GEN-END:variables

    void setServico(Servico servico) {
        this.servicos.add(servico);
        
        //add o item selecionado na tabela
        List<Servico> resultado = this.servicos;
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");   
        modelo.addColumn("Descrição");
        
        for(Servico s : resultado){
            Vector linha = new Vector();
            linha.add(s.getId());
            linha.add(s.getDescricao());
            
            modelo.addRow(linha);
           
        }
        
        tblServicos.setModel(modelo);
    }

    

   
}
