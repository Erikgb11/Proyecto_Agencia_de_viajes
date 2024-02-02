/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

/**
 *
 * @author erikg
 */
public class Sesion {
    private static Cliente usuarioActual;

    public static Cliente getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Cliente usuario) {
        usuarioActual = usuario;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }
}
