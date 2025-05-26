import java.lang.reflect.*;

public class ReflectionDemo {
    public void hello() { System.out.println("Hello from reflection!"); }
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectionDemo");
        Object obj = cls.getDeclaredConstructor().newInstance();
        for (Method m : cls.getDeclaredMethods())
            System.out.println(m.getName());
        Method hello = cls.getDeclaredMethod("hello");
        hello.invoke(obj);
    }
}
