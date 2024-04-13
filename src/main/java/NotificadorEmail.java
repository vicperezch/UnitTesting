public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        // Lógica para enviar una notificación por correo
        if (direccion != null && mensaje != null) {
            if (!direccion.isEmpty() && !mensaje.isEmpty()) {
                if (direccion.contains("@")) {
                    emailCliente.enviarCorreo(direccion, mensaje);
                }
            }
        }
    }
}
