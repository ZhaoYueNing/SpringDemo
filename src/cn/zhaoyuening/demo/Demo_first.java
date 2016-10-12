package cn.zhaoyuening.demo;


import cn.zhaoyuening.model.Persion;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by buynow on 16-10-12.
 */
public class Demo_first {
    private ClassPathXmlApplicationContext beanContext = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void test() {
        Persion p = beanContext.getBean("worker",Persion.class);
        p.useTool();
    }

    @Test
    public void test2() throws Exception {
        Persion p1 = beanContext.getBean("worker", Persion.class);
        Persion p2 = beanContext.getBean("worker", Persion.class);
        System.out.println(p1==p2);
        //结果为true 为同一个对象
    }

    @Test
    //构造注入
    public void test3() throws Exception {
        Persion p = beanContext.getBean("worker2", Persion.class);
        p.useTool();
    }

    @Test
    public void test_contextApi() throws Exception {

    }
}
