package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.*;
import java.time.LocalDate;

public class inventario {

    int id;
    String nombreRepuesto;
    int cantidad;
    LocalDate ultimaActualizacion;
    Connection con;

    public inventario() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void producto(String nombreRepuesto, int cantidad, LocalDate ultimaActualizacion){
        String sql = "INSERT INTO INVENTARIO (REPUESTO, CANTIDAD, ULTIMA_ACTUALIZACION) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombreRepuesto);
            ps.setInt(2, cantidad);
            ps.setDate(3, Date.valueOf(ultimaActualizacion));

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarInventario(int id, String nombreRepuesto, int cantidad, LocalDate ultimaActualizacion) throws SQLException {
        String sql = "UPDATE INVENTARIO SET REPUESTO =?, CANTIDAD =?, ULTIMA_ACTUALIZACION =? WHERE ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombreRepuesto);
            ps.setInt(2, cantidad);
            ps.setDate(3, Date.valueOf(ultimaActualizacion));
            ps.setInt(4, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarInventario(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM INVENTARIO WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();
        return id;
    }

    public void listaInventario(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM INVENTARIO");

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()){
                id = rs.getInt("id");
                nombreRepuesto = rs.getNString("repuesto");
                cantidad = rs.getInt("cantidad");
                ultimaActualizacion = rs.getDate("ultima_actualizacion").toLocalDate();
                System.out.println("id: " + id + " repuesto: " + nombreRepuesto + " cantidad: " + cantidad + " ultima actualizacion: " + ultimaActualizacion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
