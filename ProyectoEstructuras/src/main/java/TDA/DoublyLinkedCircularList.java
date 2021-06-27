/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.util.Comparator;
import java.util.Iterator;
/**
 *
 * @author josue
 */
public class DoublyLinkedCircularList<E> implements List<E> {

    private DoubleNode<E> last;
    private int effectiveSize = 0;

    public DoublyLinkedCircularList() {
        this.last = null;
    }

    private DoubleNode<E> getHeader() {
        return last.getNext();
    }

    @Override
    public boolean addFirst(E e) {
        DoubleNode<E> node = new DoubleNode<>(e);
        if (last == null) {
            last = node;
        } else if (effectiveSize == 1) {
            node.setNext(last);
            node.setPrevious(last);
            last.setNext(node);
            last.setPrevious(node);
        } else {
            DoubleNode<E> header = getHeader();

            node.setNext(header);
            node.setPrevious(last);

            header.setPrevious(node);
            last.setNext(node);
        }
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        DoubleNode<E> node = new DoubleNode<>(e);
        if (last == null) {
            last = node;
        } else if (effectiveSize == 1) {
            node.setNext(last);
            node.setPrevious(last);
            last.setNext(node);
            last.setPrevious(node);
        } else {
            DoubleNode<E> header = getHeader();

            node.setNext(header);
            node.setPrevious(last);

            header.setPrevious(node);
            last.setNext(node);
        }
        last = node;
        effectiveSize++;
        return true;
    }

    // Crear 2 metodos 1) Que sume o reste y otro que se mueva a derecha o izquierda
    // 
    @Override
    public E removeFirst() {
        DoubleNode<E> header = getHeader();
        E element = header.getContent();

        last.setNext(header.getNext());
        header.getNext().setPrevious(last);

        header.setNext(null);
        header.setPrevious(null);

        return element;
    }

    @Override
    public E removeLast() {
        DoubleNode<E> header = getHeader();
        DoubleNode<E> previous = getDoubleNode(effectiveSize - 2);
        E element = header.getContent();

        previous.setNext(header);
        header.setPrevious(previous);

        last = previous;

        return element;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public void clear() {
        effectiveSize = 0;
        last = null;
    }

    @Override
    public void add(int index, E element) {
        if (checkIndex(index)) {
            if (index == 0) {
                addFirst(element);
            } else if (index == effectiveSize - 1) {
                addLast(element);
            } else {
                DoubleNode<E> newNode = new DoubleNode(element);

                DoubleNode<E> n1 = getDoubleNode(index);
                DoubleNode<E> n2 = n1.getPrevious();

                newNode.setNext(n1);
                newNode.setPrevious(n2);

                n1.setPrevious(newNode);
                n2.setNext(newNode);

                effectiveSize++;
            }
        }
    }

    @Override
    public E remove(int index) {
        if (checkIndex(index)) {
            DoubleNode<E> node = getDoubleNode(index);
            E element = node.getContent();

            if (index == 0) {
                removeFirst();
            } else if (index == effectiveSize - 1) {
                removeLast();
            } else {
                DoubleNode<E> n1 = node.getPrevious();
                DoubleNode<E> n2 = node.getNext();

                n1.setNext(n2);
                n2.setPrevious(n1);
                node = null;
                effectiveSize--;
                return element;
            }
        }
        return null;
    }

    @Override
    public E get(int index) {
        return getDoubleNode(index).getContent();
    }

    @Override
    public E set(int index, E element) {
        getDoubleNode(index).setContent(element);
        return element;
    }

    @Override
    public String toString() {
        String cadena = "";
        int count = 0;
        for (DoubleNode<E> n = getHeader(); count < effectiveSize; n = n.getNext()) {
            E e = n.getContent();
            cadena += e.toString() + " ";
            count++;
        }
        return cadena;
    }
    
    /**
     * Revisa el indice dado
     *
     * @param index indice recibido
     * @return retorna true si el indice es valido o falso si no lo es
     */
    private boolean checkIndex(int index) {
        return (index <= effectiveSize && index >= 0);
    }

    /**
     * Devuelve un nodo de un indice deseado
     *
     * @param index indice del nodo
     * @return retorna el nodo deseado
     */
    private DoubleNode<E> getDoubleNode(int index) {
        int count = 0;
        for (DoubleNode<E> n = getHeader(); count < effectiveSize; n = n.getNext()) {
            if (count == index) {
                return n;
            }
            count++;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> findAll(Comparator<E> cmp, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(E o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
