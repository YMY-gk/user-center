package com.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 在线用户记录
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_online")
public class SysUserOnline extends Model<SysUserOnline> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户会话id
     */
    @TableId("sessionId")
    private String sessionid;

    /**
     * 公司id
     */
    @TableField("realm_id")
    private Long realmId;

    /**
     * 登录账号
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;

    /**
     * 登录IP地址
     */
    @TableField("ipaddr")
    private String ipaddr;

    /**
     * 登录地点
     */
    @TableField("login_location")
    private String loginLocation;

    /**
     * 浏览器类型
     */
    @TableField("browser")
    private String browser;

    /**
     * 操作系统
     */
    @TableField("os")
    private String os;

    /**
     * 在线状态on_line在线off_line离线
     */
    @TableField("status")
    private String status;

    /**
     * session创建时间
     */
    @TableField("start_timestamp")
    private LocalDateTime startTimestamp;

    /**
     * session最后访问时间
     */
    @TableField("last_access_time")
    private LocalDateTime lastAccessTime;

    /**
     * 超时时间，单位为分钟
     */
    @TableField("expire_time")
    private Integer expireTime;


    @Override
    protected Serializable pkVal() {
        return this.sessionid;
    }

}
