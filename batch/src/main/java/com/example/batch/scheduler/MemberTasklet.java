package com.example.batch.scheduler;

import com.example.batch.member.Member;
import com.example.batch.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class MemberTasklet implements Tasklet {

    private final MemberRepository memberRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("==== Start ====");
        List<Member> all = memberRepository.findAll();

        for (Member member : all) {
            member.plusAge();
        }

        log.info("==== Finish ====");
        return RepeatStatus.FINISHED;
    }
}
