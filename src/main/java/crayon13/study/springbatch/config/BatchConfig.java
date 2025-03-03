//package crayon13.study.springbatch.config;
//
//import java.util.Collection;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
//import org.springframework.batch.core.explore.JobExplorer;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.boot.autoconfigure.batch.BatchProperties;
//import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.StringUtils;
//
//@Configuration
//@ConditionalOnMissingBean(value = DefaultBatchConfiguration.class, annotation = EnableBatchProcessing.class)
//@RequiredArgsConstructor
//public class BatchConfig {
//    private final JobLauncher jobLauncher;
//    private final JobExplorer jobExplorer;
//    private final JobRepository jobRepository;
//    private final BatchProperties properties;
//
//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(prefix = "spring.batch.job", name = "enabled", havingValue = "true", matchIfMissing = true)
//    public JobLauncherApplicationRunner jobLauncherApplicationRunner(Collection<Job> jobs) {
//        JobLauncherApplicationRunner runner = new JobLauncherApplicationRunner(jobLauncher, jobExplorer, jobRepository);
//        String jobNames = properties.getJob().getName();
//        if (StringUtils.hasText(jobNames)) {
//            if (jobs.stream().map(Job::getName).noneMatch(s -> s.equals(jobNames))){
//                throw new IllegalArgumentException(jobNames + "는 등록되지 않은 job name입니다. job name을 확인하세요.");
//            }
//            runner.setJobName(jobNames);
//        }
//        return runner;
//    }
//}
