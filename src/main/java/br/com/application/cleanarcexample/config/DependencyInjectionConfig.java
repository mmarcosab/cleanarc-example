package br.com.application.cleanarcexample.config;

import br.com.application.cleanarcexample.adapters.gateway.PersonGateway;
import br.com.application.cleanarcexample.adapters.gateway.database.PersonPersistence;
import br.com.application.cleanarcexample.adapters.gateway.database.repository.Personrepository;
import br.com.application.cleanarcexample.adapters.presenters.impl.PersonResponseFormatter;
import br.com.application.cleanarcexample.domain.factory.PersonFactory;
import br.com.application.cleanarcexample.domain.factory.impl.CommonPersonFactory;
import br.com.application.cleanarcexample.domain.usecases.impl.CreatePersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfig {

    @Bean
    public CreatePersonUseCase createPersonUseCase(PersonGateway personGateway, PersonResponseFormatter personResponseFormatter, PersonFactory personFactory){
        return new CreatePersonUseCase(personGateway, personResponseFormatter, personFactory);
    }

    @Bean
    public CommonPersonFactory createPersonFactory(){
        return new CommonPersonFactory();
    }

    @Bean
    public PersonResponseFormatter createPersonResponseFormatter(){
        return new PersonResponseFormatter();
    }

    @Bean
    public PersonPersistence createPersonGateway(Personrepository personRepository){
        return new PersonPersistence(personRepository);
    }
}
