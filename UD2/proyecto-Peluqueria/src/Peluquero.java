import java.util.Random;

public class Peluquero implements Runnable {
    private final int id;
    private final Peluqueria peluqueria;
    private final Random random = new Random();

    public Peluquero(int id, Peluqueria peluqueria) {
        this.id = id;
        this.peluqueria = peluqueria;
    }

    
    @Override
    public void run() {
        while (peluqueria.peluqueriaAbierta || !peluqueria.colaClientes.isEmpty()) {
            try {
                peluqueria.clientesEsperando.acquire();
                Cliente cliente = peluqueria.colaClientes.poll();

                if (cliente != null) {
                    peluqueria.sillasDisponibles.release();
                    System.out.println("El peluquero " + id + " está rapando al cliente " + cliente.getId());
                    Thread.sleep(random.nextInt(2000) + 4000);
                    System.out.println("El peluquero " + id + "ha terminado de rapar al cliente " + cliente.getId());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("El peluquero " + id + " ha terminado su jornada laboral");
    }
}
