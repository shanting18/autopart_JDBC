package com.mycompany.autopart_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santiago
 */
public class conexion {
     
    public Connection obtener_conexion () throws SQLException{



        String url = "jdbc:mysql://localhost:3306/auto_part";
        String user = "root";
        String password = "";

        Connection con = DriverManager.getConnection(url, user, password);

        return con;




    }
}
