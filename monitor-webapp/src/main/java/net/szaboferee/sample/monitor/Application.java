package net.szaboferee.sample.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.support.Function;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.websocket.ServerWebSocketContainer;
import org.springframework.integration.websocket.outbound.WebSocketOutboundMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Configuration
@EnableAutoConfiguration
@ImportResource("jms-context.xml")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ServerWebSocketContainer serverWebSocketContainer() {
        return new ServerWebSocketContainer("/actions").withSockJs();
    }

    @Bean
    MessageHandler webSocketOutboundAdapter() {
        return new WebSocketOutboundMessageHandler(serverWebSocketContainer());
    }

    @Bean
    IntegrationFlow actionMonitorFlow() {
        return flowDefinition -> {
            Function<Message, Object> splitter = message -> serverWebSocketContainer()
                    .getSessions()
                    .keySet()
                    .stream()
                    .map(session -> MessageBuilder.fromMessage(message)
                            .setHeader(SimpMessageHeaderAccessor.SESSION_ID_HEADER, session)
                            .build())
                    .collect(Collectors.toList());
            flowDefinition.split(Message.class, splitter)
                    .channel(channel -> channel.executor(Executors.newCachedThreadPool()))
                    .handle(webSocketOutboundAdapter());
        };
    }

    @Bean(name = "actionMonitorFlow.input")
    MessageChannel actionChannel() {
        return new DirectChannel();
    }
}
