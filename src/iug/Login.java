package iug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField textFieldCC;
    private JTextField textFieldPass;
    private JButton entrarButton;
    private JPanel main;
    private JPanel login;
    private JPasswordField passwordField;

    public Login(){
        init();
    }
    private void init(){

        Integer cc = 1122334455;
        String password = "pass123";

        JFrame jFrame = new JFrame();
        jFrame.setSize(400,400);
        jFrame.setTitle("Login");
        jFrame.setVisible(true);
        jFrame.add(main);

        textFieldCC.setText(String.valueOf(cc));
        passwordField.setText(password);


        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bienvenido n = new Bienvenido();
                jFrame.setVisible(false);
            }
        });
    }
}
