package com.silinx.source.jcip;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * SafeStates
 * <p/>
 * Initialization safety for immutable objects
 * 对于含有final域的对象，初始化安全性可以防止对象的初始引用被重排序到构造过程之前。
 * 同时在构造函数完成时，构造函数对final域的所有写入操作，以及对通过这些域可以到达的任何变量的写入操作，都将被“冻结”，并且
 *      任何获得该对象的引用的线程都至少能确保看到被冻结的值
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "16.3", page = "288")
@ThreadSafe
public class SafeStates {
    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<String, String>();
        states.put("alaska", "AK");
        states.put("alabama", "AL");
        /*...*/
        states.put("wyoming", "WY");
    }

    public String getAbbreviation( String s) {
        return states.get(s);
    }
}
