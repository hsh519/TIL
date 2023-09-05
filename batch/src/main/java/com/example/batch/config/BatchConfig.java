package com.example.batch.config;

import com.example.batch.member.MemberRepository;
import com.example.batch.scheduler.MemberTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@RequiredArgsConstructor
@Configuration
public class BatchConfig {


    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final MemberRepository memberRepository;


    @Bean
    // 스프링 배치에서 사용할 Job 을 정의하는 빌더 메서드. Job 은 배치 작업의 논리적인 단위
    public Job simpleJob() {
        return jobBuilderFactory.get("simpleJob") // simpleJob 이름의 새 작업 생성
                .start(addPersonAgeStatus()) // 작업의 시작 단계를 정의
                .on("FAILED") // 이전 단게에서 실패할 경우 수행할 작업 정의
                .stopAndRestart(addPersonAgeStatus()) // 이전 단게에서 실패한 경우 해당 단게를 중지하고 다시 시작하도록 구성
                .on("*") // 이전 단계 결과와 상관없이 다른 모든 상황에 대한 처리를 정의
                .end() // 처리를 마침
                .end() // 작업을 종료함
                .build();
    }

    @Bean
    public Step addPersonAgeStatus() {
        return stepBuilderFactory.get("addPersonAgeStatus") // addPersonAgeStatus 이름의 스텝을 생성
                .tasklet(new MemberTasklet(memberRepository)) // 이 스텝에서 수행할 작업을 정의
                .build();
    }
}
