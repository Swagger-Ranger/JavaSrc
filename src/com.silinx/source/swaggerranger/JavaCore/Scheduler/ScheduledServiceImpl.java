//package com.silinx.source.swaggerranger.JavaCore.Scheduler;
//
//import javafx.concurrent.Task;
//
//import java.util.concurrent.*;
//
///**
// * @author ext.liufei5
// * @Description TODO
// * @createTime 2020-08-28
// */
//public class ScheduledServiceImpl implements ScheduledService {
//    /**
//     * 创建线程池执行器
//     */
//    private static volatile ScheduledExecutorService SCHEDULED_SERVICE;
//
//    /**
//     * 执行
//     */
//    private static ConcurrentHashMap<String, ScheduledFuture> scheduledFutures = new ConcurrentHashMap<>();
//
//    private static ScheduledExecutorService getInstance() {
//        if (SCHEDULED_SERVICE == null) {
//            synchronized (ScheduledExecutorService.class) {
//                if (ObjectUtils.isEmpty(SCHEDULED_SERVICE)) {
//                    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("schedule-pool-%d").setDaemon(true).build();
//                    SCHEDULED_SERVICE = Executors.newScheduledThreadPool(1, threadFactory);
//                }
//            }
//        }
//        return SCHEDULED_SERVICE;
//    }
//
//    @Override
//    public boolean addTask(ScheduledTask scheduledTask) {
//        if (ObjectUtils.isEmpty(scheduledTask.getRunnable())) {
//            return false;
//        }
//
//        /* 将任务放入定时服务中 */
//        ScheduledFuture<?> scheduledFuture = SCHEDULED_SERVICE.scheduleWithFixedDelay(scheduledTask.getRunnable()
//                , scheduledTask.getInitialDelay(), scheduledTask.getDelay(), TimeUnit.MILLISECONDS);
//
//        scheduledFutures.put(scheduledTask.getTaskId(), scheduledFuture);
//        return true;
//    }
//
//    @Override
//    public boolean updateTask(ScheduledTask scheduledTask) {
//        boolean result = false;
//        if (ObjectUtils.isEmpty(scheduledFutures.get(scheduledTask.getTaskId()))) {
//            return result;
//        }
//
//        result = remove(scheduledTask.getTaskId());
//        if (result) {
//            result = addTask(scheduledTask);
//        }
//        return result;
//    }
//
//    @Override
//    public boolean remove(String taskId) {
//        if (StringUtils.isEmpty(taskId)) {
//            log.error("【定时执行器】.刪除ID为{}任务失败,任务ID为空！", taskId);
//            return false;
//        }
//
//        boolean result = false;
//        ScheduledFuture scheduledFuture = scheduledFutures.get(taskId);
//        if (ObjectUtils.isEmpty(scheduledFuture)) {
//            return result;
//        }
//
//        result = scheduledFuture.cancel(true);
//        if (result) {
//            scheduledFuture = scheduledFutures.remove(taskId);
//            if (!ObjectUtils.isEmpty(scheduledFuture)) {
//                result = true;
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public void shutdown() {
//        SCHEDULED_SERVICE.shutdown();
//    }
//
//    @Override
//    public void init() {
//        afterPropertiesSet();
//    }
//
//    @Override
//    public void afterPropertiesSet() {
//        SCHEDULED_SERVICE = getInstance();
//    }
//
//    @Override
//    protected Task createTask() {
//        return null;
//    }
//}
