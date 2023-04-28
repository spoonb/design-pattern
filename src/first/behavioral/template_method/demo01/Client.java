package first.behavioral.template_method.demo01;

public class Client {
    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.execute(); // 使用jdbc连接数据库
        JNDI jndi = new JNDI();
        jndi.execute(); // 使用jndi连接数据库
        ODBC odbc = new ODBC();
        odbc.execute(); // 使用odbc连接数据库
    }
}
