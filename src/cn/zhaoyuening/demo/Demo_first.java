package cn.zhaoyuening.demo;


import cn.zhaoyuening.event.GetUpEvent;
import cn.zhaoyuening.model.Chinaese;
import cn.zhaoyuening.model.Persion;
import cn.zhaoyuening.model.Student;
import cn.zhaoyuening.model.Worker;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by buynow on 16-10-12.
 */
public class Demo_first {
    private ClassPathXmlApplicationContext beanContext = new ClassPathXmlApplicationContext("beans.xml");
    public Demo_first(){
        //注册关闭钩
        //关闭jvm前释放资源
        beanContext.registerShutdownHook();
    }

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

    @Test
    public void test5() throws Exception {
        //使用嵌套bean
        Persion p = beanContext.getBean("worker3",Persion.class);
        p.useTool();
    }

    @Test
    public void test_initanddestory() throws Exception {
        Persion p = beanContext.getBean("worker4", Persion.class);
        p.useTool();
    }

    @Test
    public void test6() throws Exception {
        Student s = beanContext.getBean("stu1", Student.class);
        for (String school:
                s.getSchools()) {
            System.out.println(school);
        }
    }

    @Test
    public void test7() throws Exception {
        //协调作用域不同的方法
        //使用lookup方法
        Chinaese p1 = beanContext.getBean("chinaese",Chinaese.class);
        Chinaese p2 = beanContext.getBean("chinaese",Chinaese.class);
        System.out.println("p1==p2?"+(p1==p2));
        System.out.println("p1.tool==p2.tool?"+(p1.getTool()==p2.getTool()));
    }

    @Test
    //获取其他bean的属性
    //通过工厂Bean
    public void test8() throws Exception {

    }
}
