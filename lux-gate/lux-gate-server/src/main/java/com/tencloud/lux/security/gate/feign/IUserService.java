package com.tencloud.lux.security.gate.feign;

import com.tencloud.lux.security.api.vo.authority.PermissionInfo;

import feign.Param;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="lux-admin")
public interface IUserService {
  @RequestMapping(value="/api/user/un/{username}/permissions",method = RequestMethod.GET/*,
          headers= {"#{serviceAuthConfig.getTokenHeader()}=#{serviceAuthUtil.getClientToken()}",
                  "#{userAuthConfig.getTokenHeader()}=#{T(com.tencloud.lux.security.common.context.BaseContextHandler).getToken()}"}*/)
  public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);
  @RequestMapping(value="/api/permissions",method = RequestMethod.GET/*,
          headers= {"#{serviceAuthConfig.getTokenHeader()}=#{serviceAuthUtil.getClientToken()}",
  "#{userAuthConfig.getTokenHeader()}=#{T(com.tencloud.lux.security.common.context.BaseContextHandler).getToken()}"}*/)
  List<PermissionInfo> getAllPermissionInfo();
}
