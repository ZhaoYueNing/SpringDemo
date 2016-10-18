package cn.zhaoyuening.model;

/**
 * Created by buynow on 16-10-18.
 */
public abstract class Chinaese implements Persion{
    private String name;

    @Override
    public void useTool() {
        getTool().use();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    abstract public Tool getTool() ;
}
