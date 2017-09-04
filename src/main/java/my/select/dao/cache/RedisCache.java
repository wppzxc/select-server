package my.select.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import my.select.netData.down.course.NetCourse;
import my.select.netData.down.select.GetSelectDown;
import my.select.netData.login.NetUser;
import my.select.netData.up.select.GetSelectUp;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by wpp on 2017/5/22.
 */

public class RedisCache {
    private final JedisPool jedisPool;
    private Schema<GetSelectDown> selectSchema = RuntimeSchema.createFrom(GetSelectDown.class);
    private Schema<NetUser> userSchema = RuntimeSchema.createFrom(NetUser.class);
    private Schema<NetCourse> courseSchema = RuntimeSchema.createFrom(NetCourse.class);
    private Integer timeout = 60 * 60;
    public RedisCache(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public List<GetSelectDown> getSelects(GetSelectUp up) {
        try {
            Jedis jedis = jedisPool.getResource();
            try{
                byte[] bytes = jedis.get(up.toString().getBytes());
                if(bytes != null){
                    List<GetSelectDown> select = null;
                    select = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), selectSchema);
                    return select;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String setSelects(GetSelectUp up,List<GetSelectDown> selects){
        try{
            Jedis jedis = jedisPool.getResource();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try{
                ProtostuffIOUtil.writeListTo(bos,selects, selectSchema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                byte[] bytes = bos.toByteArray();
                String result = jedis.setex(up.toString().getBytes(),5,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer getSelectCount(GetSelectUp up){
        try {
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "{name:" + up.getName() + ",state:" + up.getState() + ",offset:" + up.getOffset() + "}";
                String countStr = jedis.get(key);
                if(countStr != null){
                    return Integer.parseInt(countStr);
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String setSelectCount(GetSelectUp up,Integer count){
        try{
            Jedis jedis = jedisPool.getResource();
            String key = "{name:" + up.getName() + ",state:" + up.getState() + ",offset:" + up.getOffset() + "}";
            try{
                return jedis.setex(key,5,count+"");
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<NetUser> getUsers(String key) {
        try {
            Jedis jedis = jedisPool.getResource();
            try{
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes != null){
                    List<NetUser> users = null;
                    users = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), userSchema);
                    return users;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String setUsers(String key,List<NetUser> users){
        try{
            Jedis jedis = jedisPool.getResource();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try{
                ProtostuffIOUtil.writeListTo(bos,users, userSchema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                byte[] bytes = bos.toByteArray();
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<NetCourse> getCourses(String key) {
        try {
            Jedis jedis = jedisPool.getResource();
            try{
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes != null){
                    List<NetCourse> courses = null;
                    courses = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), courseSchema);
                    return courses;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String setCourses(String key,List<NetCourse> courses){
        try{
            Jedis jedis = jedisPool.getResource();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try{
                ProtostuffIOUtil.writeListTo(bos,courses, courseSchema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                byte[] bytes = bos.toByteArray();
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
