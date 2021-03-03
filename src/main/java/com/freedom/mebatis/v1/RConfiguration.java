package com.freedom.mebatis.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @Description
 * @Author Roger
 * @Version V1.0.0
 * @Since 1.0
 * @Date 3/3/21
 */
public class RConfiguration {

    //获取v1sql文件资源
    public static final ResourceBundle sqlMappers;

    static {
        sqlMappers = ResourceBundle.getBundle("v1sql");
    }

    public <T> T getMapper(Class clazz, RSqlsession Sqlsession) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new RMapperProxy(Sqlsession)
        );
    }
}
