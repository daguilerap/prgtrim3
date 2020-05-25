package cards;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BiCards extends JFrame {
    JPanel panelInic = new JPanel(), panelSecun1 = new JPanel(), panelSecun2 = new JPanel(), botonesInic = new JPanel();
    JLabel etiqPS1 = new JLabel("Pantalla 1"), etiqPS2 = new JLabel("Pantalla 2");
    JButton botonPant1 = new JButton("Ir a Pantalla 1"), botonPant2 = new JButton("Ir a Pantalla 2");
    CardLayout espacioLaminado = new CardLayout();

    public BiCards() {
        setSize(900, 550);
        panelInic.setLayout(espacioLaminado);
        panelSecun1.add(etiqPS1);
        panelSecun2.add(etiqPS2);
        panelInic.add(panelSecun1, "1");
        panelInic.add(panelSecun2, "2");

        botonPant1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                espacioLaminado.show(panelInic, "1");
            }
        });

        botonPant2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                espacioLaminado.show(panelInic, "2");
            }
        });

        botonesInic.add(botonPant1);
        botonesInic.add(botonPant2);
        add(panelInic, BorderLayout.NORTH);
        add(botonesInic, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        BiCards marco = new BiCards();
        marco.setTitle("Ejemplo con diferentes Paneles");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
