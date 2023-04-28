package first.behavioral.template_method.demo02;

public class Client {
    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.templateExecute(); // 使用jdbc连接数据库
        JNDI jndi = new JNDI();
        jndi.templateExecute(); // 使用jndi连接数据库
        ODBC odbc = new ODBC();
        odbc.templateExecute(); // 使用odbc连接数据库
    }
}
