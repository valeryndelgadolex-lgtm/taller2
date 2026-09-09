import java.util.Iterator;

public class MiLista implements ListInterface {
    ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;

    }

    @Override
    public Object getHead() {
        return cabeza.dato;
    }


    @Override
    public Object getTail() {
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }

        return iterador.dato;
    }

    @Override
    public Object get(ListNode node) {
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(node.dato)) {
                return node.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public Object search(Object object) {
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return object;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        insertTail(object);
        //ya hecho
        return true;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        ListNode nuevanodo = new ListNode(object);
        ListNode iterador = this.cabeza;
        if (node == this.cabeza) {
            nuevanodo.siguiente = this.cabeza;
            this.cabeza = nuevanodo;

            return true;
        }
        while (iterador != null) {
            if (iterador.siguiente == node) {
                nuevanodo.siguiente = node;
                iterador.siguiente = nuevanodo;
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        if (this.cabeza == null) {
            return false;
        }
        ListNode anterior = this.cabeza;
        ListNode iterador = this.cabeza.siguiente;
        ListNode nuevanodo = new ListNode(object);
        if (anterior.dato.equals(ob)) {
            nuevanodo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevanodo;
            return true;
        }
        while (iterador != null) {
            if (anterior.dato.equals(ob)) {
                nuevanodo.siguiente = iterador;
                anterior.siguiente = nuevanodo;
                return true;
            }
            anterior = anterior.siguiente;
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if (this.cabeza == null) {
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        } else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador == node) {
                iterador.dato = object;
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }


    @Override
    public boolean remove(ListNode node) {

        if (this.cabeza == null) {
            return false;
        }

        if (this.cabeza == node) {
            this.cabeza = this.cabeza.siguiente;
            return true;
        }

        ListNode anterior = this.cabeza;
        ListNode iterador = this.cabeza.siguiente;

        while (iterador != null) {

            if (iterador == node) {
                anterior.siguiente = iterador.siguiente;
                return true;
            }

            anterior = anterior.siguiente;
            iterador = iterador.siguiente;
        }

        return false;
    }


    @Override
    public boolean contains(Object object) {
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return true;
            }
            iterador = iterador.siguiente;
        }

        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
//no se realiza
        return null;
    }

    @Override
    public Object[] toArray() {
        ListNode iterador = this.cabeza;
        int indice = 0;
        while (iterador != null) {
            indice = indice + 1;
            iterador = iterador.siguiente;

        }
        Object[] array = new Object[indice];
        iterador = this.cabeza;
        int indicedos = 0;

        while (iterador != null) {
            array[indicedos] = iterador.dato;
            indicedos = indicedos + 1;
            iterador = iterador.siguiente;
        }

        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        ListNode iterador = this.cabeza;
        int indice = 0;
        while (iterador != null) {
            indice = indice + 1;
            iterador = iterador.siguiente;

        }
        if (object.length < indice) {
            object = new Object[indice];

            iterador = this.cabeza;
            int indicedos = 0;

            while (iterador != null) {
                object[indicedos] = iterador.dato;
                indicedos = indicedos + 1;
                iterador = iterador.siguiente;
            }

            return object;

        }
        return null;
    }

    @Override
    public Object getBeforeTo() {
        //no se realiza
        return null;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        ListNode before = this.cabeza;
        ListNode iterador = this.cabeza.siguiente;

        if (node == this.cabeza) {
            return null;
        }


        while (iterador != null) {
            if (node == iterador) {
                return before;
            }
            iterador = iterador.siguiente;
            before = before.siguiente;
        }



        return null;
    }


    @Override
    public Object getNextTo() {

        //no se realiza
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        ListNode iterador = this.cabeza;
        ListNode next = this.cabeza.siguiente;

        while (iterador != null) {
            if (node == iterador) {
                return next;
            }
            iterador = iterador.siguiente;
            next = next.siguiente;
        }

        return null;

    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        return null;
    }

    @Override
    public MiLista sortList() {
        return null;
    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
