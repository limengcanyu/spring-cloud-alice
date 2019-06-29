package com.spring.cloud.stream.kafka.streams;

import com.spring.cloud.stream.kafka.streams.message.WordCount;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Arrays;
import java.util.Date;

@EnableBinding(KafkaStreamsProcessor.class)
@SpringBootApplication
public class SpringCloudStreamKafkaStreamsApplication {

    /**
     * 接收topic(input)的消息，方法结果发送到topic(output)
     *
     * @param input
     * @return
     */
    @StreamListener("input")
    @SendTo("output")
    public KStream<?, WordCount> process(KStream<?, String> input) {
        return input
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
                .groupBy((key, value) -> value)
                .windowedBy(TimeWindows.of(5000))
                .count(Materialized.as("WordCounts-multi"))
                .toStream()
                .map((key, value) -> new KeyValue<>(null, new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamKafkaStreamsApplication.class, args);
    }
}
