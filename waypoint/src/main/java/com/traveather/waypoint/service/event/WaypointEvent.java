package com.traveather.waypoint.service.event;

import com.traveather.common.messaging.RabbitMQProducer;
import com.traveather.waypoint.api.model.Waypoint;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WaypointEvent {

    private final static String EXCHANGE = "amq.direct";
    private final static String ROUTING_KEY = "waypoint.create";

    private final RabbitMQProducer producer;

    public void publishOnCreate(Waypoint waypoint) {
        producer.publish(waypoint, EXCHANGE, ROUTING_KEY);
    }
}
