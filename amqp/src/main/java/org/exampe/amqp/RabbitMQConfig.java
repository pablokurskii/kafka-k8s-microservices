package org.exampe.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
/*Basic setup to send and receive messages from queues*/
public class RabbitMQConfig {

    private final ConnectionFactory connecitonFactory;

    /*Allows to send messages to queue*/
    @Bean
    public AmqpTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connecitonFactory);
        rabbitTemplate.setMessageConverter(jacksonConverter());
        return rabbitTemplate;
    }

    /*Allows to receive messages from queue using Jackson converter*/
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
        var factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connecitonFactory);
        factory.setMessageConverter(jacksonConverter());
        return factory;
    }

    @Bean
    public MessageConverter jacksonConverter() {
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        return messageConverter;
    }

    /*TODO setup exchange*/
    /*TODO setup queues*/
    /*TODO bind exachge to any particular queue*/
}
