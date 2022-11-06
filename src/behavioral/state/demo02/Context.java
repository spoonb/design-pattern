package behavioral.state.demo02;

// 上下文
public class Context {

    // 持有一个工作流对象，实际的具体操作都封装在工作流操作中
    private Workflow workflow;

    // 修改上下文对象持有的工作流对象以改变状态。
    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public Context() {
        this.workflow = new Apply(this); // 只可以从申请提交阶段开始，不可以跳阶段创建对象。
    }

    // 根据传入flag的值来决定流的提交或是回退
    public void execute(boolean flag) {
        if (flag) {
            workflow.forward();
        } else {
            workflow.backward();
        }
    }
}
