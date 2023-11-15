package com.us.base.code.usbasecode.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 流工具
 *
 * @author wufan
 * @date 2023/10/18
 */
@Slf4j
public class UsStreamUtil {

    /**
     * 读取文件写入内容并返回输出流
     * @date 2023/10/18
     */
    public static void writeFile(String filePath,String content){
        File file = new File(filePath);
        if (file.canRead() && file.canWrite()){
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(content);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {

            }
        }
    }
}
