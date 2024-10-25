/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JRadioButton;

/**
 *
 * @author Jéssica Petersen
 */
public class Inicio extends javax.swing.JFrame {

    private Jogo tela;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();

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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        GroupButonMovimento = new javax.swing.ButtonGroup();
        GrupoReiMovimento = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButtonHnefatafl = new javax.swing.JButton();
        jButtonBrandubh = new javax.swing.JButton();
        jButtonTablut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonUmaCasa = new javax.swing.JRadioButton();
        jRadioButtonQntsCasas = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonReiUm = new javax.swing.JRadioButton();
        jRadioButtonReiQuatro = new javax.swing.JRadioButton();
        jRadioButtonReiVarios = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jéssica Bernardi Petersen");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tabuleiro Hnefatafl");

        jButtonHnefatafl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hnefatafl.png"))); // NOI18N
        jButtonHnefatafl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHnefataflActionPerformed(evt);
            }
        });

        jButtonBrandubh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Brandubh.png"))); // NOI18N
        jButtonBrandubh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrandubhActionPerformed(evt);
            }
        });

        jButtonTablut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tablut.png"))); // NOI18N
        jButtonTablut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTablutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hnefatafl");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Brandubh");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tablut");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Escolha o jogo desejado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Movimento das peças normais:");

        GroupButonMovimento.add(jRadioButtonUmaCasa);
        jRadioButtonUmaCasa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonUmaCasa.setSelected(true);
        jRadioButtonUmaCasa.setText("Moverem um quadrado");

        GroupButonMovimento.add(jRadioButtonQntsCasas);
        jRadioButtonQntsCasas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonQntsCasas.setText("Moverem vários quadrados");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Movimento do Rei:");

        GrupoReiMovimento.add(jRadioButtonReiUm);
        jRadioButtonReiUm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonReiUm.setSelected(true);
        jRadioButtonReiUm.setText("Mover um quadrado");

        GrupoReiMovimento.add(jRadioButtonReiQuatro);
        jRadioButtonReiQuatro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonReiQuatro.setText("Mover quatro quadrados");

        GrupoReiMovimento.add(jRadioButtonReiVarios);
        jRadioButtonReiVarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonReiVarios.setText("Mover vários quadrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonHnefatafl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBrandubh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTablut, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonUmaCasa)
                    .addComponent(jRadioButtonQntsCasas))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonReiVarios)
                    .addComponent(jRadioButtonReiQuatro)
                    .addComponent(jRadioButtonReiUm))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRadioButtonQntsCasas, jRadioButtonUmaCasa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonUmaCasa)
                    .addComponent(jRadioButtonReiUm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonQntsCasas)
                    .addComponent(jRadioButtonReiQuatro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonReiVarios)
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonBrandubh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButtonHnefatafl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTablut, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHnefataflActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHnefataflActionPerformed
        acaoBotoes(1);
    }//GEN-LAST:event_jButtonHnefataflActionPerformed

    private void jButtonBrandubhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrandubhActionPerformed
        acaoBotoes(2);
    }//GEN-LAST:event_jButtonBrandubhActionPerformed

    private void jButtonTablutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTablutActionPerformed
        acaoBotoes(3);
    }//GEN-LAST:event_jButtonTablutActionPerformed

    private void acaoBotoes(int tabuleiro) {
        int casaRei = 0;
        int casaNormal = 0;

        if (getjRadioButtonUmaCasa().isSelected()) {
            casaNormal = 1;
        } else {
            casaNormal = 2;
        }

        if (getjRadioButtonReiUm().isSelected()) {
            casaRei = 1;
        } else {
            if (getjRadioButtonReiQuatro().isSelected()) {
                casaRei = 4;
            } else {
                casaRei = 2;
            }
        }
        this.dispose();
        tela = new Jogo(tabuleiro, casaNormal, casaRei);
        tela.setVisible(true);
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupButonMovimento;
    private javax.swing.ButtonGroup GrupoReiMovimento;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButtonBrandubh;
    private javax.swing.JButton jButtonHnefatafl;
    private javax.swing.JButton jButtonTablut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButtonQntsCasas;
    private javax.swing.JRadioButton jRadioButtonReiQuatro;
    private javax.swing.JRadioButton jRadioButtonReiUm;
    private javax.swing.JRadioButton jRadioButtonReiVarios;
    private javax.swing.JRadioButton jRadioButtonUmaCasa;
    // End of variables declaration//GEN-END:variables

    public JRadioButton getjRadioButtonQntsCasas() {
        return jRadioButtonQntsCasas;
    }

    public void setjRadioButtonQntsCasas(JRadioButton jRadioButtonQntsCasas) {
        this.jRadioButtonQntsCasas = jRadioButtonQntsCasas;
    }

    public JRadioButton getjRadioButtonReiQuatro() {
        return jRadioButtonReiQuatro;
    }

    public void setjRadioButtonReiQuatro(JRadioButton jRadioButtonReiQuatro) {
        this.jRadioButtonReiQuatro = jRadioButtonReiQuatro;
    }

    public JRadioButton getjRadioButtonReiUm() {
        return jRadioButtonReiUm;
    }

    public void setjRadioButtonReiUm(JRadioButton jRadioButtonReiUm) {
        this.jRadioButtonReiUm = jRadioButtonReiUm;
    }

    public JRadioButton getjRadioButtonReiVarios() {
        return jRadioButtonReiVarios;
    }

    public void setjRadioButtonReiVarios(JRadioButton jRadioButtonReiVarios) {
        this.jRadioButtonReiVarios = jRadioButtonReiVarios;
    }

    public JRadioButton getjRadioButtonUmaCasa() {
        return jRadioButtonUmaCasa;
    }

    public void setjRadioButtonUmaCasa(JRadioButton jRadioButtonUmaCasa) {
        this.jRadioButtonUmaCasa = jRadioButtonUmaCasa;
    }

}
