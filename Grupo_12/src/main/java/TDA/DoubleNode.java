/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.io.Serializable;

/**
 *
 * @author josue
 */
public class DoubleNode<E> implements Serializable{

    public E content;
    public DoubleNode<E> next;
    public DoubleNode<E> previous;

    public DoubleNode(E element) {
        this.content = element;
        this.next = this;
        this.previous = this;
    }

    public E getContent() {
        return content;
    }

    public DoubleNode<E> getNext() {
        return next;
    }

    public DoubleNode<E> getPrevious() {
        return previous;
    }

    public void setNext(DoubleNode<E> e) {
        this.next = e;
    }

    public void setContent(E e) {
        this.content = e;
    }

    public void setPrevious(DoubleNode<E> previous) {
        this.previous = previous;
    }
}
