package com.spring.cloud.commons.dto;

import lombok.Builder;
import lombok.Data;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/19 17:38
 */
@Builder
@Data
public class RegisterDto {
    private String username;
    private String password;
}
