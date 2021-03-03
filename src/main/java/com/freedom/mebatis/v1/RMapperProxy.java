package com.freedom.mebatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 使用jdk动态代理，运行该类会先执行invoke方法
 * @Author Roger
 * @Version V1.0.0
 * @Since 1.0
 * @Date 3/3/21
 */
public class RMapperProxy implements InvocationHandler {

    private RSqlsession sqlsession;

    public RMapperProxy(RSqlsession sqlsession) {
        this.sqlsession = sqlsession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        // 用类名+方法名来定位sql语句
        String statementId = mapperInterface + "." +methodName;
        return sqlsession.selectOne(statementId, args[0]);
    }
}
