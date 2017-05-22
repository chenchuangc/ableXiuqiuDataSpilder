package org.decaywood.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/11/23 14:27
 */
public class HttpRequestHelper {

    private Map<String, String> config;
    private boolean post;
    private boolean gzip;

    public HttpRequestHelper(String webSite) {
        this.config = new HashMap<>();
        this.gzipDecode()
                .addToHeader("Referer", webSite)
//                .addToHeader("Cookie", FileLoader.loadCookie(webSite))
                .addToHeader("Cookie", "__utma=1.236940555.1480640455.1480640455.1480640455.1; __utmz=1.1480640455.1.1.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); webp=0; s=6s122gc7lh; xq_a_token=5b492cc8e1ed1592e952d65419dbf899897c0ad7; xqat=5b492cc8e1ed1592e952d65419dbf899897c0ad7; xq_r_token=1db6e7b35606aa8ed2bf6875f2cc811042d80afa; xq_is_login=1; u=7670768565; xq_token_expire=Sat%20Jun%2010%202017%2016%3A10%3A22%20GMT%2B0800%20(CST); bid=4f495a529b3c75567f0f7a195c096bc9_j2ra3dni; aliyungf_tc=AQAAACXgOg5K+gMA7W0maj6yK7bBQfjE; snbim_minify=true; Hm_lvt_1db88642e346389874251b5a1eded6e3=1495000798,1495001019,1495421775,1495424416; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1495431348")
                .addToHeader("Host", "xueqiu.com")
                .addToHeader("Referer", "https://xueqiu.com/p/discover?action=money&market=cn")
                .addToHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                .addToHeader("X-Requested-With", "XMLHttpRequest");
//                .addToHeader("Host", "xueqiu.com");
//                .addToHeader("Accept-Encoding", "gzip,deflate,sdch");
    }

    public HttpRequestHelper post() {
        this.post = true;
        return this;
    }

    public HttpRequestHelper gzipDecode() {
        this.gzip = true;
        return this;
    }

    public HttpRequestHelper addToHeader(String key, String val) {
        this.config.put(key, val);
        return this;
    }

    public HttpRequestHelper addToHeader(String key, int val) {
        this.config.put(key, String.valueOf(val));
        return this;
    }

    public String request(URL url) throws IOException {
        return request(url, this.config);
    }


    public String request(URL url, Map<String, String> config) throws IOException {
        HttpURLConnection httpURLConn = null;
        try {
            httpURLConn = (HttpURLConnection) url.openConnection();
            if (post) httpURLConn.setRequestMethod("POST");
            httpURLConn.setDoOutput(true);
            for (Map.Entry<String, String> entry : config.entrySet())
                httpURLConn.setRequestProperty(entry.getKey(), entry.getValue());
            httpURLConn.connect();
            InputStream in = httpURLConn.getInputStream();
//            if (gzip) in = new GZIPInputStream(in);
            BufferedReader bd = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String text;
            while ((text = bd.readLine()) != null) builder.append(text);
            String res = builder.toString();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (httpURLConn != null) httpURLConn.disconnect();
        }
    }


}
