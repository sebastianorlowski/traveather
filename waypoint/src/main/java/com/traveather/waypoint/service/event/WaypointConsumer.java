package com.traveather.waypoint.service.event;

import com.traveather.waypoint.service.WaypointService;
import com.traveather.waypoint.service.model.WaypointMessaging;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class WaypointConsumer {

    private final static String WAYPOINT_UPDATE_QUEUE = "waypoint.update";

    private static WaypointService waypointService;

    @RabbitListener(queues = WAYPOINT_UPDATE_QUEUE)
    public void consumeMessage(WaypointMessaging waypointMessaging) {
        log.info("Consume {} from queue", waypointMessaging);
        waypointService.updateWaypointData(waypointMessaging);
    }
}
