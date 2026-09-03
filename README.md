# ListaLigadaSimple

## Objetivo de la práctica

El objetivo de esta práctica es crear una lista simplemente ligada y desarrollar los métodos necesarios para administrar sus elementos.

## Estructura del programa

- **Clase `Nodo`:** representará cada elemento de la lista. Almacenará un dato y una referencia al siguiente nodo.
- **Clase `Lista`:** administrará los nodos de la lista simplemente ligada y contendrá los métodos para realizar las operaciones correspondientes sobre ella.
- **Clase `Sistema`:** contendrá el método `main`, desde el cual se creará una instancia de la lista y se llamarán sus métodos para ejecutar y probar las diferentes operaciones.

## Métodos de la lista

- Insertar un dato al inicio o al final.
- Buscar un dato.
- Eliminar la primera aparición de un dato.
- Mostrar todos los datos.
- Consultar el tamaño.
- Comprobar si está vacía.
- Vaciar la lista.

## Compilación y ejecución

El programa requiere Java 21. Desde la carpeta raíz del proyecto, ejecuta:

```powershell
javac -d out src\*.java
java -cp out Sistema
```

Las operaciones se realizan mediante cuadros de diálogo de `JOptionPane`.