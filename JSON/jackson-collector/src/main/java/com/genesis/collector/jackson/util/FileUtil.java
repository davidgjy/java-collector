package com.genesis.collector.jackson.util;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: FileUtil
 * @Package com.genesis.collector.jackson.util
 * @Description: file utility
 * @date 2018/5/25 14:05
 */
public class FileUtil {
    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try (FileInputStream in = new FileInputStream(file)) {
            in.read(filecontent);
            return new String(filecontent, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
