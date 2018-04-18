/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Leandro
 */
public class PrincipalView extends javax.swing.JFrame {

    public PrincipalView() {
        initComponents();
        
        btnSalvar.setUI(new BasicButtonUI());
        btnExcluir.setUI(new BasicButtonUI());
        btnEditar.setUI(new BasicButtonUI());      
        btnCadastro.setUI(new BasicButtonUI());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        pnlFrame = new javax.swing.JPanel();
        pnlTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTCC = new javax.swing.JTable();
        cbxTipoBusca = new javax.swing.JComboBox<>();
        lblFiltro = new javax.swing.JLabel();
        lblBusca = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        lblCursoBusca = new javax.swing.JLabel();
        cbxCursoBusca = new javax.swing.JComboBox<>();
        btnCadastro = new javax.swing.JButton();
        pnlDados = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtRegistro = new javax.swing.JTextField();
        lblRegistro = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();
        lblApresentacao = new javax.swing.JLabel();
        txtApresentacao = new javax.swing.JFormattedTextField();
        txtEntrega = new javax.swing.JFormattedTextField();
        lblEntrega = new javax.swing.JLabel();
        lblFrameTitulo = new javax.swing.JLabel();
        txtOrientador = new javax.swing.JTextField();
        lblOrientador = new javax.swing.JLabel();
        cbxCoorientador = new javax.swing.JCheckBox();
        txtCoorientador = new javax.swing.JTextField();
        lblOrientador1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro TCC");
        setMaximumSize(new java.awt.Dimension(1090, 713));
        setMinimumSize(new java.awt.Dimension(1090, 713));
        setPreferredSize(new java.awt.Dimension(1090, 713));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUsuario.setBackground(new java.awt.Color(59, 110, 143));
        pnlUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(245, 244, 244));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-user-7-24-white.png"))); // NOI18N
        lblUsuario.setText("Nome do Usuário");
        lblUsuario.setToolTipText("");
        pnlUsuario.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 60));

        getContentPane().add(pnlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 60));

        pnlFrame.setMaximumSize(new java.awt.Dimension(760, 500));
        pnlFrame.setMinimumSize(new java.awt.Dimension(760, 500));
        pnlFrame.setPreferredSize(new java.awt.Dimension(760, 500));

        pnlTabela.setBackground(new java.awt.Color(250, 250, 250));
        pnlTabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));

        tblTCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Autor", "Título", "Registro", "Curso", "Apresentação", "Entrega"
            }
        ));
        jScrollPane1.setViewportView(tblTCC);

        cbxTipoBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxTipoBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autor", "Título", "Registro", "Apresentação", "Entrega" }));

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFiltro.setText("Filtro");

        lblBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBusca.setText("Busca");

        txtBusca.setBackground(new java.awt.Color(250, 250, 250));
        txtBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBusca.setToolTipText("Precione ENTER para buscar.");
        txtBusca.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10)));
        txtBusca.setOpaque(false);

        lblCursoBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCursoBusca.setText("Curso");

        cbxCursoBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCursoBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        btnCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(29, 31, 40));
        btnCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-file-14-16.png"))); // NOI18N
        btnCadastro.setText("Novo Cadastro");
        btnCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTabelaLayout = new javax.swing.GroupLayout(pnlTabela);
        pnlTabela.setLayout(pnlTabelaLayout);
        pnlTabelaLayout.setHorizontalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTabelaLayout.createSequentialGroup()
                        .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTabelaLayout.createSequentialGroup()
                                .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBusca)
                                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(pnlTabelaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFiltro)
                            .addComponent(cbxTipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCursoBusca)
                            .addComponent(cbxCursoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );
        pnlTabelaLayout.setVerticalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTabelaLayout.createSequentialGroup()
                        .addComponent(lblBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTabelaLayout.createSequentialGroup()
                        .addComponent(lblCursoBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCursoBusca))
                    .addGroup(pnlTabelaLayout.createSequentialGroup()
                        .addComponent(lblFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlDados.setBackground(new java.awt.Color(245, 245, 245));
        pnlDados.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(215, 215, 215)));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(29, 31, 40));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-edit-6-16.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Habilita a edição dos dados.");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(29, 31, 40));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-save-2-16.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(235, 176, 183));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(120, 22, 34));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-trash-can-2-16.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Exclui permanentemente o cadastro");
        btnExcluir.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 39, 56)), javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8)));
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(29, 31, 40));
        lblAutor.setText("Autor");

        txtAutor.setBackground(new java.awt.Color(245, 245, 245));
        txtAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAutor.setForeground(new java.awt.Color(29, 31, 40));
        txtAutor.setText("this.setText('teste');");
        txtAutor.setToolTipText("Nome completo do autor.");
        txtAutor.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtAutor.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtAutor.setEnabled(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(29, 31, 40));
        lblTitulo.setText("Título");

        txtTitulo.setBackground(new java.awt.Color(245, 245, 245));
        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(29, 31, 40));
        txtTitulo.setText("hldafjçdhlkhljçsdkfjklhaçdlksj kasjl dsaçkljksadjkfhdsjlakçj us pjdlçqjwpor");
        txtTitulo.setToolTipText("Título do TCC.");
        txtTitulo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtTitulo.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtTitulo.setEnabled(false);

        txtRegistro.setBackground(new java.awt.Color(245, 245, 245));
        txtRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRegistro.setForeground(new java.awt.Color(29, 31, 40));
        txtRegistro.setText("1265");
        txtRegistro.setToolTipText("Registro de TCCs.");
        txtRegistro.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtRegistro.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtRegistro.setEnabled(false);

        lblRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(29, 31, 40));
        lblRegistro.setText("Registro");

        lblCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(29, 31, 40));
        lblCurso.setText("Curso");

        cbxCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCurso.setForeground(new java.awt.Color(29, 31, 40));
        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Item 2", "Item 3", "Item 4" }));
        cbxCurso.setToolTipText("Curso em que o aluno está matriculado.");
        cbxCurso.setBorder(null);

        lblApresentacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApresentacao.setForeground(new java.awt.Color(29, 31, 40));
        lblApresentacao.setText("Apresentação");

        txtApresentacao.setBackground(new java.awt.Color(248, 248, 248));
        txtApresentacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 213, 213)));
        txtApresentacao.setForeground(new java.awt.Color(29, 31, 40));
        txtApresentacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        txtApresentacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApresentacao.setToolTipText("Data em que o TCC foi defendido.");
        txtApresentacao.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtApresentacao.setEnabled(false);
        txtApresentacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEntrega.setBackground(new java.awt.Color(248, 248, 248));
        txtEntrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 213, 213)));
        txtEntrega.setForeground(new java.awt.Color(29, 31, 40));
        txtEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        txtEntrega.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEntrega.setToolTipText("Data em que o TCC foi entregue na biblioteca.");
        txtEntrega.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtEntrega.setEnabled(false);
        txtEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEntrega.setForeground(new java.awt.Color(29, 31, 40));
        lblEntrega.setText("Entrega");

        lblFrameTitulo.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblFrameTitulo.setText("Dados do Autor");
        lblFrameTitulo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(142, 142, 142)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 5, 1)));

        txtOrientador.setBackground(new java.awt.Color(245, 245, 245));
        txtOrientador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrientador.setForeground(new java.awt.Color(29, 31, 40));
        txtOrientador.setText("this.setText('teste');");
        txtOrientador.setToolTipText("Nome completo do autor.");
        txtOrientador.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtOrientador.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtOrientador.setEnabled(false);

        lblOrientador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrientador.setForeground(new java.awt.Color(29, 31, 40));
        lblOrientador.setText("Orientador");

        cbxCoorientador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCoorientador.setForeground(new java.awt.Color(29, 31, 40));
        cbxCoorientador.setText("Coorientador");
        cbxCoorientador.setEnabled(false);
        cbxCoorientador.setOpaque(false);
        cbxCoorientador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbxCoorientadorStateChanged(evt);
            }
        });

        txtCoorientador.setBackground(new java.awt.Color(245, 245, 245));
        txtCoorientador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCoorientador.setForeground(new java.awt.Color(29, 31, 40));
        txtCoorientador.setText("this.setText('teste');");
        txtCoorientador.setToolTipText("Nome completo do autor.");
        txtCoorientador.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtCoorientador.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtCoorientador.setEnabled(false);

        lblOrientador1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrientador1.setForeground(new java.awt.Color(29, 31, 40));
        lblOrientador1.setText("Coorientador");

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDadosLayout.createSequentialGroup()
                                        .addComponent(lblTitulo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pnlDadosLayout.createSequentialGroup()
                                        .addComponent(lblFrameTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(48, 48, 48))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblRegistro))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAutor)
                                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)))
                                .addComponent(btnEditar))
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlDadosLayout.createSequentialGroup()
                                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCurso)
                                            .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApresentacao)
                                            .addComponent(txtApresentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblOrientador)
                                    .addComponent(lblOrientador1)
                                    .addComponent(txtCoorientador)
                                    .addComponent(txtOrientador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCoorientador)
                                    .addComponent(lblEntrega)
                                    .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)))))
                .addContainerGap())
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblFrameTitulo)
                        .addGap(29, 29, 29)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAutor)
                            .addComponent(lblRegistro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblOrientador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoorientador))
                .addGap(18, 18, 18)
                .addComponent(lblOrientador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCoorientador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurso)
                            .addComponent(lblApresentacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApresentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblEntrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
        pnlFrame.setLayout(pnlFrameLayout);
        pnlFrameLayout.setHorizontalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFrameLayout.setVerticalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addComponent(pnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pnlFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1090, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Habilita a edição
        if(btnEditar.isEnabled()){
            txtRegistro.setEnabled(true);
            txtAutor.setEnabled(true);
            txtTitulo.setEnabled(true);
            txtOrientador.setEnabled(true);
            txtApresentacao.setEnabled(true);
            txtEntrega.setEnabled(true);
            cbxCoorientador.setEnabled(true);
            
            if(cbxCoorientador.isSelected()){
                txtCoorientador.setEnabled(true);
            }
            else{
                txtCoorientador.setEnabled(false);
            }
            
            btnSalvar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnEditar.setEnabled(false);
            
        }
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        // Salva os dados
        if((!txtAutor.getText().equals("")) || (!txtTitulo.getText().equals("")) || (!txtApresentacao.getText().equals(""))
                || (!txtEntrega.getText().equals("")) || (cbxCurso.getSelectedIndex() != 0) || (txtRegistro.getText().equals(""))){
            
            //if(txt)
            

            btnSalvar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnEditar.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Existem campos não preenchidos.");
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // Novo cadastro, aqui deve possuir uma jdialog para ter certeza que deseja criar um novo usuário caso tenha dados preencidos
        
        if((txtAutor.isEnabled() && !txtAutor.getText().equals("")) || (txtTitulo.isEnabled() && !txtTitulo.getText().equals("")) 
                || (txtApresentacao.isEnabled() && !txtApresentacao.getText().equals("")) || (txtEntrega.isEnabled() && !txtEntrega.getText().equals("")) 
                || (cbxCurso.isEnabled() && cbxCurso.getSelectedIndex() != 0)){
            int res = JOptionPane.showConfirmDialog(null,"Existem campos preenchidos, caso deseje criar um novo cadastro todos os dados editados serão perdidos. Deseja criar um novo cadastro?", "Novo Cadastro", JOptionPane.YES_NO_OPTION);
            // Novo Cadastro
            if(res == JOptionPane.YES_OPTION){
                
                txtRegistro.setText("Ultimo Num");
                txtAutor.setText("");
                txtTitulo.setText("");
                txtOrientador.setText("");
                txtCoorientador.setText("");
                txtApresentacao.setText("");
                txtEntrega.setText("");
                cbxCurso.setSelectedIndex(0);
                cbxCoorientador.setSelected(false);
                
                btnSalvar.setEnabled(true);
                btnExcluir.setEnabled(false);
                btnEditar.setEnabled(false);
            }
        }
        else{
            txtRegistro.setText("Ultimo Num"); // só pra ter certaza que o ultimo número estará setado.
            txtRegistro.setEditable(true);
            txtAutor.setEnabled(true);
            txtTitulo.setEnabled(true);
            txtOrientador.setEnabled(true);
            
            // aqui vai ter que fazer um esquema com o banco para ver se tem um cadastro de coorientado. Caso tenha setSelected(true), caso não setSelected(false).
            if(cbxCoorientador.isSelected()){
                txtCoorientador.setEnabled(true);
            }
            else{
                txtCoorientador.setEnabled(false);
            }
            
            txtApresentacao.setEnabled(true);
            txtEntrega.setEnabled(true);
            cbxCurso.setEnabled(true);
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Excluir
        int res = JOptionPane.showConfirmDialog(null,"Você realmente deseja excluir este cadastro?", "Excluir Cadastro", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION){
                
                txtRegistro.setText("Ultimo Num");
                txtAutor.setText("");
                txtTitulo.setText("");
                txtOrientador.setText("");
                txtCoorientador.setText("");
                txtApresentacao.setText("");
                txtEntrega.setText("");
                cbxCurso.setSelectedIndex(0);
                cbxCoorientador.setSelected(false);
                
                txtRegistro.setEnabled(false);
                txtAutor.setEnabled(false);
                txtTitulo.setEnabled(false);
                txtOrientador.setEnabled(false);
                txtCoorientador.setEnabled(false);
                txtApresentacao.setEnabled(false);
                txtEntrega.setEnabled(false);
                cbxCurso.setEnabled(false);
                cbxCoorientador.setEnabled(false);
                
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
                btnEditar.setEnabled(false);
            }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbxCoorientadorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbxCoorientadorStateChanged
        if(cbxCoorientador.isSelected()){
            txtCoorientador.setEnabled(true);
        }
        else{
            txtCoorientador.setEnabled(false);
        }
    }//GEN-LAST:event_cbxCoorientadorStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbxCoorientador;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxCursoBusca;
    private javax.swing.JComboBox<String> cbxTipoBusca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApresentacao;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblCursoBusca;
    private javax.swing.JLabel lblEntrega;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblFrameTitulo;
    private javax.swing.JLabel lblOrientador;
    private javax.swing.JLabel lblOrientador1;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JTable tblTCC;
    private javax.swing.JFormattedTextField txtApresentacao;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCoorientador;
    private javax.swing.JFormattedTextField txtEntrega;
    private javax.swing.JTextField txtOrientador;
    private javax.swing.JTextField txtRegistro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
