package site._60jong.kafkaselectcolor.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ConsumerWorker implements Runnable{

    private static Map<Integer, List<String>> bufferString = new ConcurrentHashMap<>();
    private static Map<Integer, Long> currentFileOffset = new ConcurrentHashMap<>();

    private final Properties properties;
    private final String topic;
    private final String threadName;
    private final KafkaConsumer<String, String> consumer;

    public ConsumerWorker(Properties properties, String topic, String threadName) {
        log.info("Generate ConsumerWorker");
        this.properties = properties;
        this.topic = topic;
        this.threadName = threadName;
        this.consumer = new KafkaConsumer<>(properties);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadName);
        consumer.subscribe(List.of(topic));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

            for (ConsumerRecord<String, String> record : records) {
                log.info("Consume record - {}", record);
            }
        }
    }
}
