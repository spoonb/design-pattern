package behavioral.command.demo02;

// receiver
public class Server {
    private String ip;
    private String domain;

    public Server(String ip, String domain) {
        this.ip = ip;
        this.domain = domain;
    }

    public void upload() {
        System.out.printf("资源上传 --> %s[%s]\n", this.domain, this.ip);
    }

    public void test() {
        System.out.printf("资源测试 --> %s[%s]\n", this.domain, this.ip);
    }

    public void release() {
        System.out.printf("资源发布 --> %s[%s]\n", this.domain, this.ip);
    }
}
