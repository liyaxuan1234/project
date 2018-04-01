package com.ht.mapper;

import com.ht.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    List<User> getUserAll();
    User selectUser(Integer id);
    void delete(Integer id);
    void update(User user);
    void addUser(User user);
    Long count();
}
