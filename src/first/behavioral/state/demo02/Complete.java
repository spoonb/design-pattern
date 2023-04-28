package first.behavioral.state.demo02;

// 完成状态
public class Complete extends Workflow {

    public Complete(Context context) {
        super(context);
    }

    @Override
    public void forward() {
        throw new RuntimeException("不支持此功能，请联系管理员！");
    }

    @Override
    public void backward() {
        throw new RuntimeException("不支持此功能，请联系管理员！");
    }
}
