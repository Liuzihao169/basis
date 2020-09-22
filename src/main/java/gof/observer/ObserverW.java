package gof.observer;

/**
 * @author liuzihao
 * @create 2020-09-20-18:56
 */
public class ObserverW implements ObserverI{
    private SubjectI subjectI;

    public ObserverW(SubjectI subjectI) {
        this.subjectI = subjectI;
        subjectI.add(this);
    }
    @Override
    public void update() {
        System.out.println("老王:快来看老婆啦");

    }
}
