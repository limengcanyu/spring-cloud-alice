package com.spring.cloud.stream.kafka.streams.message;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description: </p>
 *
 * @author rock
 * date 2019/06/29
 */
@Data
public class WordCount {
    private String key;
    private Long value;
    private Date start;
    private Date end;

    public WordCount(String key, Long value, Date start, Date end) {
        this.key = key;
        this.value = value;
        this.start = start;
        this.end = end;
    }
}
