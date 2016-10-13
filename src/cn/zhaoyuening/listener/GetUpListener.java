package cn.zhaoyuening.listener;

import cn.zhaoyuening.event.GetUpEvent;
import cn.zhaoyuening.model.Persion;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * Created by buynow on 16-10-12.
 */
public class GetUpListener implements ApplicationListener<GetUpEvent> {
    @Override
    public void onApplicationEvent(GetUpEvent getUpEvent) {
        Persion p = getUpEvent.getPersion();
        System.out.println(p.getName()+" need get up"+new Date());
    }
}
