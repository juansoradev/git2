package iug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    // Creacion de componentes
    private JTextField textFieldCC;
    private JTextField textFieldPass;
    private JButton entrarButton;
    private JPanel main;
    private JPanel login;
    private JPasswordField passwordField;

    // Ejecuta init
    public Login(){
        init();
    }
    // configuracion de los componentes
    private void init(){

        Integer cc = 1122334455;
        String password = "pass123";

        // Configuracion de la vista
        JFrame jFrame = new JFrame();
        jFrame.setSize(400,400);
        jFrame.setTitle("Login");
        jFrame.setVisible(true);
        jFrame.add(main);

        textFieldCC.setText(String.valueOf(cc));
        passwordField.setText(password);

        // Boton de Validacion
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar que no esté vacio
                if (textFieldCC.getText().isEmpty() || passwordField.getPassword().length == 0){
                    textFieldCC.setText("");
                    passwordField.setText("");
                }
                else {
                    // Validar que sean correctos los datos
                    char[] p = passwordField.getPassword();
                    String validarPass = String.valueOf(p);

                    if (Integer.valueOf(textFieldCC.getText()).equals(cc) && validarPass.equals(password)){
                        System.out.println("Correcto");
                        Bienvenido n = new Bienvenido();
                        jFrame.setVisible(false);
                    }
                    else {
                        System.out.println("Incorrecto");
                    }
                }
            }
        });
    }
}
