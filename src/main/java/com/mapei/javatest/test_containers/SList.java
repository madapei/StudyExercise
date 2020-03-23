package com.mapei.javatest.test_containers;

import java.util.NoSuchElementException;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/18
 */
public class SList<E> {
    private static class Link<T>{
        T element;
        Link<T> next;
        Link(T element, Link<T> next){
            this.element = element;
            this.next = next;
        }
    }

    private static class SListIterator<T>{
        private Link<T> next;
        private Link<T> header = new Link<T>(null, null);
        private Link<T> lastReturned = header;

        public boolean hasNext(){
            return lastReturned != header;
        }

        public T next(){
            if (next == header)
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            return lastReturned.element;
        }

        public void remove(){
            if (lastReturned == header)
                throw new IllegalStateException();

        }
    }
}
