package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usuario {

    String id;
    String nombre;
    String correo;
    String contrasena;
    String direccion;
    String telefono;
    Connection con;

    public usuario() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crear_usuario(String nombre, String correo, String contrasena, String direccion, String telefono){
        String sql = "INSERT INTO usuario (NOMBRE, CORREO, CONTRASEÑA, DIRECCION, TELEFONO) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, contrasena);
            ps.setString(4, direccion);
            ps.setString(5, telefono);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizar(String id, String nombre, String correo, String contrasena, String direccion, String telefono) {
        String sql = "UPDATE usuario SET NOMBRE =?, CORREO =?, CONTRASEÑA =?, DIRECCION =?, TELEFONO =? WHERE ID = ?";


        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, contrasena);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, id);

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String eliminar (String id) throws SQLException {

            PreparedStatement ps = con.prepareStatement("DELETE FROM usuario WHERE ID = ?");
            ps.setString(1, id);

            ps.execute();

            return id;
    }
    public void lista() throws SQLException {


                PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario");

                ps.execute();
                ResultSet rs = ps.getResultSet();

                while(rs.next()){
                    id = rs.getString("id");
                    nombre = rs.getString("nombre");
                    correo = rs.getString("correo");
                    contrasena = rs.getString("contraseña");
                    direccion = rs.getString("direccion");
                    telefono = rs.getString("telefono");

                    System.out.println("id: "+ id+"  nombre: "+nombre+"  correo: "+correo+"  contraseña: "+contrasena+"  direccion: "+direccion+"  telefono: "+telefono);
                }
    }
}






