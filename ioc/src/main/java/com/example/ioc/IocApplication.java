package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

		// Encoder encoder = new Encoder();
		// String result = encoder.encode(url);
		// System.out.println("Encoder : ----------------");
		// System.out.println(result);

		// UrlEncoder urlEncoder = new UrlEncoder();
		// String urlResult = urlEncoder.encode(url);
		// System.out.println("url Encoder : ----------------");
		// System.out.println(urlResult);

		// IEncoder를 쓴경우
		IEncoder encoder = new Base64Encoder();
		String result = encoder.encode(url);
		System.out.println("Encoder : ----------------");
		System.out.println(result);

		IEncoder urlEncoder = new UrlEncoder();
		String urlResult = urlEncoder.encode(url);
		System.out.println("url Encoder : ----------------");
		System.out.println(urlResult);

		// DI적용 전
		// Encoder encoder2 = new Encoder();
		// String result2 = encoder2.encode(url);
		// System.out.println("Encoder2 : ----------------");
		// System.out.println(result2);

		// DI 적용 후
		Encoder encoder2 = new Encoder(new Base64Encoder());
		String result2 = encoder2.encode(url);
		System.out.println("Encoder2 : ----------------");
		System.out.println(result2);

		// 외부에서 주입을 받는게 DI임 위존 가진것을 넘겨주는거.

		SpringApplication.run(IocApplication.class, args);
		ApplicationContext context = ApplicationContextProvider.getContext();

		Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
		UrlEncoder urlEncoder2 = context.getBean(UrlEncoder.class);
		Encoder encoder3 = new Encoder(base64Encoder);
		String result3 = encoder3.encode(url);
		System.out.println("Encoder3 : ----------------");
		System.out.println(result3);

		encoder3.setIEncoder(urlEncoder2);
		String result4 = encoder3.encode(url);
		System.out.println("Encoder4 : ----------------");
		System.out.println(result4);

		Encoder encoder5 = context.getBean("base64Encode", Encoder.class);
		System.out.println("Encoder5 : ----------------");
		String result5 = encoder5.encode(url);
		System.out.println(result5);
	}

}

@Configuration
class AppConfig {

	@Bean("base64Encode")
	public Encoder encoder(Base64Encoder base64Encoder) {
		return new Encoder(base64Encoder);
	}

	@Bean("UrlEncode")
	public Encoder encoder(UrlEncoder urlEncoder) {
		return new Encoder(urlEncoder);
	}
}