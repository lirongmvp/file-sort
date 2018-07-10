package com.lirong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FileSortApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FileSortApplication.class, args);
		//读取的文件
		String file = context.getEnvironment().getProperty("file");
		//第一次生成的目录
		String preDir = context.getEnvironment().getProperty("preDir");
		//合并的目录
		String mergeDir = context.getEnvironment().getProperty("mergeDir");
		//读取文件分隔符
		String sign = context.getEnvironment().getProperty("sign");
		//合并的分隔符
		String merge = context.getEnvironment().getProperty("merge-sign");
	}
}
