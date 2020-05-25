/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.DAOAbstract;
import java.awt.Container;
import java.awt.event.FocusEvent;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Marcos
 */
public class JPanelBotoesCrud extends JPanel {

    boolean inclusao;
    private DAOAbstract daoAbstract;
    private Object beanTabela;
    private JComponent objRecebeFoco;
    private BeanComponentesTela beanTela;

    public BeanComponentesTela getBeanTela() {
        return beanTela;
    }

    public void setBeanTela(BeanComponentesTela beanTela) {
        this.beanTela = beanTela;
    }

    /*
    colocar o dao para esta classe e terminar o confirmar e excluir e pesquisar
    pode declarar uma classe abstrata ou usar o dao_abstrct
     */
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnPesquisar;

    /**
     * @return the beanTabela
     */
    public Object getBeanTabela() {
        return beanTabela;
    }

    /**
     * @param beanTabela the beanTabela to set
     */
    public void setBeanTabela(Object beanTabela) {
        this.beanTabela = beanTabela;
    }

    /**
     * @param objRecebeFoco the objRecebeFoco to set
     */
    public void setObjRecebeFoco(JComponent objRecebeFoco) {
        this.objRecebeFoco = objRecebeFoco;
    }

    
    private void criarBotoesCrud() {

        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnIncluir.setText("Incluir");
        jBtnIncluir.setSize(115, 40);
        jBtnIncluir.setLocation(10, 10);

        if ((getClass().getResource("/imagens/incluir.png")) != null) {
            jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png")));
        }

        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclusao = true;
                jBtnConfirmar.setEnabled(true);
                jBtnCancelar.setEnabled(true);
                jBtnIncluir.setEnabled(false);
                jBtnAlterar.setEnabled(false);
                jBtnExcluir.setEnabled(false);
                objRecebeFoco.grabFocus();
            }
        }
        );
        add(jBtnIncluir);

        //jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.setSize(115, 40);
        jBtnAlterar.setLocation(130, 10);
        if ((getClass().getResource("/imagens/alterar.png")) != null) {
            jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png")));
        }
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (getBeanTabela() != null) {
                    inclusao = false;
                    jBtnConfirmar.setEnabled(true);
                    jBtnCancelar.setEnabled(true);
                    jBtnIncluir.setEnabled(false);
                    jBtnAlterar.setEnabled(false);
                    jBtnExcluir.setEnabled(false);
                    objRecebeFoco.grabFocus();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Nenhum grupo está disponível para alteração");
                }
            }
        });
        add(jBtnAlterar);

        //jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.setSize(115, 40);
        jBtnExcluir.setLocation(250, 10);
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (getBeanTabela() != null) {
                    int resp = javax.swing.JOptionPane.showConfirmDialog(null, "Confirma Exclusão?", "Exclusao", javax.swing.JOptionPane.YES_NO_OPTION);
                    if (resp == javax.swing.JOptionPane.YES_OPTION) {
                        getDaoAbstract().delete(getBeanTabela());
                        //Util.limpar();
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Nenhum grupo está disponível para alteração");
                }

            }
        });
        add(jBtnExcluir);

        //jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.setEnabled(false);
        jBtnConfirmar.setSize(115, 40);
        jBtnConfirmar.setLocation(370, 10);
        jBtnConfirmar.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                javax.swing.JOptionPane.showMessageDialog(null, "ganhou foco");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (inclusao) {
                    getDaoAbstract().insert(getBeanTela());
                    //inclusao = false;
                } else {
                    getDaoAbstract().update(getBeanTela());
                }
                jBtnConfirmar.setEnabled(false);
                jBtnCancelar.setEnabled(false);
                jBtnIncluir.setEnabled(true);
                jBtnAlterar.setEnabled(true);
                jBtnExcluir.setEnabled(true);
                //Util.limpar();
                setBeanTabela(null);
            }
        });
        add(jBtnConfirmar);

        //jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setSize(115, 40);
        jBtnCancelar.setLocation(490, 10);
        jBtnCancelar.setEnabled(false);
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmar.setEnabled(false);
                jBtnCancelar.setEnabled(false);
                jBtnIncluir.setEnabled(true);
                jBtnAlterar.setEnabled(true);
                jBtnExcluir.setEnabled(true);
                //Util.limpar();
                setBeanTabela(null);

            }
        });
        add(jBtnCancelar);

        //jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.setSize(115, 40);
        jBtnPesquisar.setLocation(610, 10);
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jBtnPesquisarActionPerformed(evt);
                //grupo = new Grupo();
                JDlgPesquisa jDlgPesquisa = new JDlgPesquisa(null, true);
                //jDlgPesquisa.setTelaPai(this);
                jDlgPesquisa.setModelo(getDaoAbstract(), getBeanTabela());
                jDlgPesquisa.setVisible(true);
            }
        });
        add(jBtnPesquisar);
    }

    public JPanelBotoesCrud() {
        super();

        criarBotoesCrud();
    }

    public JPanelBotoesCrud(javax.swing.JFrame container) {
        super();
        criarBotoesCrud();
    }

    /**
     * @return the daoAbstract
     */
    public DAOAbstract getDaoAbstract() {
        return daoAbstract;
    }

    /**
     * @param daoAbstract the daoAbstract to set
     */
    public void setDaoAbstract(DAOAbstract daoAbstract) {
        this.daoAbstract = daoAbstract;
    }
     
}
