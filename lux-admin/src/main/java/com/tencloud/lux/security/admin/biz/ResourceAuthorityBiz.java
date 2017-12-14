package com.tencloud.lux.security.admin.biz;

import com.tencloud.lux.security.common.biz.BaseBiz;
import com.tencloud.lux.security.admin.entity.ResourceAuthority;
import com.tencloud.lux.security.admin.mapper.ResourceAuthorityMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper,ResourceAuthority> {
}
