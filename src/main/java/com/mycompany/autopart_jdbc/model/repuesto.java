package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class repuesto {

    int id;
    String nombre;
    String descripcion;
    double precio;
    String categoria;
    Connection con;

    public repuesto() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void nombreRepuesto(String nombre, String descripcion, Double precio, String categoria){
        String sql = "INSERT INTO REPUESTO (NOMBRE, DESCRIPCION, PRECIO, CATEGORIA) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setString(4, categoria);

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarRepuesto(int id, String nombre, String descripcion, Double precio, String categoria) throws SQLException {
        String sql = "UPDATE REPUESTO SET NOMBRE =?, DESCRIPCION =?, PRECIO =?, CATEGORIA =? WHERE ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setString(4, categoria);
            ps.setInt(5, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarRepuesto(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM repuesto WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();
        return id;
    }

    public void listaRepuesto(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM repuesto");

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()){
                id = rs.getInt("id");
                nombre = rs.getNString("nombre");
                System.out.println("id: " + id + " repuesto:" + nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
