import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eliminar {
    public JPanel panel1;
    public JTextField textField1;
    public JButton button1;
    private JButton volverButton;


    public eliminar() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = textField1.getText();
                String URL = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String USER = "root";
                String PASSWORD = "123456";



                String sql = "DELETE FROM estudiantes WHERE cedula = ?";

                try (
                        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                        PreparedStatement statement = conn.prepareStatement(sql)
                ) {
                    statement.setString(1, cedula);

                    int filasEliminadas = statement.executeUpdate();

                    if (filasEliminadas > 0) {
                        System.out.println("El estudiante " + cedula + " ha sido eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró ningún estudiante con cedula " + cedula + " para eliminar.");
                    }
                }catch (SQLException i){
                    System.out.println(i.getMessage());
                }

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new lala().a);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);

                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }
}
