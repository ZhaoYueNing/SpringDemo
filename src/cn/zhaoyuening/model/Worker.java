package cn.zhaoyuening.model;

/**
 * Created by buynow on 16-10-12.
 */
public class Worker implements Persion{
    private String name;
    private Tool tool;

    public Worker(){};

    public Worker(Tool tool) {
        this.tool = tool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    @Override
    public void useTool() {
        System.out.println(this.name+" 使用 "+tool.use());
    }
}
