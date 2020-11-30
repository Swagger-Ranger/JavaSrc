package com.silinx.source.swaggerranger.JavaCore.Scheduler;


/**
 * @program: open-analysis
 * @description: 定時任務器
 * @author: gaoyanlei
 * @create: 2020-08-22 15:02
 **/
public interface ScheduledService {
    /**
     * 添加一个任务
     **/
    boolean addTask(ScheduledTask scheduledTask);

    /**
     * 修改一个任务
     **/
    boolean updateTask(ScheduledTask scheduledTask) throws InterruptedException;

    /**
     * 移除一个任务
     **/
    boolean remove(String taskId);

    /**
     * 关闭定时任务服务
     **/
    void shutdown();

    /**
     * 初始化定时任务服务
     **/
    void init() throws Exception;

}
