package org.atalibdev.ecommerce.confirmation;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created by Almousleck on May, 2024
 */
@Configuration
public class KafkaPaymentTopicConfig {

    @Bean
    public NewTopic paymentTopic() {
        return TopicBuilder
                .name("payment-topic")
                .build();
    }
}
