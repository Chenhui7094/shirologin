package com.birdsh.chen.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdsh.chen.entity.DataWrapper;
import com.birdsh.chen.entity.RespCodeConstant;
import com.birdsh.chen.entity.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
public class UserController {

	//用户登录
	@ApiOperation(value = "USER登录", notes = "USER登录详细描述")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType = "query")
        })
    @ApiResponses({ @ApiResponse(code = 204, message = "错误的请求"),
        @ApiResponse(code = 401, message = "访问过于频繁"), @ApiResponse(code = 403, message = "token失效"),
        @ApiResponse(code = 404, message = "路径不存在") })
	@PostMapping(value ="/login")
    public DataWrapper<User> login(String username,String password,HttpServletRequest request) {
		DataWrapper<User> dataWrapper = new DataWrapper<>();
		//得到当前执行的用户
        Subject subject = SecurityUtils.getSubject();
        //根据用户名和密码获得一个令牌（token）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);//会跳到我们自定义的realm中
            //返回当前登录信息的那条记录
            User user = (User) subject.getPrincipal();
            request.getSession().setAttribute("user", user);
            System.out.println(user.getRoleId());
            dataWrapper.setReturnSg(RespCodeConstant.Success);//返回成功信息
            dataWrapper.setResultData(user);
            return dataWrapper;
        }catch(Exception e){
            dataWrapper.setReturnSg(RespCodeConstant.Error);//返回错误信息
        	dataWrapper.setResultData(null);
            return dataWrapper;
        }
}
}
