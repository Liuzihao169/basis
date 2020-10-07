package gof.decoratoer;

import java.math.BigDecimal;

/**
 * @author liuzihao
 * @create 2020-10-07-11:47
 */
public class JbComponentPancakes implements  JbComponent{
    @Override
    public String desc() {
        return "煎饼";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(2);
    }
}
