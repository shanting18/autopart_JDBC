package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.*;

public class vendedor {

    int id;
    String nombre_tienda;
    String descripcion;
    double reputacion;
    Date fecha_registro;
    Connection con;

    public vendedor() throws SQLException {
        this.con = new conexion().obtener_conexion();
    }

    public void crear_vendedor(String nombre_tienda, String descripcion, double reputacion, Date fecha_registro){
        String sql = "INSERT INTO vendedor (NOMBRE_TIENDA, DESCRIPCION, REPUTACION, FECHA_REGISTRO) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre_tienda);
            ps.setString(2, descripcion);
            ps.setDouble(3, reputacion);
            ps.setDate(4, fecha_registro);

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarVendedor(int id, String nombre_tienda, String descripcion, double reputacion, Date fecha_registro) {
        String sql = "UPDATE vendedor SET NOMBRE_TIENDA =?, DESCRIPCION =?, REPUTACION =?, FECHA_REGISTRO =? WHERE ID = ?";
        try {
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, nombre_tienda);
            ps.setString(2, descripcion);
            ps.setDouble(3, reputacion);
            ps.setDate(4, fecha_registro);
            ps.setInt(5, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarVendedor (int id) throws SQLException {

        PreparedStatement ps = con.prepareStatement("DELETE FROM vendedor WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();

        return id;
    }

    public void listaVendedor() throws SQLException {


        PreparedStatement ps = con.prepareStatement("SELECT * FROM vendedor");

        ps.execute();
        ResultSet rs = ps.getResultSet();

        while(rs.next()){
            id = rs.getInt("id");
            nombre_tienda = rs.getString("nombre_tienda");
            descripcion = rs.getString("descripcion");
            reputacion = rs.getDouble("reputacion");
            fecha_registro = rs.getDate("fecha_registro");

            System.out.println("id: "+ id+"  nombre_tienda: "+nombre_tienda+"  descripcion: "+descripcion+"  reputacion: "+reputacion+"  fecha_registro: "+fecha_registro);
        }
    }
}
