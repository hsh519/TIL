package com.example.batch.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MemberScheduler {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Scheduled(cron = "0/10 * * * * *") // 메서드의 실행 주기를 설정하는 어노테이션
    public void runJob() {
        try {
            // 배치 작업을 실행하는 메서드. 첫 번째 파라미터는 배치 작업, 두 번째 파라미터는 배치 작업에 필요한 파라미터
            jobLauncher.run(job, new JobParametersBuilder().addString("dateTime", LocalDateTime.now().toString()).toJobParameters());
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
