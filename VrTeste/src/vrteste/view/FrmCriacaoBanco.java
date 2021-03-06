/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrteste.view;

import vrteste.controller.AplicacaoController;

/**
 *
 * @author guilh
 */
public class FrmCriacaoBanco extends javax.swing.JInternalFrame {
    private final AplicacaoController aplicacao;
    /**
     * Creates new form FrmCriacaoBanco
     */
    public FrmCriacaoBanco() {
        initComponents();
        aplicacao = new AplicacaoController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonProsseguir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Criacao de Banco de dados");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Olá!\nO banco de dados não foi encontrado para esta aplicação. \n\nDeseja prosseguir com a criação do banco de dados?");
        jScrollPane1.setViewportView(jTextArea1);

        jButtonProsseguir.setText("Prosseguir");
        jButtonProsseguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProsseguirActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonProsseguir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProsseguir)
                    .addComponent(jButtonCancelar))
                .addGap(26, 26, 26)
                .addComponent(jLabelStatus)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProsseguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProsseguirActionPerformed
       jButtonCancelar.setEnabled(false);
       jButtonProsseguir.setEnabled(false);
        jLabelStatus.setText("Iniciando a criação do Banco de dados!");
        try{
           aplicacao.criarBanco();
           jLabelStatus.setText("Banco criado com sucesso! Por favor, reinicie a aplicação.");
       } catch (Exception e){
         jLabelStatus.setText(e.getMessage());
       }
    }//GEN-LAST:event_jButtonProsseguirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonProsseguir;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
