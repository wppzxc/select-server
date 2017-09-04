package my.select.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by wpp on 2017/4/27.
 */
public class StringUtil {
    public static String ObjectToJsonString(Object object){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try{
            jsonString = mapper.writeValueAsString(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonString;
    }
}
