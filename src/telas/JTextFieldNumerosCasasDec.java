/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class JTextFieldNumerosCasasDec extends JTextField {

//public final class JtextFieldSomenteNumeros extends JTextField {
    private int maximoCaracteres = -1;// definição de -1 
// como  valor normal de um textfield sem limite de caracters
    private int casasDecimais = 2;

    public JTextFieldNumerosCasasDec() {
        super();
        setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    public JTextFieldNumerosCasasDec(int maximo) {
        super();
        setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        setMaximoCaracteres(maximo);// define o tamanho máximo
        //que deve ser aceito no jtextfield que foi recebido no  construtor

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    public JTextFieldNumerosCasasDec(int maximo, int casasDec) {
        super();
        setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        setMaximoCaracteres(maximo);// define o tamanho máximo
        setCasasDecimais(casasDec);
        //que deve ser aceito no jtextfield que foi recebido no  construtor

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {
        String caracteres = "0987654321,";// lista de caracters que não devem ser aceitos
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            // se o caracter que gerou o evento estiver não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento
        }
//        if (getText().length()>2) {            
//            setText(getText().substring(0, getText().length()-3) + "," + getText().substring(getText().length()-2,2) );
//        }
        if (",".contains(evt.getKeyChar() + "")) {
            //se tiver 2 virgulas não deixa digitar de novo
            if (getText().contains(",")) {// se o caracter que gerou o evento estiver não estiver na lista
                evt.consume();//aciona esse propriedade para eliminar a ação do evento
            }
        }
        if ("0987654321".contains(evt.getKeyChar() + "")) {
            if (getText().contains(",")) {
                String cad = getText().substring(getText().indexOf(","), getText().length());
                if (cad.length() > casasDecimais) {
                    evt.consume();
                }
            }
        }
        if ((getText().length() >= getMaximoCaracteres()) && (getMaximoCaracteres() != -1)) {
//if para saber se precisa verificar também o tamanho da string do campo
// maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
            evt.consume();
            setText(getText().substring(0, getMaximoCaracteres()));
// esta linha acima é para remover os caracters inválidos caso o usuário tenha copiado o 
//conteúdo de algum lugar, ou seja, com tamanho maior que o definido
        }//fim do if do tamanho da string do campo

    }

    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }

    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }

    public int getCasasDecimais() {
        return casasDecimais;
    }

    public void setCasasDecimais(int casasDecimais) {
        this.casasDecimais = casasDecimais;
    }
}
