//package cn.ztejjx.memberstore;
//
//import cn.ztejjx.memberstore.domain.mysql.memberIntegral;
//import cn.ztejjx.memberstore.service.memberIntegralService;
//import cn.ztejjx.memberstore.service.voteDetailService;
//import cn.ztejjx.memberstore.utils.RedisUtils;
//import net.sf.json.JSONObject;
//import org.apache.commons.lang.StringUtils;
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.*;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.List;
//
//@SpringBootTest
//class StoreMysqlApplicationTests {
//
//	@Autowired
//	private RedisUtils redisUtil;
//
//	@Autowired
//	private voteDetailService voteDetailService;
//
//
//
//	private static String current_access_token = null;
//
//	@Autowired
//	private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;
//
//	@Autowired
//	private cn.ztejjx.memberstore.service.memberIntegralService memberIntegralService;
//
//
//	@Test
//	public void datetest()
//	{
//		Calendar cal = Calendar.getInstance();
//
//		int year = cal.get(Calendar.YEAR);
//		int month = cal.get(Calendar.MONTH)+1;
//		int day = cal.get(Calendar.DATE);
//
//		String startDate = year+"-"+month+"-"+1;
//		String endDate = year+"-"+month+"-"+day;
//
//		System.out.println(startDate);
//		System.out.println(endDate);
//
//	}
//	@Test
//	public void sumIntegral() throws  Exception
//	{
////		List<String> list =  memberIntegralService.findAllMemberId ();
////		System.out.println(list.size());
////		for(int i=0;i<list.size();i++)
////		{
////			System.out.println(list.get(i));
////			String MemberId = list.get(i);
////
////
//// 		if(!StringUtils.isEmpty(MemberId))
////			{
////
////		     int integral =  memberIntegralService.countMemberIntegral(MemberId);
////				System.out.println(integral);
////
////
////			 memberInfoService.updateMemberIntegral(MemberId,integral);
////
////
////			}
////
////		}
//	}
//
//
//	@Test
//	void contextLoads() {
//
////		System.out.println("1");
////		String url = "https://api.weixin.qq.com/cgi-bin/token?" +
////				"grant_type=client_credential" +
////				"&appid=wx38e88b7f48911036" +
////				"&secret=8cb090f7e9410988e5f771415308dce4";
////		String accessToken = sendGet(url);
////		JSONObject json = JSONObject.fromObject(accessToken);
////		int count = Integer.parseInt(json.getString("expires_in"));
////		String token = json.getString("access_token");
////		redisUtil.set("myaccess_token",token,count);
////		current_access_token  = token;
//
////		 if(redisUtil.get("myaccess_token") ==null)
////		 {
////		 	 System.out.println("1");
////			 String url = "https://api.weixin.qq.com/cgi-bin/token?" +
////					 "grant_type=client_credential" +
////					 "&appid=wx38e88b7f48911036" +
////					 "&secret=8cb090f7e9410988e5f771415308dce4";
////			 String accessToken = sendGet(url);
////			 JSONObject json = JSONObject.fromObject(accessToken);
////			 int count = Integer.parseInt(json.getString("expires_in"));
////			 String token = json.getString("access_token");
////			 redisUtil.set("myaccess_token",token,count);
////			 current_access_token  = token;
////		 }
////		   else
////		 {
////			 System.out.println("2");
////			 current_access_token = 	 (String)redisUtil.get("myaccess_token");
////		 }
//
//
////		String url2= " https://api.weixin.qq.com/wxa/getuserriskrank?access_token="+current_access_token;
////		JSONObject jsonObject = new JSONObject();
////		jsonObject.put("appid","wx38e88b7f48911036");
////		jsonObject.put("openid","omrob0XdldgCLiEZqZDZqT1aUnz4");
////		jsonObject.put("scene", 1);
////		jsonObject.put("client_ip", "127.0.0.1");
////		String result = 	sendPost(url2,jsonObject.toString());
////		System.out.println(result);
//
////		List<String> openidlist =  voteDetailService.findopenIdVoteDetailByemployeeName("阮文");
////		openidlist.stream().forEach(
////				s-> {
////
////
////
////				}
////
////		);
//
//
//
//	}
//
//
////	public static String sendPost(String url, String param )
////	{
////		BufferedReader in=null;
////		String result = null;
////		PrintWriter out = null;
////
////		try {
////			URL realUrl = new URL(url);
////			URLConnection conn = realUrl.openConnection();
////			conn.setRequestProperty("accept", "*/*");
////			conn.setRequestProperty("connection", "Keep-Alive");
////			conn.setRequestProperty("user-agent",
////					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
////			conn.setDoOutput(true);
////			conn.setDoInput(true);
////			out = new PrintWriter(conn.getOutputStream());
////			out.print(param);
////			out.flush();
////
////			in = new BufferedReader(new InputStreamReader(
////					conn.getInputStream()));
////			String line;
////			while ((line = in.readLine()) != null) {
////				result += line;
////			}
////
////
////
////		} catch (Exception e) {
////
////			e.printStackTrace();
////		}
////		finally{
////			try {
////				if (in != null) {
////					in.close();
////				}
////
////				if(out!=null){
////					out.close();
////				}
////			} catch (Exception e2) {
////				e2.printStackTrace();
////			}
////		}
////		return result.replace("null","");
////
////
////
////	}
////
////	public static byte[] readInputStream(InputStream inStream) throws Exception{
////		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
////		byte[] buffer = new byte[1024];
////		int len = 0;
////		while( (len=inStream.read(buffer)) != -1 ){
////			outStream.write(buffer, 0, len);
////		}
////		inStream.close();
////		return outStream.toByteArray();
////	}
////
////
////	public static String sendGet(String url){
////		BufferedReader in=null;
////		String result = null;
////		try {
////			String urlNameString=url;
////			URL realurl = new URL(urlNameString);
////			URLConnection connection=realurl.openConnection();
////			// 设置通用的请求属性
////			connection.setRequestProperty("accept", "*/*");
////			connection.setRequestProperty("connection", "Keep-Alive");
////			connection.setRequestProperty("Encoding", "utf-8");
////			connection.setRequestProperty("user-agent",
////					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
////			// 建立实际的连接
////			connection.connect();
////			// 定义 BufferedReader输入流来读取URL的响应
////			in = new BufferedReader(new InputStreamReader(
////					connection.getInputStream()));
////			String line;
////			while ((line = in.readLine()) != null) {
////				result += line;
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		// 使用finally块来关闭输入流
////		finally {
////			try {
////				if (in != null) {
////					in.close();
////				}
////			} catch (Exception e2) {
////				e2.printStackTrace();
////			}
////		}
////		return result.replace("null","");
////	}
//
//}
