package gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-09-20-19:00
 * 媒婆
 */
public class SubjectMeiPo implements SubjectI {

    private List<ObserverI> obervers = new ArrayList<>();

    @Override
    public void add(ObserverI observerI) {
        obervers.add(observerI);
    }

    @Override
    public void remove(ObserverI observerI) {
        for (ObserverI oberver : obervers) {
            if (oberver.equals(observerI)){
                obervers.remove(oberver);
                break;
            }
        }
    }

    @Override
    public void notifyObserver() {
        obervers.stream().forEach(ObserverI::update);
    }
}
