package persistencia;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion {
    // configuracion
    Connection conexion;
    String url = "jdbc:mysql://localhost:3306/git2";
    String usuario = "root";
    String password = "juan";
    // comprobar que se cargó el archivo driver
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Exito");

        } catch (ClassNotFoundException e){
            System.out.println("Error al cargar el driver de mysql");
        } catch (SQLException e){
            System.out.println("Error al conectar la base de datos");
        }
    }
    // comprobar si conecta
    public Connection getConexion(){
        return conexion;
    }
    // cerrar conexion
    public void cerrarConec(){
        try {
            if (conexion != null && !conexion.isClosed()){
                conexion.close();
                System.out.println("Conexion Cerrada");
            }
        } catch (SQLException e){
            System.out.println("Error al cerrar la conexion");
        }
    }
    // funcion para obtener datos de la bd
    public String[] validar(String consultita) {
        String[] res = new String[3];
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultita);

            if (rs.next()) {
                res[0] = rs.getString("cc");
                res[1] = rs.getString("nombre");
                res[2] = rs.getString("contraseña");


            }
            System.out.println(infoArray[0]);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        // valor a retornar
        return res;
    }

}