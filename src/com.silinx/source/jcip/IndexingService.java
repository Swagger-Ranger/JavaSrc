package com.silinx.source.jcip;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.*;

/**
 * IndexingService
 * <p/>
 * Shutdown with poison pill
 *
 * @author Brian Goetz and Tim Peierls
 * 使用毒丸对象来停止队列，即当得到某个对象就立即停止，毒丸对象之前的都会被处理之后的就不再提交任务
 * 这种模型只有在消费者和生产者都数量已知的情况下才能使用，因为消费者和生产者都要有对应数量的毒丸，来停止工作
 */
@JCIPCodeInfo(chapter = "7.2.3", page = "128")
public class IndexingService {
    private static final int CAPACITY = 1000;
    private static final File POISON = new File("");
    private final IndexerThread consumer = new IndexerThread();
    private final CrawlerThread producer = new CrawlerThread();
    private final BlockingQueue<File> queue;
    private final FileFilter fileFilter;
    private final File root;

    public IndexingService( File root, final FileFilter fileFilter ) {
        this.root = root;
        this.queue = new LinkedBlockingQueue<File>(CAPACITY);
        this.fileFilter = f -> f.isDirectory() || fileFilter.accept(f);
    }

    private boolean alreadyIndexed( File f ) {
        return false;
    }

    class CrawlerThread extends Thread {
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) { /* fall through */
            } finally {
                while (true) {
                    try {
                        queue.put(POISON);
                        break;
                    } catch (InterruptedException e1) { /* retry */
                    }
                }
            }
        }

        private void crawl( File root ) throws InterruptedException {
            File[] entries = root.listFiles(fileFilter);
            if (entries != null) {
                for (File entry : entries) {
                    if (entry.isDirectory())
                        crawl(entry);
                    else if (!alreadyIndexed(entry))
                        queue.put(entry);
                }
            }
        }
    }

    class IndexerThread extends Thread {
        public void run() {
            try {
                while (true) {
                    File file = queue.take();
                    if (file == POISON)
                        break;
                    else
                        indexFile(file);
                }
            } catch (InterruptedException consumed) {
            }
        }

        public void indexFile( File file ) {
            /*...*/
        }

        ;
    }

    public void start() {
        producer.start();
        consumer.start();
    }

    public void stop() {
        producer.interrupt();
    }

    public void awaitTermination() throws InterruptedException {
        consumer.join();
    }
}
