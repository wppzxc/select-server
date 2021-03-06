package my.select.service;

import my.select.netData.down.teach.GetTeachOptionsDown;
import my.select.netData.up.teach.GetTeachOptionsUp;
import my.select.netData.up.teach.GetTeachUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wpp on 2017/5/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TeachServiceTest {
    @Resource
    private TeachService teachService;
    @Test
    public void getAllTeach() throws Exception {
        GetTeachUp up = new GetTeachUp();
        up.setState(1);
//        up.setUserId(4);
        System.out.println(teachService.getAllTeach(up));
    }

    @Test
    public void getTeachOptions(){
        GetTeachOptionsUp up = new GetTeachOptionsUp();
        up.setArg("C");
        List<GetTeachOptionsDown> list = teachService.getTeachOptions(up);
        System.out.println("list={}"+list);
    }

}