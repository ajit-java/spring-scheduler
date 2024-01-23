## Reference
https://www.baeldung.com/spring-boot-testing
https://stackoverflow.com/questions/42550874/intellij-junit-runwith-not-resolved


## Asyn execute
#### Goal:
Execute scheduled task asyncronously in parrallel but each task thread must wait for task to complete.
Fixeddelay = The annotated method with a fixed period between the end of the last invocation and the start of the next.
Spring’s @Async 
@Async annotation from Spring can be used on a method to execute scheduled task asynchronously.
To enable @Async, add @EnableAsync on your Spring boot configuration.

## Scheduler thread pool

    spring.task.scheduling.pool.size=5

Note each methods annotated as scheduled would share this pool. 

### springs internal implementation to sync between pods
This is good for long running tasks only. 

### https://www.baeldung.com/shedlock-spring

https://levelup.gitconnected.com/solving-multiple-executions-of-scheduled-tasks-across-multiple-nodes-even-with-shedlock-spring-2b1d26db9356

