package com.xuzh.www;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @description: kafka生产demo
 * @author: xuzh1
 * @create: 2019-08-08 15:49
 **/
public class TestProducer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "hadoop1:9092,hadoop2:9092,hadoop3:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        String str1 = "What's your name";
        String str2 = "My name is Jackie Xu";

        String str3 = "I like programming";
        String str4 = "I figured out how to fix that bug on line 255";
        String str5 = "on shit, it was a dream.";

        String str = str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5;

        //topic: 目标topic;  key: message的序号;   value： 写入的message信息；
        producer.send(new ProducerRecord<>("topic_produce", Integer.toString(1), str));

        producer.close();


    }




}
