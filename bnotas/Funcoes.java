package bnotas;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author AndorinhaViril
 */
public class Funcoes {

    Bnotas bn;

    public void setBnotas(Bnotas b) {
        bn = b;
    }

    public boolean trocaCor() {
        Color color = null;
        color = JColorChooser.showDialog(bn, "Selecione uma cor", color);
        bn.getTexto().setForeground(color);
        return true;
    }

    public boolean trocaBackGround() {
        Color color = null;
        color = JColorChooser.showDialog(bn, "Selecione uma cor", color);
        bn.getTexto().setBackground(color);
        return true;
    }

    public void salvar() throws IOException {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retorno = file.showSaveDialog(bn);
        if (retorno != JFileChooser.APPROVE_OPTION) {
            return;
        }
        FileWriter arq = new FileWriter(file.getSelectedFile());
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf(bn.getTexto().getText());
        try {
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(bnotas.Bnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrir() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
        int retorno = file.showOpenDialog(bn);
        if (retorno != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            FileReader arq = new FileReader(file.getSelectedFile());
            BufferedReader lerArq = new BufferedReader(arq);
            String c = null;
            String linha = lerArq.readLine();
            while (linha != null) {
                if (c == null) {
                    c = linha + "\n";
                } else {
                    c += linha + "\n";
                }
                linha = lerArq.readLine();
            }
            System.out.println(c);
            bn.getTexto().setText(c);
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    // public void formatar(){}
    public void subst() {
        String a;
        String subs = JOptionPane.showInputDialog(bn, "digite o que você quer substituir:");
        String subst = JOptionPane.showInputDialog(bn, "digite o que você quer no lugar de: " + subs);
        if (!subs.equals("")) {
            a = bn.getTexto().getText();
            a = a.replace(subs, subst);
            bn.getTexto().setText(a);
        } else {
            a = bn.getTexto().getText();
            a += subst;
            bn.getTexto().setText(a);
        }
    }
}
