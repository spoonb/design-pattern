package first.behavioral.state.demo02;

// 抽象工作流
public abstract class Workflow {

    // 持有一个上下文对象，与上下文对象中持有的工作流对象组成类似双向指针
    protected Context context;

    public Workflow(Context context) {
        this.context = context;
    }

    // 提交操作
    public abstract void forward();

    // 回退操作
    public abstract void backward();
}
