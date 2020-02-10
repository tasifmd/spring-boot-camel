package com.taazsoft.springbootcamel.comfig;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		transferSelectedFilesWithContent("tasif");
	}

	public void transferAllFiles() {
		System.out.println("Transfering.....");
		from("file:C://Users//TATHAGATA//Desktop//Test1?noop=true").to("file:C://Users//TATHAGATA//Desktop//Test2");
		System.out.println("Transfered.....");
	}

	public void transferSelectedFiles(String query) {
		System.out.println("Transfering.....");
		from("file:C://Users//TATHAGATA//Desktop//Test1?noop=true").filter(header(Exchange.FILE_NAME).startsWith(query))
				.to("file:C://Users//TATHAGATA//Desktop//Test2");
		System.out.println("Transfered.....");
	}
	
	public void transferSelectedFilesWithContent(String query) {
		System.out.println("Transfering.....");
		from("file:C://Users//TATHAGATA//Desktop//Test1?noop=true").filter(body().startsWith(query))
				.to("file:C://Users//TATHAGATA//Desktop//Test2");
		System.out.println("Transfered.....");
	}
}
