import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cambiar {
    public JPanel panel1;
    public JTextField cedula;
    public JTextField b1;
    public JButton CAMBIARButton;
    private JButton volverButton;

    public Cambiar() {
        CAMBIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String user = "root";
                String password = "123456";
                Connection conn = null;
                PreparedStatement pstmt = null;
                String cedula1=cedula.getText();
                String nota=b1.getText();
                int nota1=Integer.parseInt(nota);
                try {
                    conn = DriverManager.getConnection(url, user, password);
                    //prepara la sentencia sql
                    String sql = "UPDATE estudiantes SET b1 = ? WHERE cedula = ?";
                    pstmt = conn.prepareStatement(sql);
                    //seteamos los valores
                    pstmt.setInt(1, nota1);
                    pstmt.setString(2, cedula1);
                    System.out.println(sql);
                    int n = pstmt.executeUpdate();
                    System.out.println("Se modifico" + n);
                } catch (SQLException i) {
                    System.out.println("XD");


                } finally {
                    try {
                        if (pstmt != null) {
                            pstmt.close();
                        }
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException a) {
                        System.out.println("XD");


                    }


                }

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new lala().a);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 1000);

                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }
}
