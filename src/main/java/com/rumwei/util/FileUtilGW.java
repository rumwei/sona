package com.rumwei.util;

import com.rumwei.enums.CharsetEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;

@Slf4j
public class FileUtilGW {
    private static final String pathSeparator = File.separator;

    /*
     * @Description 确定文件编码格式，则直接传入文件的编码格式
     * @Return 逐行读取并放入List
     * */
    public static List<String> readFileToStringList(String path, String fileName, CharsetEnum charset) throws Exception{
        return readFileToStringList(path,fileName,charset.getStrVal());
    }

    /*
     * @Description 自动获取文件的编码格式，若获取失败，则默认按照"UTF-8"编码格式读取文件
     * @Return 逐行读取并放入List
     * */
    public static List<String> readFileToStringList(String path, String fileName) throws Exception{
        String encoding = EncodingDetectGW.getJavaEncode(path + pathSeparator + fileName);
        if (encoding != null){
            return readFileToStringList(path,fileName,encoding);
        }else {
            return readFileToStringList(path,fileName,CharsetEnum.utf8);
        }
    }

    /*
    * @Description 用于文件编码格式未知的情况，自动获取文件编码格式，若获取失败，默认按照utf-8来处理
    * */
    public static void appendStrToFile(String path, String fileName, String content) throws Exception{
        String encoding = EncodingDetectGW.getJavaEncode(path+pathSeparator+fileName);
        if (encoding != null){
            appendStrToFile(path,fileName,content,encoding);
        }else {
            appendStrToFile(path,fileName,content,CharsetEnum.utf8);
        }
    }

    /*
     * @Description 用于文件编码格式已知的情况，直接传入文件编码
     * */
    public static void appendStrToFile(String path, String fileName, String content, CharsetEnum charset) throws Exception{
        appendStrToFile(path,fileName,content,charset.getStrVal());
    }











    private static void appendStrToFile(String path, String fileName, String content, String charset) throws Exception{
        File file = new File(path+pathSeparator+fileName);
        FileUtils.writeStringToFile(file,content,charset,true);
    }

    private static List<String> readFileToStringList(String path, String fileName, String charset) throws Exception{
        File file = new File(path + pathSeparator + fileName);
        return FileUtils.readLines(file,charset);
    }






}
