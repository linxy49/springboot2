package com.line.delivey.domain.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class SlackService {

  /**
   * send email.
   * @return
   * @throws IOException
   * @throws ClientProtocolException
   */
  public String send() throws ClientProtocolException, IOException {



    String url = "https://slack.com/api/chat.postMessage";
    String token = "";

    Map<String, String> map = new HashMap<String, String>();
    map.put("channel", "#general");
    map.put("text", "メッセージ @bryan");
    map.put("username", "bryan");
    map.put("token", token);

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("channel", "#general"));
    params.add(new BasicNameValuePair("text", "メッセージ @bryan"));
    params.add(new BasicNameValuePair("username", "bryan"));
    params.add(new BasicNameValuePair("token", token));

    HttpPost httpPost = new HttpPost(url);

    Gson gson = new Gson();
    String json = gson.toJson(map);

    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//    httpPost.setEntity(new StringEntity(json, "UTF-8"));
    CloseableHttpClient client = HttpClients.createDefault();
    CloseableHttpResponse response = client.execute(httpPost);
    String result = EntityUtils.toString(response.getEntity());
    client.close();
    return result;
  }
}