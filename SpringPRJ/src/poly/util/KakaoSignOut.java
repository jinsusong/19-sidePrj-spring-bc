package poly.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
 
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class KakaoSignOut {
	public JsonNode Logout(String autorize_code) {
		/* final String RequestUrl = "https://kapi.kakao.com/v1/user/unlink"; 앱 연결 끊기*/ 
		final String RequestUrl = "https://kapi.kakao.com/v1/user/logout"; 
	    final HttpClient client = HttpClientBuilder.create().build();
	    final HttpPost post = new HttpPost(RequestUrl);

	    post.addHeader("Authorization", "Bearer " + autorize_code);
	    JsonNode returnNode = null;
	
	    try {
	
	        final HttpResponse response = client.execute(post);
	        ObjectMapper mapper = new ObjectMapper();
	        returnNode = mapper.readTree(response.getEntity().getContent());
	
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    }
	    return returnNode;
	}
	
	public JsonNode Unlink(String autorize_code) {
		final String RequestUrl = "https://kapi.kakao.com/v1/user/unlink";
	    final HttpClient client = HttpClientBuilder.create().build();
	    final HttpPost post = new HttpPost(RequestUrl);

	    post.addHeader("Authorization", "Bearer " + autorize_code);
	    JsonNode returnNode = null;
	
	    try {
	
	        final HttpResponse response = client.execute(post);
	        ObjectMapper mapper = new ObjectMapper();
	        returnNode = mapper.readTree(response.getEntity().getContent());
	
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    }
	    return returnNode;
	}
}