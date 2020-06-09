package proxy;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hao
 * @create 2019-07-30 ${TIM}
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * 获取class文件对象的三种方式
         * 1、通过对象获取
         * 2、通过类获取
         * 3、通过Class.forName获取
         */

        Class<?> aClass = Class.forName("proxy.Order");

        //通过class 创建对象
        Object o = aClass.newInstance();

        Field[] fields = aClass.getFields();
        System.out.println("========获取public成员变量=========");
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=========获取所有成员变量==========");
        Field[] field2 = aClass.getDeclaredFields();
        for (Field field : field2) {
            System.out.println(field);
        }

        System.out.println("=========获取所有public成员方法========");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("========获取所有成员方法===========");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println("========获取所有构造方法===========");
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("=============获取某个公共成员变量的值=================");
        Field oid = aClass.getField("oid");
        //如果是public的成员变量 能直接获取值
        String id = (String) oid.get(o);
        System.out.println("oid=====>"+id);

        System.out.println("=============获取私有成员变量的值=================");
        Field state = aClass.getDeclaredField("state");
        //需要开启访问 不然报错IllegalAccessException
        state.setAccessible(true);
        int  stat = (int) state.get(o);
        System.out.println("state=======>"+stat);

        System.out.println("=======================获取父类的信息====================");
        System.out.println("===============父类所有方法===============");
        Method[] declaredMethods1 = aClass.getSuperclass().getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.out.println(method);
        }
        System.out.println("===============父类所有成员变量===============");
        Field[] fields1 = aClass.getSuperclass().getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }


        Method happy = aClass.getMethod("happy",int.class);
        happy.invoke(aClass.newInstance(),100);

        Method cry = aClass.getDeclaredMethod("cry");
        cry.setAccessible(true);
        cry.invoke(aClass.newInstance());
    }

}
