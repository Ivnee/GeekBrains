import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import sun.util.resources.cldr.et.TimeZoneNames_et;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CyclicBarrier;

public class TestClass {
    public static void main(String[] args) {
        try {
            start(Cat.class);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    public static void start(Class TestClass) throws InvocationTargetException, IllegalAccessException {
        Class tc = TestClass;
        boolean isBeforSuit = false;
        boolean isAfterSuit = false;
        int priorityLength = 10;
        Method [] methods = tc.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforSuit.class)) {
                if (isBeforSuit) {
                    throw new RuntimeException();
                } else {
                    method.invoke(null);
                    isBeforSuit = true;
                }
            }
        }
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                for (int i = priorityLength; i > 0; i--) {
                    if (method.getAnnotation(Test.class).priority() == i) {
                        method.invoke(null);
                    }
                }
            }
        }
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuit.class)) {
                if (isAfterSuit) {
                    throw new RuntimeException();
                } else {
                    method.invoke(null);
                    isAfterSuit = true;
                }
            }
        }


    }
}
