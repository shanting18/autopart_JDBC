package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.*;
import java.time.LocalDate;

public class orden {

    int id;
    LocalDate fecha;
    String estado;
    Double total;
    Connection con;

    public orden() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CrearOrden(LocalDate fecha, String estado, Double total){
        String sql = "INSERT INTO ORDEN (FECHA, ESTADO, TOTAL) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(fecha));
            ps.setString(2, estado);
            ps.setDouble(3, total);

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarOrden(int id, LocalDate fecha, String estado, Double total) throws SQLException {
        String sql = "UPDATE ORDEN SET FECHA =?, ESTADO =?, TOTAL =? WHERE ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(fecha));
            ps.setString(2, estado);
            ps.setDouble(3, total);
            ps.setInt(4, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarOrden(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM ORDEN WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();
        return id;
    }

    public void listaOrden(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ORDEN");

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()){
                id = rs.getInt("id");
                fecha = rs.getDate("fecha").toLocalDate();
                estado = rs.getNString("estado");
                total = rs.getDouble("total");

                System.out.println("id: " + id + " fecha: " + fecha + " estado: " + estado + " total: " + total);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
