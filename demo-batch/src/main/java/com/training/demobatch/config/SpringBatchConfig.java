package com.training.demobatch.config;

import org.springframework.batch.core.Job;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.training.demobatch.model.ChennaiNationalBank;
import com.training.demobatch.model.ZipooTradingCompany;
import com.training.listener.ItemCountListener;
import com.training.listener.compare;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<ChennaiNationalBank> itemReader, ItemReader<ZipooTradingCompany> itemReader1,
			ItemProcessor<ChennaiNationalBank, ChennaiNationalBank> itemProcessor,
			ItemProcessor<ZipooTradingCompany, ZipooTradingCompany> itemProcessor1,
			ItemWriter<ChennaiNationalBank> itemWriter, ItemWriter<ZipooTradingCompany> itemWriter1) {
		Step step = stepBuilderFactory.get("ETL-file-Load").<ChennaiNationalBank, ChennaiNationalBank>chunk(100)
				.reader(itemReader).processor(itemProcessor).writer(itemWriter).build();

		Step step1 = stepBuilderFactory.get("ETL-file-Load-Sample1")
				.<ZipooTradingCompany, ZipooTradingCompany>chunk(100).reader(itemReader1).processor(itemProcessor1)
				.writer(itemWriter1).build();

//	Step step2 = stepBuilderFactory.get("DB To CSV")
//			.<User1,User1>chunk(100)
//			.reader(itemReader1)
//			.writer(itemWriter1)
//			.build();

		return jobBuilderFactory.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step).next(step1)
//			 .next(step2)
				.build();
	}

	@Bean
	public ItemCountListener listener() {
		return new ItemCountListener();
	}

	@Bean
	public FlatFileItemReader<ChennaiNationalBank> itemReader(@Value("${input}") Resource resource) {
		FlatFileItemReader<ChennaiNationalBank> flatFileItemReader = new FlatFileItemReader<ChennaiNationalBank>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());

		return flatFileItemReader;

	}

	@Bean
	public FlatFileItemReader<ZipooTradingCompany> itemReader1(@Value("${input1}") Resource resource) {
		FlatFileItemReader<ZipooTradingCompany> flatFileItemReader1 = new FlatFileItemReader<ZipooTradingCompany>();
		flatFileItemReader1.setResource(resource);
		flatFileItemReader1.setName("CSV-Reader");
		flatFileItemReader1.setLinesToSkip(1);
		flatFileItemReader1.setLineMapper(lineMapper1());
		// System.out.println(flatFileItemReader1);
		return flatFileItemReader1;
	}

	@Bean
	public LineMapper<ChennaiNationalBank> lineMapper() {

		DefaultLineMapper<ChennaiNationalBank> defaultLineMapper = new DefaultLineMapper<ChennaiNationalBank>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "Customer ID", "Customer Name", "DOB", "Address", "Zip code", "Mobile No",
				"Email ID", "Gender" });

		BeanWrapperFieldSetMapper<ChennaiNationalBank> fieldSetMapper = new BeanWrapperFieldSetMapper<ChennaiNationalBank>();
		fieldSetMapper.setTargetType(ChennaiNationalBank.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}

	@Bean
	public LineMapper<ZipooTradingCompany> lineMapper1() {

		DefaultLineMapper<ZipooTradingCompany> defaultLineMapper = new DefaultLineMapper<ZipooTradingCompany>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "id", "name", "dept", "salary" });

		BeanWrapperFieldSetMapper<ZipooTradingCompany> fieldSetMapper = new BeanWrapperFieldSetMapper<ZipooTradingCompany>();
		fieldSetMapper.setTargetType(ZipooTradingCompany.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);

		return defaultLineMapper;
	}
}
