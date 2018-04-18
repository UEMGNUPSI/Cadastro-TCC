/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Dao.UsuarioD;
import Model.UsuarioM;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Leandro
 */
public class LoginView extends javax.swing.JFrame {
    
    //String MASP = "root";
    //String Senha = "root";
    
    UsuarioM usuarioM;
    UsuarioD usuarioDAO;
    
    public LoginView() {
        initComponents();
        
        txtLogin.setOpaque(false);
        txtSenha.setOpaque(false);
        btnEntrar.setUI(new BasicButtonUI());
        btnFechar.setUI(new BasicButtonUI());
        
        lblAviso.setVisible(false);
        
        
        txtLogin.requestFocus();
        txtLogin.selectAll();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        pnlFundo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        imgLogin = new javax.swing.JLabel();
        pnlFundoLabelLogin = new javax.swing.JPanel();
        lblTituloLogin = new javax.swing.JLabel();
        imgSenha = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblLogin1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        lblNUPSI = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(590, 280));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFundo.setBackground(new java.awt.Color(249, 249, 249));
        pnlFundo.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 110, 143), 2)));
        pnlFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFechar.setBackground(new java.awt.Color(59, 110, 143));
        btnFechar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(247, 247, 247));
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-x-mark-11-24.png"))); // NOI18N
        btnFechar.setToolTipText("Fechar");
        btnFechar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btnFechar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-x-mark-11-24-press.png"))); // NOI18N
        btnFechar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-x-mark-11-24-over.png"))); // NOI18N
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        pnlFundo.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 3, 30, -1));

        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-user-7-24.png"))); // NOI18N
        pnlFundo.add(imgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 120, -1, -1));

        pnlFundoLabelLogin.setBackground(new java.awt.Color(59, 110, 143));
        pnlFundoLabelLogin.setLayout(new java.awt.GridLayout(1, 0));

        lblTituloLogin.setBackground(new java.awt.Color(206, 218, 227));
        lblTituloLogin.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblTituloLogin.setForeground(new java.awt.Color(233, 233, 236));
        lblTituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloLogin.setText("Login");
        pnlFundoLabelLogin.add(lblTituloLogin);

        pnlFundo.add(pnlFundoLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 590, 60));

        imgSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-password-10-24.png"))); // NOI18N
        imgSenha.setToolTipText("Digite o MASP");
        pnlFundo.add(imgSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 180, -1, -1));

        lblLogin.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(29, 31, 40));
        lblLogin.setText("MASP");
        pnlFundo.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        lblLogin1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblLogin1.setForeground(new java.awt.Color(29, 31, 40));
        lblLogin1.setText("Senha");
        pnlFundo.add(lblLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        txtLogin.setBackground(new java.awt.Color(249, 249, 249));
        txtLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(29, 31, 40));
        txtLogin.setText("root");
        txtLogin.setToolTipText("Digite seu MASP");
        txtLogin.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 149)), javax.swing.BorderFactory.createEmptyBorder(1, 40, 0, 1)));
        txtLogin.setFocusCycleRoot(true);
        txtLogin.setNextFocusableComponent(txtSenha);
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });
        pnlFundo.add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 260, 30));

        txtSenha.setBackground(new java.awt.Color(249, 249, 249));
        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(29, 31, 40));
        txtSenha.setText("root");
        txtSenha.setToolTipText("Digite sua senha");
        txtSenha.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 40, 0, 1)));
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });
        pnlFundo.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 260, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Logo_vertical.png"))); // NOI18N
        pnlFundo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        btnEntrar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        pnlFundo.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 90, 30));

        lblNUPSI.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNUPSI.setForeground(new java.awt.Color(121, 118, 118));
        lblNUPSI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNUPSI.setText("Software developed by NUPSI");
        pnlFundo.add(lblNUPSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 250, 580, -1));

        lblAviso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(234, 42, 64));
        lblAviso.setText("MASP ou Senha incorretos!");
        pnlFundo.add(lblAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        getContentPane().add(pnlFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 280));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        
        usuarioM = null;
        try {
            if (txtLogin.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "O usuário deve ser preenchido.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                txtLogin.requestFocus();

            } else if (txtSenha.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "A senha deve ser preenchida.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                txtSenha.requestFocus();
            } else {
                usuarioM = UsuarioD.valida(txtLogin.getText(), txtSenha.getText());
                if(usuarioM == null){
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtLogin.setText("");
                    txtSenha.setText("");
                    txtLogin.requestFocus();
                }else{
       
                    PrincipalView principal = new PrincipalView(usuarioM);
                    this.dispose();
                    
                }
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            txtLogin.setText("");
            txtSenha.setText("");
            txtLogin.requestFocus();
            ex.printStackTrace();
            
        }
       
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        if(evt.getKeyCode() == 10){
            txtSenha.requestFocus();
            txtSenha.selectAll();
        }
    }//GEN-LAST:event_txtLoginKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if(evt.getKeyCode() == 10){
            PrincipalView pri = new PrincipalView();
            
            pri.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JLabel imgSenha;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLogin1;
    private javax.swing.JLabel lblNUPSI;
    private javax.swing.JLabel lblTituloLogin;
    private javax.swing.JPanel pnlFundo;
    private javax.swing.JPanel pnlFundoLabelLogin;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
