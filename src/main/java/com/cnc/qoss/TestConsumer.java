package com.cnc.qoss;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
* @Description:  kafka topic消费测试
 * 消费参数配置参考：https://docs.confluent.io/current/installation/configuration/consumer-configs.html
* @Author: created by xuzh1 on 2019/8/25
*/
public class TestConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "hadoop1:9092,hadoop2:9092,hadoop3:9092");
        // 制定consumer group
        props.put("group.id", "test");
        // 是否自动确认offset
        props.put("enable.auto.commit", "true");
        // 自动确认offset的时间间隔
        props.put("auto.commit.interval.ms", "1000");
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "20485760");

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // key的序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // value的序列化类
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("qoss_webtrans"));

        while (true){
            ConsumerRecords<String,String> records = consumer.poll(3000);
            for (ConsumerRecord<String, String> record : records) {
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                System.err.println(record.value());
            }
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
