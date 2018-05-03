package com.tencloud.lux.security.admin.biz;

import org.springframework.stereotype.Service;

import com.tencloud.lux.security.common.biz.BaseBiz;
import com.tencloud.lux.security.admin.entity.GroupType;
import com.tencloud.lux.security.admin.mapper.GroupTypeMapper;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper,GroupType> {
}
