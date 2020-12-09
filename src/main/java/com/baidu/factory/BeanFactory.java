package com.baidu.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties prop = new Properties();

    static {
        InputStream in = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Object getBean(String id){
        Object o = null;
        try {
            Class c  = Class.forName(prop.getProperty(id));
            o = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        //创建对象
        return o;
    }
}
