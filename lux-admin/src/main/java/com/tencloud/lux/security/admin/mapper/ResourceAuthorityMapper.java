package com.tencloud.lux.security.admin.mapper;

import org.apache.ibatis.annotations.Param;

import com.tencloud.lux.security.admin.entity.ResourceAuthority;

import tk.mybatis.mapper.common.Mapper;

public interface ResourceAuthorityMapper extends Mapper<ResourceAuthority> {
    public void deleteByAuthorityIdAndResourceType(@Param("authorityId")String authorityId,@Param("resourceType") String resourceType);
}