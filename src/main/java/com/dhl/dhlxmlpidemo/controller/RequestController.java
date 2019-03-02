package com.dhl.dhlxmlpidemo.controller;

import com.dhl.dhlxmlpidemo.service.RequestService;
import com.dhl.dhlxmlpidemo.service.impl.RequestServiceImpl;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
public class RequestController {


    @Autowired
    RequestService requestService;

    @RequestMapping(value = "/getShippment", method = RequestMethod.GET)
    @ResponseBody
    public void getShippment() throws IOException {

        String testUrl = "https://xmlpitest-ea.dhl.com/XMLShippingServlet";
        String url = "https://xmlpi-ea.dhl.com/XMLShippingServlet";

        RequestServiceImpl requestService = new RequestServiceImpl();
        String shippmentRequest = requestService.getShippment();

        HttpPost httpPost = new HttpPost(testUrl);
        HttpEntity httpEntity = new StringEntity(shippmentRequest, "utf-8");
        httpPost.setEntity(httpEntity);
        HttpClient httpClient = new DefaultHttpClient();
        HttpParams clientParams = httpClient.getParams();

        clientParams.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        clientParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000);
        clientParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

        HttpResponse httpResponse = httpClient.execute(httpPost);

        HttpEntity responsetEntity = httpResponse.getEntity();
        InputStream inputStream = responsetEntity.getContent();
        OutputStream outputStream = new FileOutputStream("/Users/apple/Documents/resqonse.xml");
        StringBuilder reponseXml = new StringBuilder();
        byte[] b = new byte[2048];
        int length = 0;
        while ((length = inputStream.read(b)) != -1) {
            reponseXml.append(new String(b, 0, length));
            outputStream.write(b, 0, length);
        }

        System.out.println(reponseXml);

    }
}
