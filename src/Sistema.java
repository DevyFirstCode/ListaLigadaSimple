import javax.swing.JOptionPane;

public class Sistema {
    private static final String MENU = """
            LISTA SIMPLEMENTE LIGADA

            1. Insertar al inicio
            2. Insertar al final
            3. Eliminar un dato
            4. Buscar un dato
            5. Mostrar la lista
            6. Mostrar el tamanio
            7. Vaciar la lista
            0. Salir
            """;

    public static void main(String[] args) {
        Lista lista = new Lista();
        Integer opcion;

        do {
            opcion = leerEntero(MENU + "\nSeleccione una opcion:");

            if (opcion == null) {
                break;
            }

            switch (opcion) {
                case 1 -> insertarDato(lista, true);
                case 2 -> insertarDato(lista, false);
                case 3 -> eliminarDato(lista);
                case 4 -> buscarDato(lista);
                case 5 -> mostrarMensaje(lista.toString());
                case 6 -> mostrarMensaje("Cantidad de nodos: " + lista.getTamanio());
                case 7 -> {
                    lista.vaciar();
                    mostrarMensaje("La lista fue vaciada.");
                }
                case 0 -> mostrarMensaje("Programa finalizado.");
                default -> mostrarError("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void insertarDato(Lista lista, boolean alInicio) {
        Integer dato = leerEntero("Dato a insertar:");
        if (dato == null) {
            return;
        }

        if (alInicio) {
            lista.insertarAlInicio(dato);
        } else {
            lista.insertarAlFinal(dato);
        }

        mostrarMensaje("El dato fue insertado.");
    }

    private static void eliminarDato(Lista lista) {
        Integer dato = leerEntero("Dato a eliminar:");
        if (dato == null) {
            return;
        }

        String mensaje = lista.eliminar(dato)
                ? "El dato fue eliminado."
                : "El dato no se encuentra en la lista.";
        mostrarMensaje(mensaje);
    }

    private static void buscarDato(Lista lista) {
        Integer dato = leerEntero("Dato a buscar:");
        if (dato == null) {
            return;
        }

        String mensaje = lista.buscar(dato)
                ? "El dato se encuentra en la lista."
                : "El dato no se encuentra en la lista.";
        mostrarMensaje(mensaje);
    }

    private static Integer leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje, "Lista simplemente ligada",
                    JOptionPane.QUESTION_MESSAGE);

            if (entrada == null) {
                return null;
            }

            try {
                return Integer.valueOf(entrada.trim());
            } catch (NumberFormatException error) {
                mostrarError("Entrada no valida. Escriba un numero entero.");
            }
        }
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Lista simplemente ligada",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}