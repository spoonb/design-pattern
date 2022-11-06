package creational.abstract_factory.demo03;

// 抽象的工厂接口
public interface Factory {
   	Uploader uploader();
    Downloader downloader();
}