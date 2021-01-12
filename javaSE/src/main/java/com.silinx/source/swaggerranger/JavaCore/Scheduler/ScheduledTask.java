package com.silinx.source.swaggerranger.JavaCore.Scheduler;

import java.lang.reflect.Method;

/**
 * @program: open-analysis
 * @description:
 * @author: gaoyanlei
 * @create: 2020-08-22 15:00
 **/
public class ScheduledTask {
    /**
     * 唯一的id用于增删改
     */
    private String taskId;

    /**
     * 需要执行方法的线程
     */
    private Runnable runnable;

    /**
     * 定时任务需要执行的方法类
     */
    private String executorClassName;

    /**
     * 定时任务需要执行的方法
     */
    private String executorMethod;

    /**
     * 延迟执行时间
     */
    private long initialDelay;
    /**
     * 间隔时间
     */
    private long delay;

    public ScheduledTask() {
    }

    public ScheduledTask(String taskId, String executorClassName, String executorMethod, long initialDelay, long delay) {
        this.taskId = taskId;
        this.executorClassName = executorClassName;
        this.executorMethod = executorMethod;
        this.initialDelay = initialDelay;
        this.delay = delay;

        /* 在创建实例的时候，初始化线程类*/
        runnable = () -> {
            try {
//                Object bean = SpringContextUtil.getBean(executorClassName);
                Object bean = null;
                if (null != bean) {
                    Method method = bean.getClass().getMethod(executorMethod);
                    if (null == method) {
                        //静态方法
                        method.invoke(null, null);
                    } else {
                        method.invoke(bean, null);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getExecutorClassName() {
        return executorClassName;
    }

    public void setExecutorClassName(String executorClassName) {
        this.executorClassName = executorClassName;
    }

    public String getExecutorMethod() {
        return executorMethod;
    }

    public void setExecutorMethod(String executorMethod) {
        this.executorMethod = executorMethod;
    }

    public long getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }
}
