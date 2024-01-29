package com.us.base.code.usbasecode.config.component.kafka;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 发送kafka消息
 *
 * @author wufan
 * @date 2024/1/19
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, Object msg) {
        //向kafka的big_data_topic主题推送数据
        kafkaTemplate.send(topic, JSONObject.toJSONString(msg));
    }
}
