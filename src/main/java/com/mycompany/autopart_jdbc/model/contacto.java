package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.*;
import java.time.LocalDate;

public class contacto {

    int id;
    String mensaje;
    LocalDate fechaEnvio;
    Connection con;

    public contacto() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mensajeContacto(String mensaje, LocalDate fechaEnvio){
        String sql = "INSERT INTO CONTACTO (MENSAJE, FECHA_ENVIO) VALUES (?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, mensaje);
            ps.setDate(2, Date.valueOf(fechaEnvio));

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarMensaje(int id, String mensaje, LocalDate fechaEnvio) throws SQLException {
        String sql = "UPDATE CONTACTO SET MENSAJE =?, FECHA_ENVIO =? WHERE ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);


            ps.setString(1, mensaje);
            ps.setDate(2, Date.valueOf(fechaEnvio));
            ps.setInt(3, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarMensaje(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM CONTACTO WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();
        return id;
    }

    public void listaContacto(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM CONTACTO");

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()){
                id = rs.getInt("id");
                mensaje = rs.getNString("mensaje");
                fechaEnvio = rs.getDate("fecha_envio").toLocalDate();

                System.out.println("id: " + id + " mensaje: " + mensaje + " fecha: " + fechaEnvio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
