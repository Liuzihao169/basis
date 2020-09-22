package gof.observer;

/**
 * @author liuzihao
 * @create 2020-09-20-18:57
 */
public class ObserverZ implements ObserverI {
    private SubjectI subjectI;

    public ObserverZ(SubjectI subjectI) {
        this.subjectI = subjectI;
        subjectI.add(this);
    }
    @Override
    public void update() {
        System.out.println("老张:快来看老婆啦");
    }
}
