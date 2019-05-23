package file;

import java.io.File;

/**
 * 读取一个文件夹所有的文件 使用递归
 * 2019/05/23
 */
public class ReadFiles {

    private static void readFiles(String url){
        if(url==null){
            return;
        }
        File[] files=new File(url).listFiles();
        if (files==null){
            return;
        }
        for(File file:files){
            if (file.isDirectory()){
                System.out.println("文件夹:"+file.getName());
                readFiles(file.getPath());
            }else if(file.isFile()){
                System.out.println(file.getName());
            }else{
                System.out.println("读取失败");
            }
        }
    }

    public static void main(String[] args) {
        readFiles("E:\\杂七杂八的文件");
    }
}
