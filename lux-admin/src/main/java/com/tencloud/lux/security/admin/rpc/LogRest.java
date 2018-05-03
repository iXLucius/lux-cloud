package com.tencloud.lux.security.admin.rpc;

import com.alibaba.fastjson.JSONObject;
import com.tencloud.lux.security.api.vo.log.LogInfo;
import com.tencloud.lux.security.admin.biz.GateLogBiz;
import com.tencloud.lux.security.admin.entity.GateLog;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
public class LogRest {
    @Autowired
    private GateLogBiz gateLogBiz;
    @RequestMapping(value="/log/save",method = RequestMethod.POST)
    public @ResponseBody void saveLog(@RequestBody LogInfo info){
        GateLog log = new GateLog();
        BeanUtils.copyProperties(info,log);
        gateLogBiz.insertSelective(log);
    }
}
