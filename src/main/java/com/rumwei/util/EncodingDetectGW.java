package com.rumwei.util;

import com.rumwei.outside.BytesEncodingDetect;

import java.io.File;

public class EncodingDetectGW {
    /**
     * 得到文件的编码
     * @param filePath 文件路径
     * @return 文件的编码
     */
    public static String getJavaEncode(String filePath){
        BytesEncodingDetect s = new BytesEncodingDetect();
        String fileCode = BytesEncodingDetect.javaname[s.detectEncoding(new File(filePath))];
        return fileCode;
    }
}
