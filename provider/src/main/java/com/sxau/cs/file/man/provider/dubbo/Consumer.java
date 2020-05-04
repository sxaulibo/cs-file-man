package com.sxau.cs.file.man.provider.dubbo;

import com.sxau.cs.file.store.api.remote.FileStoreRemote;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        FileStoreRemote fileStoreRemote = (FileStoreRemote)context.getBean("fileStoreRemote"); // 获取远程服务代理
        String hello = fileStoreRemote.// 执行远程方法
        System.out.println( hello ); // 显示调用结果
    }
}