package com.rumwei.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZipUtilGW {

    public static String byteToHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer(bytes.length);
        String strTemp;
        for (int i=0; i<bytes.length; i++){
            strTemp = Integer.toHexString(0xFF & bytes[i]);
            if (strTemp.length() < 2){
                sb.append(0);
            }
            sb.append(strTemp.toUpperCase());
        }
        return sb.toString();
    }


    public static byte[] GZipCompressToByteArray(byte[] content) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gos = new GZIPOutputStream(baos);

        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        byte[] buffer = new byte[1024];
        int n;
        while ((n=bais.read(buffer)) != -1){
            gos.write(buffer,0,n);
        }
        gos.flush();
        gos.close();
        return baos.toByteArray();
    }

    public static String GZipCompressToString(byte[] content) throws IOException{
        return byteToHexString(GZipCompressToByteArray(content));
    }

    public static byte[] GZipDeCompressToByteArray(byte[] content) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(content));
        byte[] buffer = new byte[1024];
        int n;
        while ((n=gis.read(buffer)) != -1){
            baos.write(buffer,0,n);
        }
        return baos.toByteArray();
    }

    public static byte[] GZipDeCompressToByteArray(String input) throws IOException{
        byte[] inputByte = hexStringToBytes(input);
        return GZipDeCompressToByteArray(inputByte);
    }

    public static String GZipDeCompressToString(String input) throws IOException{
        return new String(GZipDeCompressToByteArray(input));
    }

    public static byte[] hexStringToBytes(String hexString){
        if (StringUtilGW.isNullOrEmpty(hexString)){
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length()/2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i=0; i<length; i++){
            int pos = i*2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos+1]));
        }
        return d;
    }


    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }




}
