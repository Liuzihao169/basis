package gof.decoratoer;

import java.math.BigDecimal;

/**
 * @author liuzihao
 * @create 2020-10-07-11:48
 * 鸡蛋
 */
public class JbComponenteEgg implements JbComponent {
    @Override
    public String desc() {
        return "鸡蛋";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("1");
    }
}
