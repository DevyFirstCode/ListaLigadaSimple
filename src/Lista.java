public class Lista {
    private Nodo cabeza;
    private int tamanio;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        tamanio++;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            tamanio++;
            return;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevoNodo);
        tamanio++;
    }

    public boolean buscar(int dato) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getDato() == dato) {
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public boolean eliminar(int dato) {
        if (estaVacia()) {
            return false;
        }

        if (cabeza.getDato() == dato) {
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return true;
        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.getSiguiente();

        while (actual != null) {
            if (actual.getDato() == dato) {
                anterior.setSiguiente(actual.getSiguiente());
                tamanio--;
                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    public void vaciar() {
        cabeza = null;
        tamanio = 0;
    }

    @Override
    public String toString() {
        if (estaVacia()) {
            return "Lista vacia";
        }

        StringBuilder resultado = new StringBuilder();
        Nodo actual = cabeza;

        while (actual != null) {
            resultado.append(actual.getDato()).append(" -> ");
            actual = actual.getSiguiente();
        }

        return resultado.append("null").toString();
    }
}