package first.behavioral.template_method.demo02;

public abstract class DBConnection {
    // 模板方法
    public void templateExecute() {
        System.out.println("读取数据库链接配置文件"); // 不变的代码1
        this.execute();
        System.out.println("数据库链接成功"); // 不变的代码2
    }

    public abstract void execute();
}
