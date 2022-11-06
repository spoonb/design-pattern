package behavioral.state.demo02;

// 二次审查状态
public class Accept2nd extends Workflow {

    public Accept2nd(Context context) {
        super(context);
    }

    @Override
    public void forward() {
        System.out.println("二次审核通过，进入三次审核阶段。");
        this.context.setWorkflow(new Accept3rd(this.context));
    }

    @Override
    public void backward() {
        System.out.println("一次审核未通过，请整理资料后重新申请。");
        this.context.setWorkflow(new Accept1st(this.context));
    }
}
