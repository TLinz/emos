package com.linzzxz.emos.config.xss;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HtmlUtil;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if(!StrUtil.hasEmpty(value)) {
            value = HtmlUtil.filter(value);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        filterVals(values);
        return values;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> params = super.getParameterMap();
        // 保证顺序一致
        Map<String, String[]> res = new LinkedHashMap<>();
        if(params != null) {
            for (String key : params.keySet()) {
                String[] values = params.get(key);
                filterVals(values);
                res.put(key, values);
            }
        }
        return res;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if(!StrUtil.hasEmpty(value)) {
            value = HtmlUtil.filter(value);
        }
        return value;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        InputStream inStream = super.getInputStream();
        InputStreamReader isReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
        BufferedReader bufReader = new BufferedReader(isReader);
        StringBuilder body = new StringBuilder();
        String line = bufReader.readLine();
        while(line != null) {
            body.append(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        isReader.close();
        inStream.close();

        Map<String, Object> bodyMap = JSONUtil.parseObj(body.toString());
        Map<String, Object> res = new LinkedHashMap<>();
        for(String key : bodyMap.keySet()) {
            Object val = bodyMap.get(key);
            if(val instanceof String) {
                if(!StrUtil.hasEmpty(val.toString())) {
                    res.put(key, HtmlUtil.filter(val.toString()));
                }
            } else {
                res.put(key, val);
            }
        }
        String bodyJson = JSONUtil.toJsonStr(res);
        ByteArrayInputStream bytesInStream = new ByteArrayInputStream(bodyJson.getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bytesInStream.read();
            }
        };
    }

    private void filterVals(String[] values) {
        if(values != null) {
            for(int i = 0; i < values.length; i++) {
                String value = values[i];
                if(!StrUtil.hasEmpty(value)) {
                    value = HtmlUtil.filter(value);
                }
                values[i] = value;
            }
        }
    }
}
