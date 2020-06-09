package org.genesis.javacollector.springcloud.oauth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.genesis.javacollector.springcloud.oauth.entity.User;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:29 下午 2020/6/9
 * @modified by:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse extends BaseResponse<User> {
}

