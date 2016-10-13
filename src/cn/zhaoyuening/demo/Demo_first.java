package cn.zhaoyuening.demo;


import cn.zhaoyuening.event.GetUpEvent;
import cn.zhaoyuening.model.Persion;
import cn.zhaoyuening.model.Worker;
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
        Persion p3 = beanContext.getBean("worker3", Persion.class);
        Persion p4 = beanContext.getBean("worker3", Persion.class);
        //单列
        System.out.println(p1==p2);
        //原型 每次获取生成新的实例
        System.out.println(p3==p4);
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

    @Test
    //测试事件
    public void test4() throws Exception {
        GetUpEvent event = new GetUpEvent("test");
        Persion p = new Worker();
        p.setName("zhao");
        event.setPersion(p);
        beanContext.publishEvent(event);
    }
}
