## 简述

使得对象的行为**根据状态变化而变化**。

> **根据状态变化而变化**
> 打个比方，网站登录时通常会有游客、会员、VIP等权限，根据不同的权限可以限制用户的行为，就这样。

话不多说，看个案例。

## 优化案例

现在有个工作流的业务需要实现，简易流程为：申请 --> 一次审核 --> 二次审核 --> 三次审核 --> 完成。
现在想要实现的需求中包含提交与退回，举个例子就是如果申请的一次审核通过则进入二次审核阶段，如果不通过则回到申请阶段重新申请，这个需求适用于除完成外的所有阶段。

### 最初版v0

不使用状态模式来实现的话，请看以下案例。

```java
public class Client {
    private static String flag = "apply";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("是否提交申请?(y/n)");
        if ("y".equals(sc.next())) {
            System.out.println("申请已提交，请等待审查。");
            flag = "accept1st";
        } else {
            System.out.println("申请已撤销。");
            return;
        }
        for (;;) {
            if ("accept1st".equals(flag)) {
                if ("y".equals(sc.next())) {
                    System.out.println("一次审核通过，进入二次审核阶段。");
                    flag = "accept2nd";
                } else {
                    System.out.println("一次审核未通过，请整理资料后重新申请。");
                    break;
                }
            } else if ("accept2nd".equals(flag)) {
                if ("y".equals(sc.next())) {
                    System.out.println("二次审核通过，进入三次审核阶段。");
                    flag = "accept3rd";
                } else {
                    System.out.println("二次审核未通过，回到一次审核阶段。");
                    flag = "accept1st";
                }
            } else if ("accept3rd".equals(flag)) {
                if ("y".equals(sc.next())) {
                    System.out.println("三次审核通过，恭喜您的申请已通过。");
                    flag = "complete";
                    break;
                } else {
                    System.out.println("三次审核未通过，回到二次审核阶段。");
                    flag = "accept2nd";
                }
            }
        }
    }
}
```

为了实现需求，我们写了很多的if条件，代码及其的冗长。那么，有没有什么方法既实现需求，又减少if条件呢。

诶，还真有，那就是状态模式。

### 修改版v1

```java
// 客户端
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Context context = new Context();
        System.out.print("是否提交申请?(y/n): ");
        do {
            try {
                context.execute("y".equals(sc.next()));
                System.out.println();
                System.out.print("是否审核通过?(y/n): "); // 这是个为了说明状态模式的案例，不用纠结提示语不够明确的问题
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return; // 结束工作流
            }
        } while (true);
    }
}

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
```

经过以上修改，客户端的代码变得异常的优美。状态模式就是这样一种设计模式。主要的思想是通过修改上下文对象中持有的状态对象来修改状态，使用起来的效果就想完全换了一个对象一样，而实际上只是更换了当前对象中持有的状态对象而已。在保证客户端调用方便(不用写if条件)的同时，又可以做到功能的切换，方便。不过这个设计模式的缺点也是非常的明显，就是肉眼可见的类的激增(这加的可不要太多)。

## 总结

### 优点

- 更换上下文对象中持有的状态对象以实现功能的变换，不会让客户端察觉。

  > **让客户端察觉**
  > 客户端需要根据返回值，或者对象内部持有的状态属性来增加if条件语句。
  > 而不让客户端察觉就是在客户端不需要写条件语句。我们写条件语句的目的就是为了限制程序的执行实现功能上的变化，而使用状态模式，可以不写条件语句自然而然的随着流程的进行自行变换功能。

### 缺点

- 类的激增使得系统变得越发庞大。

### 适用场景

- 各种类工作流功能的实现。
