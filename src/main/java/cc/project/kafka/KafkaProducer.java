package cc.project.kafka;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private String itemTopic(){
    	return "item_update_message";
    }

    @Autowired
    private KafkaTemplate<String, String> template;


    @Async
	public void sendItem(String itemId, String url, int itemSetId) {
		JSONObject jo = new JSONObject();
		jo.put("itemId", itemId);
		jo.put("url", url);
		jo.put("itemSetId", String.valueOf(itemSetId));
		template.send(itemTopic(), jo.toJSONString());
	}
}