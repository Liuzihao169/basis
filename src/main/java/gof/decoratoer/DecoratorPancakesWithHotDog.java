package gof.decoratoer;

import java.math.BigDecimal;

/**
 * @author liuzihao
 * @create 2020-10-07-11:54
 */
public class DecoratorPancakesWithHotDog implements JbComponent{

    private JbComponent jbComponent;

    public DecoratorPancakesWithHotDog(JbComponent jbComponent) {
        this.jbComponent = jbComponent;
    }
    @Override
    public String desc() {
        return jbComponent.desc() +"\t" + "加热狗";
    }

    @Override
    public BigDecimal price() {
        return jbComponent.price().add(BigDecimal.ONE);
    }
}
