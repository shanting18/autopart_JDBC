package com.mycompany.autopart_jdbc;

import com.mycompany.autopart_jdbc.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Autopart_JDBC {

    public static void main(String[] args) throws SQLException {

        usuario usu = new usuario();
        vendedor ven = new vendedor();
        categoria cat = new categoria();
        modelo mod = new modelo();
        marca mar = new marca();
        repuesto rep = new repuesto();
        inventario inv = new inventario();
        orden ord = new orden();
        contacto cont = new contacto();
        ayuda ayu = new ayuda();

        /**
        String id = "4";
        String nombre = "maria";
        String correo = "maria@jki.com";
        String contrasena = "4665";
        String direccion = "calle 789";
        String telefono = "984513165";

         * crear usuario
        usu.crear_usuario(nombre, correo, contrasena, direccion, telefono);
        System.out.println("usuario creado: " + nombre);

                  editar usuario
        usu.actualizar(id, nombre,correo,contrasena,direccion,telefono);
        System.out.println("usuario con el id: " + id + " actualizado!! ");

             eliminar usuario
        usu.eliminar(id);
        System.out.println("usuario con el id: " + id + " eliminado!! ");

            lista de usuarios
        usu.lista();
         */

        /**
        int id = 2;
        String nombre_tienda = "repuestos-cacawate";
        String descripcion = "actualizado";
        double reputacion = 4.3;
        Date fecha_registro = Date.valueOf("2025-11-05");

            crear vendedor
        ven.crear_vendedor(nombre_tienda, descripcion, reputacion, fecha_registro);
        System.out.println("vendedor creado: " + nombre_tienda);

        ven.actualizarVendedor(id, nombre_tienda, descripcion, reputacion, fecha_registro);
        System.out.println("vendedor con el id: " + id + " actualizado!! ");

        ven.eliminarVendedor(id);
        System.out.println("vendedor con el id: " + id + " eliminado!! ");

        ven.listaVendedor();
         */

        /**
        int id = 6;
        String nombre = "bujjia";

        cat.tipoCategoria(nombre);
        System.out.println("categoria " + nombre + " agregada");

            editar categoria
        cat.editarCategoria(id, nombre);
        System.out.println("categoria con el id: " + id + " actualizado!! ");


        cat.eliminarCategoria(id);
        System.out.println("categoria con el id: " + id + "eliminada!!");

        cat.listaCategorias();
         */

        /**
        int id = 6;
        String nombre = "sanzs";

        mod.tipoModelo(nombre);
        System.out.println("modelo " + nombre + " agregada");

        mod.editarModelo(id, nombre);
        System.out.println("modelo con el id: " + id + " actualizado!! ");

        mod.eliminarModelo(id);
        System.out.println("modelo con el id: " + id + "eliminada!!");

        mod.listaModelos();
        */

        /*
         int id = 9;
         String nombre = "tvs";

         mar.tipoMarca(nombre);
         System.out.println("marca " + nombre + " agregada");

         mar.editarMarca(id, nombre);
         System.out.println("marca con el id: " + id + " actualizado!! ");

         mar.eliminarMarca(id);
         System.out.println("marca con el id: " + id + "eliminada!!");

         mar.listaMarca();
         */

        /*
        int id = 1;
        String nombre = "carburador";
        String descripcion = "tyyuighus";
        Double precio = 30.000;
        String categoria = "repuesto x";

        rep.nombreRepuesto(nombre, descripcion, precio, categoria);
        System.out.println("repuesto " + nombre + " agregado");

        rep.editarRepuesto(id, nombre, descripcion, precio, categoria);
        System.out.println("repuesto con el id: " + id + " actualizado!! ");

        rep.eliminarRepuesto(id);
        System.out.println("repuesto con el id: " + id + " eliminado!!");

        rep.listaRepuesto();
        */

        /*
        int id = 6;
        String nombreRepuesto = "aceite";
        int cantidad = 180;
        LocalDate ultimaActualizacion = LocalDate.now();

        inv.producto(nombreRepuesto, cantidad, ultimaActualizacion);
        System.out.println("Inventario:  " + nombreRepuesto + " agregado");

        inv.editarInventario(id, nombreRepuesto, cantidad, ultimaActualizacion);
        System.out.println("inventario con el id: " + id + " actualizado!! ");

        inv.eliminarInventario(id);
        System.out.println("inventario con el id: " + id + " eliminado!!");

        inv.listaInventario();
        */

        /*
        int id = 1;
        LocalDate fecha = LocalDate.now();
        String estado = "proseso";
        Double total = 300.000;

        ord.CrearOrden(fecha, estado, total);
        System.out.println("orden en estado:  " + estado);

        ord.editarOrden(id, fecha, estado, total);
        System.out.println("orden con el id: " + id + " actualizado!! ");

        ord.eliminarOrden(id);
        System.out.println("orden con el id: " + id + " eliminado!!");

        ord.listaOrden();
        */

        /*
        int id = 7;
        String mensaje = " hola que tal ";
        LocalDate fechaEnvio = LocalDate.now();

        cont.mensajeContacto(mensaje, fechaEnvio);
        System.out.println("mensaje guardado:  " + mensaje);

        cont.editarMensaje(id, mensaje, fechaEnvio);
        System.out.println("mensaje editado:  " + mensaje);

        cont.eliminarMensaje(id);
        System.out.println("mensaje eliminado:  " + mensaje);

        cont.listaContacto();
        */

        int id = 2;
        String pregunta = "hola, tengo un porblema";
        String respuesta = "hola buenas tardes, en que te puedo ayudar";

        ayu.mensajeAyuda(pregunta, respuesta);
        System.out.println("mensaje enviado:  " + pregunta);

        ayu.editarPregunta(id, pregunta, respuesta);
        System.out.println("mensaje editado:  " + pregunta);

        ayu.eliminarMensaje(id);
        System.out.println("mensaje eliminado:  " + pregunta);

        ayu.listaAyuda();
    }
}
