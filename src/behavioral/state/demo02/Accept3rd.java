package behavioral.state.demo02;

// 三次审查状态
public class Accept3rd extends Workflow {

    public Accept3rd(Context context) {
        super(context);
    }

    @Override
    public void forward() {
        this.context.setWorkflow(new Complete(this.context));
        throw new RuntimeException("三次审核通过，恭喜，申请已完成。");
    }

    @Override
    public void backward() {
        System.out.println("一次审核未通过，请整理资料后重新申请。");
        this.context.setWorkflow(new Accept2nd(this.context));
    }
}
