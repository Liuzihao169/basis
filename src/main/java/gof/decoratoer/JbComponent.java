package gof.decoratoer;

import java.math.BigDecimal;

/**
 * @author liuzihao
 * @create 2020-10-07-11:45
 * 煎饼摊子基本接口
 */
public interface JbComponent {
    /**
     * 描述
     * @return
     */
    public String desc();

    /**
     * 价格
     * @return
     */
    public BigDecimal price();
}
