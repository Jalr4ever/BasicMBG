/*
*
* TbSystemLogInfo.java
* Copyright(C) 2017-2020 fendo公司
* @date 2020-08-12
*/
package com.pojo.entity;

public class TbSystemLogInfo {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 事件的 ID
     */
    private Integer eventId;

    /**
     * 事件失败原因
     */
    private String description;

    /**
     * 事件执行操作，参考权限表 tb_privilege
     */
    private Short operate;

    /**
     * 自增主键
     * @return id 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 事件的 ID
     * @return event_id 事件的 ID
     */
    public Integer getEventId() {
        return eventId;
    }

    /**
     * 事件的 ID
     * @param eventId 事件的 ID
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    /**
     * 事件失败原因
     * @return description 事件失败原因
     */
    public String getDescription() {
        return description;
    }

    /**
     * 事件失败原因
     * @param description 事件失败原因
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 事件执行操作，参考权限表 tb_privilege
     * @return operate 事件执行操作，参考权限表 tb_privilege
     */
    public Short getOperate() {
        return operate;
    }

    /**
     * 事件执行操作，参考权限表 tb_privilege
     * @param operate 事件执行操作，参考权限表 tb_privilege
     */
    public void setOperate(Short operate) {
        this.operate = operate;
    }
}