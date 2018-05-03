package com.tencloud.lux.security.admin.biz;

import com.tencloud.lux.security.common.biz.BaseBiz;
import com.tencloud.lux.security.admin.entity.GateLog;
import com.tencloud.lux.security.admin.mapper.GateLogMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class GateLogBiz extends BaseBiz<GateLogMapper,GateLog> {

    @Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
