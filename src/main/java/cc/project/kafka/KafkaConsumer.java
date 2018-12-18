package cc.project.kafka;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    
    @Autowired
    private ApplicationContext applicationContext;

    // todo：通过配置文件配置
    @KafkaListener(topics = {"item_remove_message", "item_save_message"})
    public void receiveMessage(ConsumerRecord<String,String> record){
        
    }
}
