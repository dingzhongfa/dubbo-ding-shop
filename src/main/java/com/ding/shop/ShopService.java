package com.ding.shop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.method.P;

/**
 * Created by hzdzf on 2017/1/19.
 */
public class ShopService {

    private static ShopService shopService;

    private static ClassPathXmlApplicationContext context;

    private ShopService() {

    }

    public static ShopService getShopService() {
        return shopService;
    }

    public void start(String configLocation) {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("classpath:" + configLocation);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String configLocation =null;
        if (args!=null&&args.length>0){
            configLocation=args[0];
        }
        if (configLocation==null){
            configLocation= "dubbo-provider.xml";
        }
        ShopService.getShopService().start(configLocation);
        System.out.println("DUBBO SERVICE STARTED");
        while (true){
            Thread.sleep(1000);
        }
    }
}
