package crayon13.study.springbatch.job;

//import crayon13.study.springbatch.listener.JobCompletionNotificationListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SimpleBatchJob {
    private final String jobName = "SimpleBatchJob";

    private final JobRepository jobRepository;
    private final PlatformTransactionManager batchTransactionManager;

//    @Bean
//    public JobCompletionNotificationListener jobCompletionNotificationListener() {
//        return new JobCompletionNotificationListener();
//    }

    @Bean
    public Job firstJob() {
        log.info(">>>>>>>>>>>>> Job Start");
        return new JobBuilder(jobName, jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(taskletStep())
                .build();
    }

    @Bean
    public Step taskletStep() {
        return new StepBuilder("first step", jobRepository)
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">>>>>>>>>>>>> This is first tasklet step");
                    log.info(">>>>>>>>>>>>> SEC = {}", chunkContext.getStepContext().getStepExecutionContext());
                    return RepeatStatus.FINISHED;
                }, batchTransactionManager).build();
    }
}
