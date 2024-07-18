import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lala {
    public JButton Cambiar;
    public JButton borrar;
    public JPanel a;


    public lala() {
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new eliminar().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);

                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(borrar)).dispose();

            }
        });
        Cambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new Cambiar().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 1000);

                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(Cambiar)).dispose();

            }
        });
    }
}
