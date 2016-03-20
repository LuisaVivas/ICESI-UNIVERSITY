package TadArbol;

import TadLista.ListaDoble;


/**
 * Interface �rbol Binario de B�squeda
 * @author Juan Manuel Reyes <juan.reyes@correounivall.edu.co>
 */
public interface IBSTTree<K extends Comparable<K>,T> {
    public IBSTNode<K,T> getRoot();
    public boolean isNil(IBSTNode<K,T> node);
}
