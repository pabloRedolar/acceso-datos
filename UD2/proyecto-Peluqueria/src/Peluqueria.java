import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Peluqueria {
    private static final int NUM_PELUQUEROS = 2;
    private static final int NUM_SILLAS = 5;
    private static final int TIEMPO_OPERACION = 30;

    Semaphore clientesEsperando = new Semaphore(0);
    Semaphore sillasDisponibles = new Semaphore(NUM_SILLAS);
    Semaphore peluquerosFinalizados = new Semaphore(0);

    boolean peluqueriaAbierta = true;

    ConcurrentLinkedQueue<Cliente> colaClientes = new ConcurrentLinkedQueue<>();


}
