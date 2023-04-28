package first.behavioral.state.demo02;

// 一次审查状态
public class Accept1st extends Workflow {

    public Accept1st(Context context) {
        super(context);
    }

    @Override
    public void forward() {
        System.out.println("一次审核通过，进入二次审核阶段。");
        this.context.setWorkflow(new Accept2nd(this.context));
    }

    @Override
    public void backward() {
        System.out.println("一次审核未通过，请整理资料后重新申请。");
        this.context.setWorkflow(new Apply(this.context));
    }
}
