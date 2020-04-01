package com.silinx.source.swaggerranger.JavaCore;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


//example from http://www.runoob.com/java/java-files-io.html;

public class Test_IO {

    public static void getInputChar() throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));  //System.in返回的就是一个InputStreamReader对象
        System.out.println("type a char,or type 'q' to quit!");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while(c != 'q');
    }

    public static void getInoputString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("type some string,or type 'end' to qiut!");
        StringBuilder sb=new StringBuilder();
        String str;
        do{
            str=br.readLine();
            sb.append(str);
        }while(!str.equals("end"));
    }

    public static void fileIO( String file) throws IOException {
        File f = new File(file);
        FileOutputStream fop = new FileOutputStream(f);
        // 构建FileOutputStream对象,文件不存在会自动新建

        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

        writer.append("中文输入");
        // 写入到缓冲区

        writer.append("\r\n");
        //换行

        writer.append("English");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

        writer.close();
        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

        fop.close();
        // 关闭输出流,释放系统资源

        FileInputStream fip = new FileInputStream(f);
        // 构建FileInputStream对象

        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // 构建InputStreamReader对象,编码与写入相同

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流

        fip.close();
        // 关闭输入流,释放系统资源

    }

    public static void mixFiles( String...files) throws IOException {

        FileInputStream fileinput = null;
        FileOutputStream fileoutput = null;

        byte[] by = new byte[1024*10];  //缓冲区的大小

        try {
            fileoutput =new FileOutputStream("./TestIO.ncm");//可以传个file文件对象，但这里直接些路经，java会自动创建
            for (int i = 0; i < files.length; i++) {
                fileinput = new FileInputStream(files[i]);
                int count =0;
                while(fileinput.read(by)!=-1){

                    //skip the first 1M content
                    fileinput.skip(1024);
                    fileoutput.write(by);
                    count++;
                    System.out.println(count);

                    if(count >= 1024*2/10) break;//按1M的速度读取，读2M需要的次数

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fileinput.close();
            fileoutput.close();
        }

    }

    public static void main( String[] args) throws IOException {
//        getInputChar();
//        getInoputString();
//        fileIO("./fileWrite.txt");
//        mixFiles("C:\\CloudMusic\\Alan Walker - The Spectre.ncm","C:\\CloudMusic\\Alan Walker,K-391 - Ignite (Instrumental).ncm");

//        while (true) {
//            System.out.println("-------------------------");
//            if (true) {
//                System.out.println("fffffffffffff");
//                break;
//                return;
//            }
//        }

        String str = "Swag  ger";
        System.out.println(str.intern());

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
//                iterator.remove();//正确执行
                list.remove(item);//抛出ConcurrentModificationException异常

            }
        }

//        CopyOnWriteArrayList
        //抛出java.util.ConcurrentModificationException异常,对Vector、ArrayList在迭代的时候如果同时对其进行修改就会抛出
//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            }
//        }
        //仍然会抛出那个异常,原因就是forEach只是lambda表达式的语法糖,里面还是for循环.
//        list.forEach(x -> {
//            if ("2".equals(x)) {
//                list.remove(x);
//            }
//        });
        System.out.println(Arrays.toString(list.toArray()));

    }


}
