//package com.silinx.source.jcip;
//
///**
// * @author Email:liufei32@outlook.com  github:Swagger-Ranger
// * @description 典型的工作者线程结构，记录线程出现的未处理的运行时异常，而不是直接退出。来正确的处理线程的非正常退出
// * @since 2020/4/16 16:10
// */
//@JCIPCodeInfo(chapter = "7.3", page = "131")
//public class WorkerThreadWithRuntimeException implements Runnable {
//
//    private Throwable thrown = null;
//
//    @Override
//    public void run() {
//
//        try {
//            while (!Thread.currentThread().isInterrupted()) {
//
//                runTask(getTaskFromWorkQueue());
//            }
//        } catch (Throwable e) {
//            thrown = e;
//        }finally {
//            threadExited(this, thrown);
//        }
//    }
//}
