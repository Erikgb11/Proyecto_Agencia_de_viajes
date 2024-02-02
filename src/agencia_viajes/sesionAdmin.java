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
public class sesionAdmin {
    private static Admin usuarioActual;

    public static Admin getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Admin usuario) {
        usuarioActual = usuario;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }
}
