package com.xianxi.study.design.proxy.javassist;

import com.xianxi.study.design.proxy.DBQuery;
import com.xianxi.study.design.proxy.DBQueryImpl;
import javassist.*;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.io.IOException;

/**
 * 定义一个Javassist的代理工厂
 *
 * @author zengxianxi
 * @since 13-9-21 下午7:00
 */
public class JavassistProxyFactory {
    /**
     * 创建Javassist代理对象
     *
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static DBQuery createJavassistProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{DBQuery.class});
        Class proxyClass = proxyFactory.createClass();
        DBQuery dbQuery = (DBQuery) proxyClass.newInstance();
        JavassistDBQueryHandler handler = new JavassistDBQueryHandler();
        ((ProxyObject) dbQuery).setHandler(handler);
        return dbQuery;
    }

    /**
     * 通过Java代码，在运行时动态生成代理对象
     *
     * @return
     * @throws NotFoundException
     * @throws CannotCompileException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static DBQuery createJavassistBytecodeProxy() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool classPool = new ClassPool(true);
        //定义类名
        CtClass ctClass = classPool.makeClass(DBQuery.class.getName() + "JavassistBytecodeProxy");
        //需要实现的接口
        ctClass.addInterface(classPool.get(DBQuery.class.getName()));
        //添加构造器
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
        //添加类的字段信息，使用动态Java代码
        String field = "private " + DBQuery.class.getName() + " dbQuery;";
        ctClass.addField(CtField.make(field, ctClass));
        StringBuffer sb = new StringBuffer("public String request(){");
        sb.append("if(dbQuery==null){dbQuery=new ")
                .append(DBQueryImpl.class.getName())
                .append("();}")
                .append("return dbQuery.request();}");

        ctClass.addMethod(CtNewMethod.make(sb.toString(), ctClass));
        Class clz = ctClass.toClass();
        DBQuery dbQuery = (DBQuery) clz.newInstance();
        return dbQuery;
    }
}
