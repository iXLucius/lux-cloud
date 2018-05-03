package com.tencloud.lux.security.auth.controller;

import com.tencloud.lux.security.common.msg.ObjectRestResponse;
import com.tencloud.lux.security.auth.bean.ClientInfo;
import com.tencloud.lux.security.auth.service.ClientService;
import com.tencloud.lux.security.auth.util.client.ClientTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ObjectRestResponse getAccessToken(String clientId, String secret) throws Exception {
        return new ObjectRestResponse<String>().data(clientService.apply(clientId, secret));
    }

    @RequestMapping(value = "/myClient")
    public ObjectRestResponse getAllowedClient(String serviceId, String secret) {
        return new ObjectRestResponse<List<String>>().data(clientService.getAllowedClient(serviceId, secret));
    }

}
