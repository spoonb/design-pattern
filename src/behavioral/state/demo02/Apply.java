package behavioral.state.demo02;

// 申请状态
public class Apply extends Workflow {

    public Apply(Context context) {
        super(context);
    }

    @Override
    public void forward() {
        System.out.println("申请已提交，请等待审查。");
        this.context.setWorkflow(new Accept1st(this.context));
    }

    @Override
    public void backward() {
        throw new RuntimeException("申请已撤销。");
    }
}
