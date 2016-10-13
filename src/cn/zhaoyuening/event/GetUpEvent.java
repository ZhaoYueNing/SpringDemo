package cn.zhaoyuening.event;

import cn.zhaoyuening.model.Persion;
import org.springframework.context.ApplicationEvent;

/**
 * Created by buynow on 16-10-12.
 */
public class GetUpEvent extends ApplicationEvent{
    private Persion persion;

    public GetUpEvent(Object source) {
        super(source);
    }


    public void setPersion(Persion persion) {
        this.persion = persion;
    }

    public Persion getPersion() {
        return persion;
    }
}
