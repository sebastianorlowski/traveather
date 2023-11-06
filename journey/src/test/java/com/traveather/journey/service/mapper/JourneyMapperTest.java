package com.traveather.journey.service.mapper;

import com.traveather.journey.api.model.Journey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class JourneyMapperTest {

    @InjectMocks
    private JourneyMapper mapper = Mappers.getMapper(JourneyMapper.class);

    @Test
    void test() {
        com.traveather.journey.repository.model.Journey journey = mock(com.traveather.journey.repository.model.Journey.class);
        Journey result = mapper.asDto(journey);

        assertThat(result).isNotNull();
    }
}