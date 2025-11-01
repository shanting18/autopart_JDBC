package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class categoria {

    int id;
    String nombre;
    Connection con;

    public categoria() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tipoCategoria(String nombre){
        String sql = "INSERT INTO CATEGORIA (nombre) VALUES (?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarCategoria(int id, String categoria) throws SQLException {
        String sql = "UPDATE CATEGORIA SET nombre =? WHERE ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, categoria);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarCategoria(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM categoria WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();
        return id;
    }

    public void listaCategorias(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM categoria");

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()){
                id = rs.getInt("id");
                nombre = rs.getNString("nombre");
                System.out.println("id: " + id + " categoria:" + nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
