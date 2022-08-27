package com.yueqing.designpatterns.behavioral.strategy;

import java.util.Map;
import java.util.ServiceLoader;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.yueqing.designpatterns.behavioral.strategy.price.IPriceStrategy;
import com.yueqing.designpatterns.behavioral.strategy.price.NullOrderPrice;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class PriceStrategyFactory implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    private static Map<String, IPriceStrategy> strategyMap;

    public static void main(String[] args) {
        IPriceStrategy strategy = getPriceStrategy(OrderPriceEnum.TMOrder);
        System.out.println(strategy.calculatePrice(10));
    }

    public static IPriceStrategy getPriceStrategy(OrderPriceEnum orderPriceEnum) {
        //使用ServiceLoader 需要在META-INF 下建立配置文件
        ServiceLoader<IPriceStrategy> strategies = ServiceLoader.load(IPriceStrategy.class);
        for (IPriceStrategy strategy : strategies) {
            if (strategy.getClass().getSimpleName().equals(orderPriceEnum.getStrategyName())) {
                return strategy;
            }
        }
        return new NullOrderPrice();
    }

    /**
     * Spring项目 使用
     */
    public static IPriceStrategy getPriceStrategyFromSpring(OrderPriceEnum orderPriceEnum) {
        //如果是Spring项目，则可以直接使用ApplicationContext.getBeansOfType
        for (IPriceStrategy strategy : strategyMap.values()) {
            if (strategy.getClass().getSimpleName().equalsIgnoreCase(orderPriceEnum.getStrategyName())) {
                return strategy;
            }
        }
        return new NullOrderPrice();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        strategyMap = applicationContext.getBeansOfType(IPriceStrategy.class);
    }
}
