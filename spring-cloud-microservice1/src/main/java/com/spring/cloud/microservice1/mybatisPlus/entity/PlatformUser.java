package com.spring.cloud.microservice1.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 平台用户表
 * </p>
 *
 * @author rock
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PlatformUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 公司id
     */
    private String companyId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户中文姓名
     */
    private String zhName;

    /**
     * 用户英文姓名
     */
    private String engName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别：1-男；0-女
     */
    private Integer gender;

    /**
     * 是否启用：1-启用；0-禁用
     */
    private Boolean isActive;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime creationTime;

    /**
     * 修改人id
     */
    private String modifierId;

    /**
     * 修改时间
     */
    private LocalDateTime modificationTime;

    /**
     * 版本号
     */
    private Integer version;


}
