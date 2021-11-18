package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		// SpringApplication.run(IocApplication.class, args);
	}

}
