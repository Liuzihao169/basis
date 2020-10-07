package gof.decoratoer;

import java.math.BigDecimal;

/**
 * @author liuzihao
 * @create 2020-10-07-11:48
 */
public class JbComponenthHotDog implements JbComponent {
    @Override
    public String desc() {
        return "火腿";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(1);
    }
}
