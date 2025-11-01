package com.mycompany.autopart_jdbc.model;

import com.mycompany.autopart_jdbc.conexion;

import java.sql.*;
import java.time.LocalDate;

public class ayuda {

    int id;
    String pregunta;
    String respuesta;
    Connection con;

    public ayuda() {
        try {
            this.con = new conexion().obtener_conexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mensajeAyuda(String pregunta, String respuesta){
        String sql = "INSERT INTO AYUDA (PREGUNTA, RESPUESTA) VALUES (?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, pregunta);
            ps.setString(2, respuesta);

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarPregunta(int id, String pregunta, String respuesta) throws SQLException {
        String sql = "UPDATE AYUDA SET PREGUNTA =?, RESPUESTA =? WHERE ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);


            ps.setString(1, pregunta);
            ps.setString(2, respuesta);
            ps.setInt(3, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminarMensaje(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM AYUDA WHERE ID = ?");
        ps.setInt(1, id);

        ps.execute();
        return id;
    }

    public void listaAyuda(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM AYUDA");

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()){
                id = rs.getInt("id");
                pregunta = rs.getNString("pregunta");
                respuesta = rs.getNString("respuesta");

                System.out.println("id: " + id + " pregunta: " + pregunta + " respuesta: " + respuesta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
