package com.sxau.cs.file.man.common.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DubboContext 单例模式
 *
 */
public class DubboContextUtil {
    private static ClassPathXmlApplicationContext context = null;

    private DubboContextUtil() {
    }

    public static ClassPathXmlApplicationContext getInstance() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(new String[]{"/dubbo/consumer.xml"});
            context.start();
        }
        return context;
    }
}
