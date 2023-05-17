package com.silinx.source.swaggerranger.JavaCore;

/**
 * @author liufei
 * @since 2023/3/20
 **/
public class Erased <T, EXC extends Throwable> {

    private final static int SIZE = 100;

    public static void f(Object arg){
        // error: Cannot make a static reference to the non-static type T
        //! if (arg instanceof T) { }
        //! T var = new T();
        //! T[] array = new T[SIZE];
        //! T[] array = (T) new Object[SIZE];
    }

    public void g(Object arg) throws EXC {
        // Cannot perform instanceof check against type parameter T.
        // Use its erasure Object instead since further generic type information will be erased at runtime
        //! if (arg instanceof T) { }

        // Cannot instantiate the type T
        //! T var = new T();

        // Cannot create a generic array of T
        //! T[] array = new T[SIZE];

//        ({ "unchecked", "unused" })
        T[] arr = (T[]) new Object[SIZE];

        // Cannot use the type parameter EXC in a catch block
        //! try { } catch (EXC e) {}
    }


}
