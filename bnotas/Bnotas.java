package bnotas;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author AndorinhaViril
 */
public class Bnotas extends JFrame {

    private final JEditorPane texto = new JEditorPane();

    public JEditorPane getTexto() {
        return texto;
    }

    private final JScrollPane scroll = new JScrollPane(texto);

    private int teclaPressionada = -1;

    //private static Bnotas janelaAcess;
    public static Funcoes f = new Funcoes();

    Bnotas() {
        super("BNotas");
        this.montaJanela();
        this.Caracteristicas();
    }

    private void montaJanela() {
        this.add(scroll);
        this.texto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (teclaPressionada == -1) {
                    teclaPressionada = evt.getKeyCode();
                }
                if (teclaPressionada == KeyEvent.VK_ALT) {
                    switch (evt.getKeyCode()) {
                        case KeyEvent.VK_C:
                            f.trocaCor();
                            teclaPressionada = -1;
                            break;
                        case KeyEvent.VK_A:
                            f.abrir();
                            teclaPressionada = -1;
                            break;
                        case KeyEvent.VK_S:
                            try {
                                f.salvar();
                            } catch (IOException ex) {
                                Logger.getLogger(Bnotas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            teclaPressionada = -1;
                            break;
                        case KeyEvent.VK_T:;
                            f.subst();
                            teclaPressionada = -1;
                            break;
                        case KeyEvent.VK_B:
                            f.trocaBackGround();
                            teclaPressionada = -1;
                            break;
                    }
                } else {
                    teclaPressionada = -1;
                }

            }
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void Caracteristicas() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //janelaAcess = janela;
        f.setBnotas(this);
        /* A medida de tamanho é em pixels por polegada, igual a da resolução da sua tela */
        //Formas de definir o tamanho da tela
        this.setSize(640, 480);
        //janela.pack(); << define o tamanho automáticamente //n recomendavel no caso
        this.setVisible(true);
    }
    /*
    public class Hue extends Thread {

         boolean rodando = true;
        
        public void mata() {
        rodando = false;
        }
        
        @Override
        public void run() {
        
        while (rodando) {
        
        System.out.println("Oi!");
        
        if (!janelaAcess.isVisible()) {
        mata();
        }
        try {
        sleep(100);
        } catch (InterruptedException ex) {
        ex.getMessage();
        }
        }
        }
    }*/

    public static void main(String[] args) {
        Bnotas janela = new Bnotas();
    }
}
