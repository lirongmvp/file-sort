package com.lirong;

import com.lirong.domian.DataInfo;
import com.lirong.obtain.ObtainStart;
import com.lirong.source.DataSource;
import com.lirong.write.GenerateStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

@SpringBootApplication
public class FileSortApplication {
	private static final Logger LOG = LoggerFactory.getLogger(FileSortApplication.class);

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
		String mergeSign = context.getEnvironment().getProperty("mergeSign");
		//多少条写一个文件
		String readNum = context.getEnvironment().getProperty("readNum");

		LOG.info("file:{},preDir:{},mergeDir:{},sign:{},mergeSign:{}",file,preDir,mergeDir,sign,mergeSign);

		File file1 =new File(file);
		if(!file1.exists()|| !file1.isFile()){
			LOG.error("File does not exist or not file");
			return;
		}
		DataSource source = new DataSource(file);

		ObtainStart start = new ObtainStart(sign,Integer.parseInt(readNum));

		DataInfo.setSign(mergeSign);

		GenerateStrategy.setPerMergeFile(preDir);

		GenerateStrategy.setGeneratePath(mergeDir);

		start.obtain(source);
	}
}
