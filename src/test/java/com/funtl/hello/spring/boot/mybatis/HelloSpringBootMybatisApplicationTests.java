package com.funtl.hello.spring.boot.mybatis;

import com.funtl.hello.spring.boot.mybatis.dao.UserMapper;
import com.funtl.hello.spring.boot.mybatis.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HelloSpringBootMybatisApplication.class)
@Transactional
@Rollback
public class HelloSpringBootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void testPage(){
        PageHelper.startPage(1,10);
        Example example = new Example(User.class);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectByExample(example));
        List<User> list = pageInfo.getList();
        for (User user : list) {
            System.out.println(user.getName());
        }
    }

}
