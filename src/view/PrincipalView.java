package view;

import Dao.CadtccD;
import Dao.Conexao;
import Dao.CursoD;
import Dao.LogD;
import Dao.UsuarioD;
import Model.CadtccM;
import Model.CursoM;
import Model.LogM;
import Model.UsuarioM;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.File;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class PrincipalView extends javax.swing.JFrame {
    
    CadtccM cadtcc = new CadtccM();
    CadtccD cadtccdao = new CadtccD();
    List<CadtccM> listaCadtcc = new ArrayList<>();
    
    CursoM curso = new CursoM();
    CursoD cursodao = new CursoD();
    List<CursoM> listaCurso = new ArrayList<>();
    
    LogM log = new LogM();
    LogD logdao = new LogD();
    
    UsuarioM usuariologado = new UsuarioM();
    
    List<UsuarioM> listaUsuario = new ArrayList<>();
    UsuarioD usuarioDAO = new UsuarioD();
    UsuarioM usuarioM = new UsuarioM();
    String caminho;

    public PrincipalView(UsuarioM usuario) throws SQLException {
        initComponents();
        this.setVisible(true);
        txtIdUsuario.setVisible(false);
        txtIdCurso.setVisible(false);
        atualizaTabelaCad();
        atualizaBoxCurso();
        atualizaBoxCursobusca();
        atualizaTabelaUsuario();
        atualizaTabelaCurso();
        dlgUsuario.setLocationRelativeTo(null);
        dlgCurso.setLocationRelativeTo(null);
        txtAutor.setText("");
        txtTitulo.setText("");
        txtOrientador.setText("");
        txtCoorientador.setText("");
        cbxCurso.setSelectedIndex(0);
        txtRegistro.setText("");
        txtEntrega.setText("");
        txtApresentacao.setText("");
        txtId.setVisible(false);
        
        btnSalvar.setUI(new BasicButtonUI());
        btnExcluir.setUI(new BasicButtonUI());
        btnEditar.setUI(new BasicButtonUI());
        btnSubir.setUI(new BasicButtonUI());
        btnCadastro.setUI(new BasicButtonUI());
        btnUsuarios.setUI(new BasicButtonUI());
        btnCursos.setUI(new BasicButtonUI());
        btnSalvarUsuario.setUI(new BasicButtonUI());
              
        btnSalvarCurso.setUI(new BasicButtonUI());
        //lstCursos.setUI(new BasicListUI());
        
        
        if(usuario.getAdmin() == true){
            // btn true
            usuariologado = usuario;
            
        }else if(usuario.getAdmin() == false){
            // btn false
            usuariologado = usuario;
            btnUsuarios.setVisible(false);
            btnCursos.setVisible(false);
        }
        
          
    }
   
        public void atualizaTabelaCad(){
        cadtcc = new CadtccM();
        try {
            listaCadtcc = cadtccdao.listaTodos();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        
        String dados[][] = new String[listaCadtcc.size()][4];
            int i = 0;
            for (CadtccM cad : listaCadtcc) {
                dados[i][0] = String.valueOf(cad.getId());
                dados[i][1] = cad.getAutor();
                dados[i][2] = cad.getTitulo();
                dados[i][3] = cad.getIdCurso().getNome();

                i++;
            }
            String tituloColuna[] = {"ID", "Autor", "Trabalho", "Curso",};
            DefaultTableModel tabelacad = new DefaultTableModel();
            tabelacad.setDataVector(dados, tituloColuna);
            tblTCC.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblTCC.getColumnModel().getColumn(0).setMaxWidth(0);
            tblTCC.getColumnModel().getColumn(0).setMinWidth(0);
            tblTCC.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblTCC.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblTCC.getColumnModel().getColumn(2).setPreferredWidth(200);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblTCC.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblTCC.setRowHeight(35);
            tblTCC.updateUI();
    }
    
          public void atualizaTabelaCadBusca(){
            cadtcc = new CadtccM();

            String dados[][] = new String[listaCadtcc.size()][4];
            int i = 0;
            for (CadtccM cad : listaCadtcc) {
                dados[i][0] = String.valueOf(cad.getId());
                dados[i][1] = cad.getAutor();
                dados[i][2] = cad.getTitulo();
                dados[i][3] = cad.getIdCurso().getNome();

                i++;
            }
            String tituloColuna[] = {"ID", "Autor", "Trabalho", "Curso",};
            DefaultTableModel tabelacad = new DefaultTableModel();
            tabelacad.setDataVector(dados, tituloColuna);
            tblTCC.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblTCC.getColumnModel().getColumn(0).setMaxWidth(0);
            tblTCC.getColumnModel().getColumn(0).setMinWidth(0);
            tblTCC.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblTCC.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblTCC.getColumnModel().getColumn(2).setPreferredWidth(200);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblTCC.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblTCC.setRowHeight(35);
            tblTCC.updateUI();
    }
          
        public void atualizaTabelaUsuario() throws SQLException{
            usuarioM = new UsuarioM();
        try {
            listaUsuario = usuarioDAO.listaTodos();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        
        String dados[][] = new String[listaUsuario.size()][2];
            int i = 0;
            for (UsuarioM usu : listaUsuario) {
                dados[i][0] = String.valueOf(usu.getId());
                dados[i][1] = usu.getNome();

                i++;
            }
            String tituloColuna[] = {"ID", "Nome"};
            DefaultTableModel tabelausu = new DefaultTableModel();
            tabelausu.setDataVector(dados, tituloColuna);
            tblUsuarios.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
            tblUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
            tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(100);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblUsuarios.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblUsuarios.setRowHeight(35);
            tblUsuarios.updateUI();
        }
        
        
            public void atualizaTabelaCurso() throws SQLException{
            curso = new CursoM();
        try {
            listaCurso = cursodao.ListaCurso();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        
        String dados[][] = new String[listaCurso.size()][2];
            int i = 0;
            for (CursoM cur : listaCurso) {
                dados[i][0] = String.valueOf(cur.getId());
                dados[i][1] = cur.getNome();

                i++;
            }
            String tituloColuna[] = {"ID", "Cursos"};
            DefaultTableModel tabelacur = new DefaultTableModel();
            tabelacur.setDataVector(dados, tituloColuna);
           tblCursos.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblCursos.getColumnModel().getColumn(0).setMaxWidth(0);
            tblCursos.getColumnModel().getColumn(0).setMinWidth(0);
            tblCursos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblCursos.getColumnModel().getColumn(1).setPreferredWidth(100);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblCursos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblCursos.setRowHeight(35);
            tblCursos.updateUI();
        }
    
    public void atualizaBoxCurso(){
        cbxCurso.removeAllItems();
        cbxCurso.addItem("Selecione");
        try {
            listaCurso = cursodao.ListaCurso();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[listaCurso.size()][5];
        for (CursoM curs : listaCurso) {
            cbxCurso.addItem(curs.getNome());
        }
    } 
    public void atualizaBoxCursobusca(){
        cbxCursoBusca.removeAllItems();
        cbxCursoBusca.addItem("Todos");
        try {
            listaCurso = cursodao.ListaCurso();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[listaCurso.size()][5];
        for (CursoM curs : listaCurso) {
            cbxCursoBusca.addItem(curs.getNome());
        }
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgUsuario = new javax.swing.JDialog();
        pnlTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlUsuarios = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        pnlNovoUsuario = new javax.swing.JPanel();
        lblMASP = new javax.swing.JLabel();
        txtMasp = new javax.swing.JTextField();
        lblNomeUsuario = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSenhaUsuario = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnSalvarUsuario = new javax.swing.JButton();
        ckb_Inativo = new javax.swing.JCheckBox();
        lblConfirmarSenhaUsuario = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JPasswordField();
        txtIdUsuario = new javax.swing.JTextField();
        dlgCurso = new javax.swing.JDialog();
        pnlTitulo1 = new javax.swing.JPanel();
        lblTituloCurso = new javax.swing.JLabel();
        pnlUsuarios1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        pnlNovoUsuario1 = new javax.swing.JPanel();
        lblNomeCurso = new javax.swing.JLabel();
        txtNomeCurso = new javax.swing.JTextField();
        btnSalvarCurso = new javax.swing.JButton();
        txtIdCurso = new javax.swing.JTextField();
        pnlUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnCursos = new javax.swing.JButton();
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
        btnSubir = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();

        dlgUsuario.setTitle("Usuários");
        dlgUsuario.setMinimumSize(new java.awt.Dimension(760, 493));
        dlgUsuario.setResizable(false);
        dlgUsuario.setSize(new java.awt.Dimension(760, 493));
        dlgUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dlgUsuarioMouseClicked(evt);
            }
        });
        dlgUsuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitulo.setBackground(new java.awt.Color(244, 240, 130));
        pnlTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 72, 27));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuários");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        pnlTitulo.add(jLabel1);

        dlgUsuario.getContentPane().add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 60));

        pnlUsuarios.setBackground(new java.awt.Color(253, 253, 253));
        pnlUsuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(238, 238, 238)));
        pnlUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 31, 40));
        jLabel2.setText("Usuários do Sistema");
        jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(238, 238, 238)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        pnlUsuarios.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblUsuarios);

        pnlUsuarios.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, 350));

        dlgUsuario.getContentPane().add(pnlUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 400));

        pnlNovoUsuario.setBackground(new java.awt.Color(251, 251, 251));
        pnlNovoUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMASP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMASP.setForeground(new java.awt.Color(29, 31, 40));
        lblMASP.setText("MASP");
        pnlNovoUsuario.add(lblMASP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        txtMasp.setBackground(new java.awt.Color(251, 251, 251));
        txtMasp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMasp.setToolTipText("Precione ENTER para buscar.");
        txtMasp.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10)));
        txtMasp.setOpaque(false);
        pnlNovoUsuario.add(txtMasp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 130, 30));

        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(29, 31, 40));
        lblNomeUsuario.setText("Nome");
        pnlNovoUsuario.add(lblNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtNome.setBackground(new java.awt.Color(251, 251, 251));
        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNome.setToolTipText("Precione ENTER para buscar.");
        txtNome.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10)));
        txtNome.setOpaque(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        pnlNovoUsuario.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 390, 30));

        lblSenhaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenhaUsuario.setForeground(new java.awt.Color(29, 31, 40));
        lblSenhaUsuario.setText("Senha");
        pnlNovoUsuario.add(lblSenhaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        txtSenha.setBackground(new java.awt.Color(251, 251, 251));
        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(29, 31, 40));
        txtSenha.setToolTipText("Digite sua senha");
        txtSenha.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10)));
        pnlNovoUsuario.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 210, 30));

        btnSalvarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvarUsuario.setForeground(new java.awt.Color(29, 31, 40));
        btnSalvarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-save-2-16.png"))); // NOI18N
        btnSalvarUsuario.setText("Salvar");
        btnSalvarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuarioActionPerformed(evt);
            }
        });
        pnlNovoUsuario.add(btnSalvarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 140, 40));

        ckb_Inativo.setBackground(new java.awt.Color(251, 251, 251));
        ckb_Inativo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ckb_Inativo.setForeground(new java.awt.Color(29, 31, 40));
        ckb_Inativo.setText("Inativo");
        pnlNovoUsuario.add(ckb_Inativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        lblConfirmarSenhaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblConfirmarSenhaUsuario.setForeground(new java.awt.Color(29, 31, 40));
        lblConfirmarSenhaUsuario.setText("Confirmar Senha");
        pnlNovoUsuario.add(lblConfirmarSenhaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        txtConfirmarSenha.setBackground(new java.awt.Color(251, 251, 251));
        txtConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtConfirmarSenha.setForeground(new java.awt.Color(29, 31, 40));
        txtConfirmarSenha.setToolTipText("Digite sua senha");
        txtConfirmarSenha.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10)));
        pnlNovoUsuario.add(txtConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 210, 30));
        pnlNovoUsuario.add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 60, -1));

        dlgUsuario.getContentPane().add(pnlNovoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 490, 400));

        dlgCurso.setTitle("Usuários");
        dlgCurso.setMinimumSize(new java.awt.Dimension(760, 493));
        dlgCurso.setResizable(false);
        dlgCurso.setSize(new java.awt.Dimension(760, 493));
        dlgCurso.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitulo1.setBackground(new java.awt.Color(244, 240, 130));
        pnlTitulo1.setLayout(new java.awt.GridLayout(1, 0));

        lblTituloCurso.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblTituloCurso.setForeground(new java.awt.Color(74, 72, 27));
        lblTituloCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloCurso.setText("Cursos");
        pnlTitulo1.add(lblTituloCurso);

        dlgCurso.getContentPane().add(pnlTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 60));

        pnlUsuarios1.setBackground(new java.awt.Color(253, 253, 253));
        pnlUsuarios1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(238, 238, 238)));
        pnlUsuarios1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 31, 40));
        jLabel4.setText("Cursos no Sistema");
        jLabel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(238, 238, 238)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        pnlUsuarios1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCursosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCursos);

        pnlUsuarios1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, 350));

        dlgCurso.getContentPane().add(pnlUsuarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 400));

        pnlNovoUsuario1.setBackground(new java.awt.Color(251, 251, 251));
        pnlNovoUsuario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomeCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomeCurso.setForeground(new java.awt.Color(29, 31, 40));
        lblNomeCurso.setText("Nome");
        pnlNovoUsuario1.add(lblNomeCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        txtNomeCurso.setBackground(new java.awt.Color(251, 251, 251));
        txtNomeCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomeCurso.setToolTipText("Precione ENTER para buscar.");
        txtNomeCurso.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10)));
        txtNomeCurso.setOpaque(false);
        pnlNovoUsuario1.add(txtNomeCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 390, 30));

        btnSalvarCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvarCurso.setForeground(new java.awt.Color(29, 31, 40));
        btnSalvarCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-save-2-16.png"))); // NOI18N
        btnSalvarCurso.setText("Salvar");
        btnSalvarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCursoActionPerformed(evt);
            }
        });
        pnlNovoUsuario1.add(btnSalvarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 140, 40));
        pnlNovoUsuario1.add(txtIdCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 60, -1));

        dlgCurso.getContentPane().add(pnlNovoUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 490, 400));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro TCC");
        setMaximumSize(new java.awt.Dimension(1090, 746));
        setMinimumSize(new java.awt.Dimension(1090, 746));
        setPreferredSize(new java.awt.Dimension(1090, 746));
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

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/btnUsuarios.png"))); // NOI18N
        btnUsuarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUsuarios.setOpaque(false);
        btnUsuarios.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/btnUsuariosPress.png"))); // NOI18N
        btnUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/btnUsuariosOver.png"))); // NOI18N
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        pnlUsuario.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 170, 60));

        btnCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/btnCursos.png"))); // NOI18N
        btnCursos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCursos.setOpaque(false);
        btnCursos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/btnCursosPress.png"))); // NOI18N
        btnCursos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/btnCursosOver.png"))); // NOI18N
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });
        pnlUsuario.add(btnCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 160, 60));

        getContentPane().add(pnlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 60));

        pnlFrame.setMaximumSize(new java.awt.Dimension(760, 500));
        pnlFrame.setMinimumSize(new java.awt.Dimension(760, 500));
        pnlFrame.setPreferredSize(new java.awt.Dimension(760, 500));

        pnlTabela.setBackground(new java.awt.Color(250, 250, 250));
        pnlTabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));

        tblTCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTCC.setForeground(new java.awt.Color(29, 31, 40));
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
        tblTCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTCC);

        cbxTipoBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxTipoBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autor", "Título", "Registro", "Apresentação", "Entrega" }));
        cbxTipoBusca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoBuscaItemStateChanged(evt);
            }
        });

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFiltro.setForeground(new java.awt.Color(29, 31, 40));
        lblFiltro.setText("Filtro");

        lblBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBusca.setForeground(new java.awt.Color(29, 31, 40));
        lblBusca.setText("Busca");

        txtBusca.setBackground(new java.awt.Color(250, 250, 250));
        txtBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBusca.setToolTipText("Precione ENTER para buscar.");
        txtBusca.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 110, 143)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10)));
        txtBusca.setOpaque(false);
        txtBusca.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscaCaretUpdate(evt);
            }
        });

        lblCursoBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCursoBusca.setForeground(new java.awt.Color(29, 31, 40));
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
        cbxCurso.setEnabled(false);

        lblApresentacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApresentacao.setForeground(new java.awt.Color(29, 31, 40));
        lblApresentacao.setText("Apresentação");

        txtApresentacao.setBackground(new java.awt.Color(248, 248, 248));
        txtApresentacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 213, 213)));
        txtApresentacao.setForeground(new java.awt.Color(29, 31, 40));
        try {
            txtApresentacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtApresentacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApresentacao.setToolTipText("Data em que o TCC foi defendido.");
        txtApresentacao.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtApresentacao.setEnabled(false);
        txtApresentacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEntrega.setBackground(new java.awt.Color(248, 248, 248));
        txtEntrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 213, 213)));
        txtEntrega.setForeground(new java.awt.Color(29, 31, 40));
        try {
            txtEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEntrega.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEntrega.setToolTipText("Data em que o TCC foi entregue na biblioteca.");
        txtEntrega.setDisabledTextColor(new java.awt.Color(47, 50, 65));
        txtEntrega.setEnabled(false);
        txtEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEntrega.setForeground(new java.awt.Color(29, 31, 40));
        lblEntrega.setText("Entrega");

        lblFrameTitulo.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblFrameTitulo.setForeground(new java.awt.Color(29, 31, 40));
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

        btnSubir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSubir.setForeground(new java.awt.Color(29, 31, 40));
        btnSubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iconmonstr-upload-5-16.png"))); // NOI18N
        btnSubir.setText("Enviar TCC");
        btnSubir.setEnabled(false);
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });

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
                                    .addComponent(lblOrientador)
                                    .addComponent(lblOrientador1)
                                    .addComponent(txtCoorientador)
                                    .addComponent(txtOrientador)
                                    .addGroup(pnlDadosLayout.createSequentialGroup()
                                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblCurso)
                                            .addComponent(cbxCurso, 0, 158, Short.MAX_VALUE)
                                            .addComponent(btnSubir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(48, 48, 48)
                                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApresentacao)
                                            .addComponent(txtApresentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        txtId.setEnabled(false);

        javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
        pnlFrame.setLayout(pnlFrameLayout);
        pnlFrameLayout.setHorizontalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addComponent(pnlDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlFrameLayout.setVerticalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addComponent(pnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            cbxCurso.setEnabled(true);
            
            if(cbxCoorientador.isSelected()){
                txtCoorientador.setEnabled(true);
            }
            else{
                txtCoorientador.setEnabled(false);
                txtCoorientador.setText("");
            }
            
            btnSalvar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnSubir.setEnabled(true);
            btnEditar.setEnabled(false);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadtcc = new CadtccM();
        curso = new CursoM();
        log = new LogM();

        String name = txtAutor.getText();
        if(name.charAt(name.length()-1) != ' '){
            
        String NomeCompleto = txtAutor.getText();
        String PrimeiroNome, UltimoNome;
        int cont1 = 0, i, cont2 = 0;
        for( i = 0; i < NomeCompleto.length(); i++){
            if(NomeCompleto.charAt(i) == ' '){
                cont1++;
                
                cont2 = i;
 
            }
        }
        PrimeiroNome = NomeCompleto.substring(0, cont2);
        UltimoNome = NomeCompleto.substring(cont2+1, NomeCompleto.length());
        UltimoNome = UltimoNome.toUpperCase();
        try {
            curso = cursodao.buscaNome(cbxCurso.getSelectedItem().toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Curso não encontrado", "erro", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

            if((!txtAutor.getText().isEmpty()) || (!txtOrientador.getText().isEmpty()) ){

                if(cbxCoorientador.isSelected()== true && txtCoorientador.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Preencha o Nome do Coordenador", "erro", JOptionPane.WARNING_MESSAGE);

                }else if(txtId.getText().isEmpty()){
                    // salvar
                    cadtcc.setAutor(UltimoNome+", "+PrimeiroNome);
                    cadtcc.setTitulo(txtTitulo.getText());
                    cadtcc.setOrientador(txtOrientador.getText());
                    cadtcc.setCoorientador(txtCoorientador.getText());
                    cadtcc.setIdCurso(curso);
                    cadtcc.setRegistro(txtRegistro.getText());
                    cadtcc.setDataEntrega(txtEntrega.getText());
                    cadtcc.setDataApresentacao(txtApresentacao.getText());
                    //cadtcc.set titulo do projeto;

                    // log
                    log.setAcao("Salvando TCC");
                    log.setIdUsuario(usuariologado);
                    log.setHora(new SimpleDateFormat("HH:MM").format(new Date(System.currentTimeMillis())));
                    log.setData(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
                    log.setTituloTrabalho(txtTitulo.getText());



                    try {
                        cadtccdao.salvar(cadtcc);
                        logdao.Salvar(log);
                        JOptionPane.showMessageDialog(null, "Gravado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabelaCad();
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
                    }
                    limparcampos();
                }else{
                    cadtcc.setId(Integer.valueOf(txtId.getText()));
                    cadtcc.setAutor(txtNome.getText());
                    cadtcc.setTitulo(txtTitulo.getText());
                    cadtcc.setOrientador(txtOrientador.getText());
                    cadtcc.setCoorientador(txtCoorientador.getText());
                    cadtcc.setIdCurso(curso);
                    cadtcc.setRegistro(txtRegistro.getText());
                    cadtcc.setDataEntrega(txtEntrega.getText());
                    cadtcc.setDataApresentacao(txtApresentacao.getText());

                    log.setAcao("Alterando TCC");
                    log.setIdUsuario(usuariologado);
                    log.setHora(new SimpleDateFormat("HH:MM").format(new Date(System.currentTimeMillis())));
                    log.setData(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
                    log.setTituloTrabalho(txtTitulo.getText());

                    try {
                        cadtccdao.alterar(cadtcc);
                        logdao.Salvar(log);
                        JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabelaCad();
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
                    }
                    limparcampos();
                }
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
                btnSubir.setEnabled(false);
                btnEditar.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Existem campos não preenchidos.");
            }
        }   
        else{
            JOptionPane.showMessageDialog( null, "Remova o espaço depois do seu ultimo nome!");
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
                
                try {
                    cadtcc = cadtccdao.buscaUltimoRegistro();
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(cadtcc == null){
                    txtRegistro.setText("1");
                }else{
                    txtRegistro.setText(cadtcc.getRegistro());
                }
                
                txtAutor.setText("");
                txtTitulo.setText("");
                txtOrientador.setText("");
                txtCoorientador.setText("");
                txtApresentacao.setValue("");
                txtEntrega.setValue("");
                cbxCurso.setSelectedIndex(0);
                cbxCoorientador.setEnabled(true);
                cbxCoorientador.setSelected(false);
                
                btnSalvar.setEnabled(true);
                btnSubir.setEnabled(true);
                btnExcluir.setEnabled(false);
                btnEditar.setEnabled(false);
            }
        }else{
            txtRegistro.setEnabled(true);
            txtAutor.setEnabled(true);
            txtTitulo.setEnabled(true);
            txtOrientador.setEnabled(true);
            cbxCoorientador.setEnabled(true);
            cbxCoorientador.setSelected(false);
            
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
            try {
                    cadtcc = cadtccdao.buscaUltimoRegistro();
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(cadtcc == null){
                    txtRegistro.setText("1");
                }else{
                    txtRegistro.setText(cadtcc.getRegistro());
                }
                
                txtAutor.setText("");
                txtTitulo.setText("");
                txtOrientador.setText("");
                txtCoorientador.setText("");
                txtApresentacao.setValue("");
                txtEntrega.setValue("");
                cbxCurso.setSelectedIndex(0);
                cbxCoorientador.setEnabled(true);
                cbxCoorientador.setSelected(false);
                
                btnSalvar.setEnabled(true);
                btnSubir.setEnabled(true);
                btnExcluir.setEnabled(false);
                btnEditar.setEnabled(false);
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Excluir
        int res = JOptionPane.showConfirmDialog(null,"Você realmente deseja excluir este cadastro?", "Excluir Cadastro", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION){
                
                cadtcc.setId(Integer.valueOf(txtId.getText()));
            try {
                cadtccdao.excluir(cadtcc);
                log.setAcao("Excluindo TCC");
                log.setIdUsuario(usuariologado);
                log.setHora(new SimpleDateFormat("HH:MM").format(new Date(System.currentTimeMillis())));
                log.setData(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
                log.setTituloTrabalho(txtTitulo.getText());
                logdao.Salvar(log);
                atualizaTabelaCad();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
                txtRegistro.setText("");
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
                btnSubir.setEnabled(false);
                btnEditar.setEnabled(false);
            }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbxCoorientadorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbxCoorientadorStateChanged
        if(cbxCoorientador.isSelected()){
            txtCoorientador.setEnabled(true);
        }
        else{
            txtCoorientador.setEnabled(false);
            txtCoorientador.setText("");
        }
    }//GEN-LAST:event_cbxCoorientadorStateChanged

    private void txtBuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscaCaretUpdate
        listaCadtcc = null;
        if(txtBusca.getText().equals("")){
            atualizaTabelaCad();
        }else{
                    
            try {
                listaCadtcc = cadtccdao.listaAutor(txtBusca.getText(), cbxCursoBusca.getSelectedItem().toString(), cbxTipoBusca.getSelectedItem().toString());

                if(listaCadtcc == null){
                    JOptionPane.showMessageDialog(null, "Nenhum dado encontrado!","", JOptionPane.WARNING_MESSAGE);
                    atualizaTabelaCad();
                }else{
                    atualizaTabelaCadBusca();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtBuscaCaretUpdate

    private void cbxTipoBuscaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoBuscaItemStateChanged
        txtBusca.setText("");
    }//GEN-LAST:event_cbxTipoBuscaItemStateChanged

    private void tblTCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTCCMouseClicked
        limparcampos();
        cadtcc = new CadtccM();
        txtId.setText(tblTCC.getValueAt(tblTCC.getSelectedRow(),0).toString());
        int idBusca = Integer.valueOf(txtId.getText());
        
        try {
            cadtcc = cadtccdao.buscaId(idBusca);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        
        tblTCC.getTableHeader().setReorderingAllowed(false);
        txtApresentacao.setText(cadtcc.getDataApresentacao());
        txtAutor.setText(cadtcc.getAutor());
        txtCoorientador.setText(cadtcc.getCoorientador());
        txtEntrega.setText(cadtcc.getDataEntrega());
        txtId.setText(String.valueOf(cadtcc.getId()));
        txtRegistro.setText(cadtcc.getRegistro());
        txtTitulo.setText(cadtcc.getTitulo());
        cbxCurso.setSelectedIndex(cadtcc.getIdCurso().getId());
        //(cadtcc.getTrabalho());
        
        if (!(cadtcc.getCoorientador() == null)) {
            cbxCoorientador.setSelected(true);
            txtOrientador.setText(cadtcc.getCoorientador());
        }else{
            cbxCoorientador.setSelected(false);
            txtCoorientador.setText("");
        }
        
        btnEditar.setEnabled(true);
        btnSubir.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(false);
        
        txtApresentacao.setEnabled(false);
        txtAutor.setEnabled(false);
        txtCoorientador.setEnabled(false);
        txtEntrega.setEnabled(false);
        txtId.setEnabled(false);
        txtRegistro.setEnabled(false);
        txtTitulo.setEnabled(false);
        txtOrientador.setEnabled(false);
        txtCoorientador.setEnabled(false);
        cbxCurso.setEnabled(false);
        cbxCoorientador.setEnabled(false);
        
    }//GEN-LAST:event_tblTCCMouseClicked

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // Chama a jDialog Usuarios
        
        dlgUsuario.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        // Chama a jDialog Cursos
        
        dlgCurso.setVisible(true);
    }//GEN-LAST:event_btnCursosActionPerformed

    private void btnSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuarioActionPerformed
                
        if(txtNome.getText().isEmpty() || txtMasp.getText().isEmpty() || txtSenha.getText().isEmpty() || txtConfirmarSenha.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Prencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
        } else if (txtIdUsuario.getText().isEmpty()){
            if(txtSenha.getText().equals(txtConfirmarSenha.getText())){
                 
                usuarioM = new UsuarioM();
                usuarioM.setNome(txtNome.getText());
                usuarioM.setMasp(txtMasp.getText());
                usuarioM.setSenha(txtSenha.getText());
                usuarioM.setAdmin(false);
                usuarioM.setInativo(ckb_Inativo.isSelected());
                try {
                    UsuarioD.salvar(usuarioM);
                    JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                    atualizaTabelaUsuario();
                    txtNome.setText("");
                    txtMasp.setText("");
                    txtSenha.setText("");
                    txtConfirmarSenha.setText("");
                    txtNome.requestFocusInWindow();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
                 if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Usuario ou MASP já existentes.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "Senhas não coincidem.", "Erro", JOptionPane.WARNING_MESSAGE);                 
            }
        }    
        
        else{ if(txtSenha.getText().equals(txtConfirmarSenha.getText())){
                usuarioM = new UsuarioM();
                usuarioM.setId(Integer.parseInt(txtIdUsuario.getText()));
                usuarioM.setNome(txtNome.getText());
                usuarioM.setMasp(txtMasp.getText());
                usuarioM.setSenha(txtSenha.getText());
                usuarioM.setAdmin(false);
                usuarioM.setInativo(ckb_Inativo.isSelected());
                
                try {
                    UsuarioD.alterar(usuarioM);
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaUsuario();                
                    txtNome.setText("");
                    txtMasp.setText("");
                    txtSenha.setText("");
                    txtConfirmarSenha.setText("");
                    txtNome.requestFocusInWindow();
                    
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Usuario ou MASP já existentes.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
            }                
                }else{
                JOptionPane.showMessageDialog(null, "Senhas não coincidem.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
                    
    }
    }//GEN-LAST:event_btnSalvarUsuarioActionPerformed

      

 
    
    private void btnSalvarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCursoActionPerformed
        // Salva ou edita o curso
        if(txtNomeCurso.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Prencha o campo curso.", "Erro", JOptionPane.WARNING_MESSAGE);
          txtNomeCurso.requestFocusInWindow();
        } 
        else if(txtIdCurso.getText().isEmpty()){        
                curso = new CursoM();
                curso.setNome(txtNomeCurso.getText());
            try {

                cursodao.Salvar(curso);
                JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                atualizaTabelaCurso();
                atualizaBoxCursobusca();
                txtNomeCurso.setText("");
                txtNomeCurso.requestFocusInWindow();
                atualizaBoxCurso();
                atualizaBoxCursobusca();
              
                
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
             if (ex.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "Curso já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }  
        else{ 
                curso = new CursoM();
                curso.setId(Integer.parseInt(txtIdCurso.getText()));
                curso.setNome(txtNomeCurso.getText());
                
                
                try {
                    CursoD.alterar(curso);
                    JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaCurso(); 
                    atualizaBoxCursobusca();
                    txtNomeCurso.setText("");
                    txtNomeCurso.requestFocusInWindow();
                    
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Curso com nome já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
               }              
                
        }
    }//GEN-LAST:event_btnSalvarCursoActionPerformed

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        File pdf = null;
        JFileChooser chooser = null;
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo PDF", "pdf");

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(pdf);
        chooser.setSelectedFile(pdf);
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(false);


        int retorno = chooser.showOpenDialog(null);
        if (retorno==JFileChooser.APPROVE_OPTION){
            caminho = chooser.getSelectedFile().getAbsolutePath();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!\n\nLocal: "+chooser.getSelectedFile().getAbsolutePath()+"\n ");
        }
    }//GEN-LAST:event_btnSubirActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
  
    }//GEN-LAST:event_jLabel1MouseClicked

    private void dlgUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlgUsuarioMouseClicked
     
    }//GEN-LAST:event_dlgUsuarioMouseClicked

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
    
    }//GEN-LAST:event_txtNomeActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        usuarioM = new UsuarioM();
        
        txtIdUsuario.setText(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),0).toString());
        int idBusca = Integer.valueOf(txtIdUsuario.getText());
        
        try {
            usuarioM = usuarioDAO.BuscaPorId(idBusca);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        
        
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        txtIdUsuario.setText(Integer.toString(usuarioM.getId()));
        txtNome.setText(usuarioM.getNome());
        txtMasp.setText(usuarioM.getMasp());
        txtSenha.setText(usuarioM.getSenha());
        txtConfirmarSenha.setText(usuarioM.getSenha());
        
        
        
      
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void tblCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursosMouseClicked
    curso = new CursoM();
    
    txtIdCurso.setText(tblCursos.getValueAt(tblCursos.getSelectedRow(),0).toString());
        int idBusca = Integer.valueOf(txtIdCurso.getText());
        
        try {
            curso = cursodao.busca(idBusca);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        txtIdCurso.setText(Integer.toString(curso.getId()));
        txtNomeCurso.setText(curso.getNome());
        
    
    }//GEN-LAST:event_tblCursosMouseClicked

    public void limparcampos(){
    txtApresentacao.setValue("");
    txtAutor.setText("");
    txtBusca.setText("");
    txtCoorientador.setText("");
    txtEntrega.setValue("");
    txtId.setText("");
    txtOrientador.setText("");
    txtRegistro.setText("");
    txtTitulo.setText("");
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarCurso;
    private javax.swing.JButton btnSalvarUsuario;
    private javax.swing.JButton btnSubir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JCheckBox cbxCoorientador;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxCursoBusca;
    private javax.swing.JComboBox<String> cbxTipoBusca;
    private javax.swing.JCheckBox ckb_Inativo;
    private javax.swing.JDialog dlgCurso;
    private javax.swing.JDialog dlgUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblApresentacao;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblConfirmarSenhaUsuario;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblCursoBusca;
    private javax.swing.JLabel lblEntrega;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblFrameTitulo;
    private javax.swing.JLabel lblMASP;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblOrientador;
    private javax.swing.JLabel lblOrientador1;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblSenhaUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloCurso;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JPanel pnlNovoUsuario;
    private javax.swing.JPanel pnlNovoUsuario1;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlTitulo1;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JPanel pnlUsuarios;
    private javax.swing.JPanel pnlUsuarios1;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTable tblTCC;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JFormattedTextField txtApresentacao;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JTextField txtCoorientador;
    private javax.swing.JFormattedTextField txtEntrega;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCurso;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeCurso;
    private javax.swing.JTextField txtOrientador;
    private javax.swing.JTextField txtRegistro;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
