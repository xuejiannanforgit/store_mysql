package cn.ztejjx.memberstore.intercepter;

import cn.ztejjx.memberstore.utils.ResultUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

@Component
public class noTokenValidateInterceptor implements HandlerInterceptor {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Value("${SecretKey}")
    private String SecretKey;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        response.setContentType("text/html;charset=utf-8");

        String sign =	request.getParameter("sign");
        String nonceStr =	request.getParameter("nonceStr");
        String timestamp =	request.getParameter("timestamp");




        if(sign==null&&nonceStr==null&&timestamp==null)
        {
             sign =	request.getHeader("sign");
             nonceStr =	request.getHeader("nonceStr");
             timestamp =	request.getHeader("timestamp");
        }




        //校验参数不能为空
        if(sign==null||nonceStr==null||timestamp==null||sign.equals("")||nonceStr.equals("")||timestamp.equals(""))
        {
            ResultUtils resultUtils =	 ResultUtils.build(0, "校验参数不能为空");
            String jsonStr = objectMapper.writeValueAsString(resultUtils);
            renderJson(response,jsonStr);
            return false;
        }

        if(getDistanceTime(System.currentTimeMillis(),Long.valueOf(timestamp))>=5) //数据访问时间间隔大于5分钟
        {
            ResultUtils resultUtils =	 ResultUtils.build(0, "连接超时");
            String jsonStr = objectMapper.writeValueAsString(resultUtils);
            renderJson(response,jsonStr);
            return false;
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("secretKey",SecretKey);
        map.put("nonceStr",nonceStr );
        SortedMap<String, Object> sort = new TreeMap<String, Object>(map);
        Set<Map.Entry<String, Object>> entry1 = sort.entrySet();
        Iterator<Map.Entry<String, Object>> it = entry1.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String k = entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("timestamp="+timestamp);

        String md5Value = DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
        if(md5Value.equals(sign))
        {
            //签名校验通过,拦截器放行
            return true;
        }
        else
        {
            ResultUtils resultUtils =	 ResultUtils.build(0, "签名校验失败");
            String jsonStr = objectMapper.writeValueAsString(resultUtils);
            renderJson(response,jsonStr);
            return false;
        }
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    private void renderJson(HttpServletResponse response, String json){
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter writer = response.getWriter()){
            writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static long getDistanceTime(long currenttime, long timestamp) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long diff = currenttime - timestamp;
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
//	    if (day != 0) return day + "天"+hour + "小时"+min + "分钟" + sec + "秒";
//	    if (hour != 0) return hour + "小时"+ min + "分钟" + sec + "秒";
//	    if (min != 0) return min + "分钟" + sec + "秒";
//	    if (sec != 0) return sec + "秒" ;
        return min;
    }

}


