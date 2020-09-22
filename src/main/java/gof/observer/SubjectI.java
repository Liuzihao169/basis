package gof.observer;

/**
 * @author liuzihao
 * @create 2020-09-20-18:59
 */
public interface SubjectI {
    public void add(ObserverI observerI);
    public void remove(ObserverI observerI);
    public void notifyObserver();
}
