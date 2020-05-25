/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import hibernate.Investimentodiario;

/**
 *
 * @author Marcos
 */
public class PegarBeanTela implements BeanComponentesTela {
    JDlgInvestimento jJanelaPrincipal;
    
    @Override
    public Object getBeanTela() {
        investimentodiario = new Investimentodiario();
        investimentodiario.setPayout(Integer.parseInt( jJanelaPrincipal.jFtxtPayOut.getText()));
        if (jJanelaPrincipal.jRBtnCompra.isSelected()) {
        investimentodiario.setOperacao(0);
        } else {
            investimentodiario.setOperacao(1);
        }
        //investimentodiario.setParmoeda(jCboParMoeda.getSelectedIndex());
        return investimentodiario;
    }
    
}
