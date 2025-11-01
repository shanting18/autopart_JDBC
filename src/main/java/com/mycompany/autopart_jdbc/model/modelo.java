package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class modelo {


    int id;
    String nombre;
    Connection con;

    public modelo() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tipoModelo(String nombre){
        String sql = "INSERT INTO MODELO (nombre) VALUES (?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarModelo(int id, String nombre) throws SQLException {
        String sql = "UPDATE MODELO SET nombre =? WHERE ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarModelo(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM modelo WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();
        return id;
    }

    public void listaModelos(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM modelo");

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()){
                id = rs.getInt("id");
                nombre = rs.getNString("nombre");
                System.out.println("id: " + id + " modelo:" + nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
