import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jye
 */
public class ClassOne extends ClassLoader {
    public static void main(String[] args) {
        try {
            ClassOne one = new ClassOne();
            Class c = one.getClass("Hello.xlass");
            Method method = c.getMethod("hello", null);
            method.invoke(c.newInstance(),null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private Class getClass (String path) throws IOException {
        InputStream in = new FileInputStream(path);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(null, bytes, 0, bytes.length);
    }
}
