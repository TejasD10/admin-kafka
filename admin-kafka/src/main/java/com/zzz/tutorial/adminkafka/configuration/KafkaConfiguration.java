package com.zzz.tutorial.adminkafka.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfiguration {

    @Value("${bootstrap.servers}")
    private String bootstrap_Servers;

    private AdminClient adminClient;

    @Bean
    public AdminClient kafkaAdmin() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_Servers);
        props.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        props.put("sasl.kerberos.service.name", "kafka");
        adminClient = AdminClient.create(props);
        return adminClient;
    }

    public String getBootstrap_Servers() {
        return bootstrap_Servers;
    }

    public void setBootstrap_Servers(String bootstrap_Servers) {
        this.bootstrap_Servers = bootstrap_Servers;
    }

}
