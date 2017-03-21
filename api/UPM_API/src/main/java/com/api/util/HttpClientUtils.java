package com.api.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.exception.HttpClientException;
import com.api.exception.HttpConnectionException;

/**
 * HttpClient������
 * 
 * @author HCK
 *
 */
public class HttpClientUtils {
	
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_DELETE = "DELETE";

	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000)
			.setConnectionRequestTimeout(60000).build();

	/**
	 * ����get����
	 * 
	 * @param httpUrl
	 * @return
	 * @throws HttpClientException
	 */
	public static RespJson sendHttpGet(String httpUrl) throws HttpConnectionException, HttpClientException {
		System.out.println("�����ַ��" + httpUrl);
		HttpGet httpGet = new HttpGet(httpUrl);// ����get����
		return sendHttpGet(httpGet);
	}

	/**
	 * ����post��������
	 * 
	 * @param httpUrl
	 * @param jsonParam
	 * @return
	 * @throws HttpClientException
	 */
	public static RespJson sendHttpPost(String httpUrl, String jsonParam)
			throws HttpConnectionException, HttpClientException {
		HttpPost httpPost = new HttpPost(httpUrl);// ����httpPost
		System.out.println("�����ַ��" + httpUrl);
		System.out.println("���������" + jsonParam);
		if (jsonParam != null) {
			// ���ò���
			StringEntity stringEntity = new StringEntity(jsonParam, "UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
		}
		return sendHttpPost(httpPost);
	}
	
	/**
	 * ����put����
	 * 
	 * @param httpUrl
	 * @param jsonParam
	 * @return
	 * @throws HttpClientException
	 */
	public static RespJson sendHttpPut(String httpUrl, String jsonParam)
			throws HttpConnectionException, HttpClientException {
		HttpPut httpPut = new HttpPut(httpUrl);// ����httpPost
		System.out.println("�����ַ��" + httpUrl);
		System.out.println("���������" + jsonParam);
		if (jsonParam != null) {
			// ���ò���
			StringEntity stringEntity = new StringEntity(jsonParam, "UTF-8");
			stringEntity.setContentType("application/json");
			httpPut.setEntity(stringEntity);
		}
		return sendHttpPut(httpPut);
	}
	
	/**
	 * ����delete����
	 * 
	 * @param httpUrl
	 * @return
	 * @throws HttpClientException
	 */
	public static RespJson sendHttpDelete(String httpUrl) throws HttpConnectionException, HttpClientException {
		System.out.println("�����ַ��" + httpUrl);
		HttpDelete httpDelete = new HttpDelete(httpUrl);// ����delete����
		return sendHttpDelete(httpDelete);
	}

	/**
	 * ����get����
	 * 
	 * @param httpGet
	 * @return
	 * @throws HttpClientException
	 */
	private static RespJson sendHttpGet(HttpGet httpGet) throws HttpConnectionException, HttpClientException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			// ����Ĭ�ϵ�httpClientʵ��.
			httpClient = HttpClients.createDefault();
			httpGet.setConfig(requestConfig);
			// ִ������
			response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				if (!entity.getContentType().getValue().equals("application/json")) {
					return RespJsonFactory.buildSuccess();
				} else {
					String responseContent = EntityUtils.toString(entity, "UTF-8");
					return convertToRespJson(responseContent);
				}
//				String responseContent = EntityUtils.toString(entity, "UTF-8");
//				return convertToRespJson(responseContent);
			}
			return RespJsonFactory.buildFailure("���ýӿ��쳣[Status:" + statusCode +"]");
		} catch (HttpHostConnectException e) {
			throw new HttpConnectionException(e.getMessage());
		} catch (Exception e) {
			throw new HttpClientException(e.getMessage());
		} finally {
			try {
				// �ر�����,�ͷ���Դ
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����post����
	 * 
	 * @param httpPost
	 * @return
	 * @throws HttpClientException
	 * @throws HttpConnectionException
	 */
	private static RespJson sendHttpPost(HttpPost httpPost) throws HttpConnectionException, HttpClientException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			// ����Ĭ�ϵ�httpClientʵ��.
			httpClient = HttpClients.createDefault();
			httpPost.setConfig(requestConfig);
			// ִ������
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_CREATED) {
				return RespJsonFactory.buildFailure("���ýӿ��쳣[Status:" + statusCode +"]");
			}
			HttpEntity entity = response.getEntity();
			String responseContent = EntityUtils.toString(entity, "UTF-8");
			return convertToRespJson(responseContent);

		} catch (HttpHostConnectException e) {
			throw new HttpConnectionException(e.getMessage());
		} catch (Exception e) {
			throw new HttpClientException(e.getMessage());
		} finally {
			try {
				// �ر�����,�ͷ���Դ
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ����post����
	 * ע����׼�Ƿ���put���󣬷�������Ҳ�Ƿ���put�������˼��
	 *    �����ڵ�����api�Ĵ����͸��²�������post����
	 *    ������Ȼ���������Ƿ���put�������˼�����������Ƿ���
	 *    post���󣬷���200����ʾ����ɹ�
	 * @param httpPost
	 * @return
	 * @throws HttpClientException
	 * @throws HttpConnectionException
	 */
	private static RespJson sendHttpPut(HttpPut httpPut) throws HttpConnectionException, HttpClientException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			// ����Ĭ�ϵ�httpClientʵ��.
			httpClient = HttpClients.createDefault();
			httpPut.setConfig(requestConfig);
			// ִ������
			response = httpClient.execute(httpPut);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return RespJsonFactory.buildFailure("���ýӿ��쳣[Status:" + statusCode +"]");
			}
			HttpEntity entity = response.getEntity();
			String responseContent = EntityUtils.toString(entity, "UTF-8");
			return convertToRespJson(responseContent);

		} catch (HttpHostConnectException e) {
			throw new HttpConnectionException(e.getMessage());
		} catch (Exception e) {
			throw new HttpClientException(e.getMessage());
		} finally {
			try {
				// �ر�����,�ͷ���Դ
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ����delete����
	 * 
	 * @param httpDelete
	 * @return
	 * @throws HttpClientException
	 */
	private static RespJson sendHttpDelete(HttpDelete httpDelete) throws HttpConnectionException, HttpClientException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			// ����Ĭ�ϵ�httpClientʵ��.
			httpClient = HttpClients.createDefault();
			httpDelete.setConfig(requestConfig);
			// ִ������
			response = httpClient.execute(httpDelete);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_NO_CONTENT) {
				return RespJsonFactory.buildSuccess();
			}
			return RespJsonFactory.buildFailure("���ýӿ��쳣[Status:" + statusCode +"]");
		} catch (HttpHostConnectException e) {
			throw new HttpConnectionException(e.getMessage());
		} catch (Exception e) {
			throw new HttpClientException(e.getMessage());
		} finally {
			try {
				// �ر�����,�ͷ���Դ
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	private static RespJson convertToRespJson(String responseContent) {
		if (responseContent.startsWith("{")) {
			return RespJsonFactory.buildSuccess(JSONObject.parseObject(responseContent));
		} else if (responseContent.startsWith("[")) {
			return RespJsonFactory.buildSuccess(JSONArray.parseArray(responseContent));
		} else {
			return RespJsonFactory.buildSuccess();
		}
	}
}
