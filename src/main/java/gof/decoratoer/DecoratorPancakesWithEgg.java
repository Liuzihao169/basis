package gof.decoratoer;

import java.math.BigDecimal;

/**
 * @author liuzihao
 * @create 2020-10-07-11:51
 */
public class DecoratorPancakesWithEgg implements JbComponent {
    private JbComponent jbComponent;

    public DecoratorPancakesWithEgg(JbComponent jbComponent) {
        this.jbComponent = jbComponent;
    }
    @Override
    public String desc() {
        return jbComponent.desc() + "\t" + "加鸡蛋";
    }

    @Override
    public BigDecimal price() {
        return jbComponent.price().add(BigDecimal.ONE);
    }
}
