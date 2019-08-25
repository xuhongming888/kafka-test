package com.cnc.qoss;

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
        String str1 = "#Fields: timestamp,ra,status,sent_http_content_length,tl,upstream_http_cache_state,url,first_packet_time,tot,lv,rtl,trr,est,sst,set,reqt,fpt,fpat,ts,ct,dispatch_ip";
        String str2 = "#Delimiter: \"||\"";

        String str3 = "1566543583||36.104.175.165||206||6717409||6727311||0||https://storefs1.nearme.com.cn/apk/201907||0||63881||-1||4610581||68.53||19||-1||-1||96||1||21||0||0||36.104.132.46";
        String str4 = "1566543590||36.104.29.227||206||434763025||78165||0||https://storefs1.nearme.com.cn/apk/201907||0||51129||-1||146590||187.53||320||-1||-1||124||1||-1||1||3||36.104.132.46";
        String str5 = "1566543567||36.104.29.227||206||434591269||293561||0||https://storefs1.nearme.com.cn/apk/201907||0||91967||-1||823435||280.49||24||-1||-1||138||1||-1||1||1||36.104.132.46";

        String str = str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5;

        //topic: 目标topic;  key: message的序号;   value： 写入的message信息；
        producer.send(new ProducerRecord<>("webtrans4", Integer.toString(1), str));

        producer.close();


    }




}
