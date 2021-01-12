package com.silinx.source.algs4.Chapter4.chapter4_2;

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.Queue;
import com.silinx.source.algs4.algs4_lib.StdOut;

/*************************************************************************
 *  Compilation:  javac KosarajuSCC.java
 *  Execution:    java KosarajuSCC filename.txt
 *  Dependencies: Digraph.java TransitiveClosure.java StdOut.java In.java
 *  Data files:   http://algs4.cs.princeton.edu/42directed/tinyDG.txt
 *
 *  Compute the strongly-connected components of a digraph using the
 *  Kosaraju-Sharir algorithm.
 *
 *  Runs in O(E + V) time.
 *
 *  % java KosarajuSCC tinyDG.txt
 *  5 components
 *  1 
 *  0 2 3 4 5 
 *  9 10 11 12 
 *  6 
 *  7 8
 *  SCC：strong connected components 使用kosaraju算法计算强联通分量
 *  方法和无向图的CC方法基本一致，差异在于按照对应有向图的逆序图的逆后序顺序来求联通分量
 *  原理：基本方法和CC一致不赘述（每次的递归结束就是一个分量），关键在于这里用逆序来求分量
 *       关键就涉及对强联通分量的证明具体见P381--1）正常的无向图的联通分量中可以证明存在v-w，而同时必须证明存在w-v才能证明强联通性
 *          当按反向逆序求时其反向图必然先就存在w-v进而证明完成
 *************************************************************************/

public class KosarajuSCC {
    private boolean[] marked;     // marked[v] = has vertex v been visited?
    private int[] id;             // id[v] = id of strong component containing v
    private int count;            // number of strongly-connected components


    public KosarajuSCC(Digraph G) {

        // compute reverse postorder of reverse graph
        DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());

        // run DFS on G, using reverse postorder to guide calculation
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v : dfs.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }

        // check that id[] gives strong components
        assert check(G);
    }

    // DFS on graph G
    private void dfs(Digraph G, int v) { 
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    // return the number of strongly connected components
    public int count() { return count; }

    // are v and w strongly connected?
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    // id of strong component containing v
    public int id(int v) {
        return id[v];
    }

    // does the id[] array contain the strongly connected components?
    private boolean check(Digraph G) {
        TransitiveClosure tc = new TransitiveClosure(G);
        for (int v = 0; v < G.V(); v++) {
            for (int w = 0; w < G.V(); w++) {
                if (stronglyConnected(v, w) != (tc.reachable(v, w) && tc.reachable(w, v)))
                    return false;
            }
        }
        return true;
    }

    public static void main( String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        KosarajuSCC scc = new KosarajuSCC(G);

        // number of connected components
        int M = scc.count();
        StdOut.println(M + " components");

        // compute list of vertices in each strong component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[scc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

    }



//    public  void test() {
//        try {
//            HttpServletResponse response = ServletActionContext.getResponse();
//            //设置返回数据的编码类型
//            response.setCharacterEncoding("GBK");
//            String xml = "-<-?-xml -version=-"1.0-" -encoding=-" gb2312 - " -?->" +
//                    "-<-ddd->-";
//            //里面若干XML数据,格式自己改下，被过滤了加些东西
//
//            String url = "请求地址";
//            HttpClient client = new HttpClient();
//            //设置代理服务器地址和端口
//            //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
//            //使用GET方法，如果服务器需要通过HTTPS连接，那只需要将下面URL中的http换成https
//            //HttpMethod method = new GetMethod("http://java.sun.com");
//            //使用POST方法
//            PostMethod post = new PostMethod(url);
//            //设置要发送请求的XML数据,这里还可以不用直接发送XML数据，可以设置参数
//            //post.setParameter(key, value);
//            post.setRequestEntity(new StringRequestEntity(xml, "text/xml", "GBK"));
//            //执行请求
//            client.executeMethod(post);
//            //打印返回的信息
//            byte[] by = post.getResponseBody();
//            PrintWriter pw = response.getWriter();
//            pw.print(new String(by));
//            //释放连接
//            post.releaseConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
