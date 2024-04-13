import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock = Mockito.mock(EmailCliente.class);

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    // Test para verificar que no se envía correo con dirección vacía
    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "Mensaje");

        // Verificar que no se realiza el envío si la dirección es vacía
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar el comportamiento con mensaje nulo
    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", null);

        // Verificar que no se envía el correo si no tiene mensaje
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar el comportamiento con dirección nula
    @Test
    public void testNotificarConDireccionNula() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, "Mensaje");

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar que no se envía correo con mensaje vacío
    @Test
    public void testNotificarConMensajeVacio() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("prueba@test.com", "");

        // Verificar que no se realiza el envío si el mensaje está vacío
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar que no se envía correo con dirección inválida
    @Test
    public void testNotificarConDireccionInvalida() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("test", "Mensaje");

        // Verificar que no se realiza el envío si la dirección es vacía
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }
}

