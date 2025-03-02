package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

    @Bean
    @Primary
    public TicketService defaultTicketService(TicketRepository repository) {
        return new DefaultTickets(repository);
    }

    @Bean
    @Qualifier("vipService")
    public TicketService vipTicketService(TicketRepository repository) {
        return new VIPTickets(repository);
    }

    @Bean
    @Lazy
    public LazyBean lazyBean() {
        return new LazyBean();
    }

    @Bean
    public EagerBean eagerBean() {
        return new EagerBean();
    }
}

