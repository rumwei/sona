package com.rumwei.util;

import com.rumwei.enums.RequestMethodEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class HttpUtilGW {
  
  private static String send(String urlStr, RequestMethodEnum requestMethod, String encode){
        HttpURLConnection con = null;
        OutputStreamWriter ows = null;
        BufferedReader br = null;
        StringBuffer response = null;
        try{
            URL url = new URL(urlStr);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestMethod.toString());
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            ows = new OutputStreamWriter(con.getOutputStream(),encode);
            ows.flush();
            response = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(),encode));
            String temp;
            while ((temp = br.readLine()) != null){
                response.append(temp);
            }
        }catch(Exception e){
            log.error("调用 "+urlStr+" 失败");
        }finally {
            try{
                ows.close();
                br.close();
            }catch(Exception e){
                log.warn("HttpUtilGW 输出流关闭失败");
            }

        }
        return (response != null)?response.toString():null;
    }

    public static String sendGet(String urlStr, String encode){
        return send(urlStr,RequestMethodEnum.GET,encode);
    }
  
}
