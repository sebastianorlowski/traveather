package com.traveather.waypoint.service.mapper;

import com.traveather.waypoint.repository.model.Waypoint;
import com.traveather.waypoint.service.model.WaypointMessaging;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class WaypointEventMapperTest {

    @InjectMocks
    private WaypointEventMapper mapper = Mappers.getMapper(WaypointEventMapper.class);

    @Test
    void test() {
        Waypoint waypoint = mock(Waypoint.class);
        WaypointMessaging result = mapper.asWaypointMessaging(waypoint);

        assertThat(result).isNotNull();
    }
}