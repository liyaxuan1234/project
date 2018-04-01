package com.ht.service.impl;

import com.ht.mapper.UserMapper;
import com.ht.pojo.User;
import com.ht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
//https://github.com/ObjectError/RedisCluster-Web
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

   @Transactional(readOnly = false)
   public List<User> getUserAll() {
        List<User> userList=new ArrayList<>();
       HashOperations<String,String,User> hashOperations=redisTemplate.opsForHash();
       Long size=hashOperations.size("userList");
       Long count=userMapper.count();
       if(size>0 && size==count){
//           System.out.println("从hash缓存里拿数据");/
           List<User> users=new ArrayList<>();
           users=hashOperations.values("userList");
           for(int i=0;i<users.size();i++){
               userList.add(users.get(i));
           }
       }else{
           System.out.println("从数据库里拿值");
           userList=userMapper.getUserAll();
           Map<String,User> map=new HashMap<>();
           for(int i=0;i<userList.size();i++){
               User user=userList.get(i);
               map.put("user-"+user.getId(),user);
           }
           hashOperations.putAll("userList",map);
       }
       return userList;
   }
    public User selectUser(Integer id) {
        HashOperations hashOperations=redisTemplate.opsForHash();
        Boolean isExite=hashOperations.hasKey("userList","user-"+id);
        if(isExite){
            System.out.println("从缓存中拿数据");
            User user=(User)hashOperations.get("userList","user-"+id);
            return user;
        }else {
            System.out.println("从数据库里拿");
            User user = userMapper.selectUser(id);
            if(user!=null){
                hashOperations.put("userList","user-"+id,user);
            }
            return user;
        }
    }

    public void delete(Integer id) {
      HashOperations hashOperations=redisTemplate.opsForHash();
      Boolean isExite =hashOperations.hasKey("userList","user-"+id);
      if(isExite){
          hashOperations.delete("userLit","user-"+id);
          System.out.println("删除缓存里的数据");
      }
        userMapper.delete(id);
    }

    public void update(User user) {
       HashOperations hashOperations=redisTemplate.opsForHash();
       hashOperations.put("userList","user-"+user.getId(),user);
        System.out.println("缓存已修改");
        userMapper.update(user);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public Long count() {
       Long count=userMapper.count();
        return count;
    }


}
