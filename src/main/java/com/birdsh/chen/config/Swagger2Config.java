/**
 * 文件名：Swagger2Config.java<br>
 * 创建时间：2017年9月1日 上午9:28:50<br>
 * 创建者：zhanglei<br>
 * 修改者：暂无<br>
 * 修改简述：暂无<br>
 * 修改详述：
 * <p>
 * 暂无<br>
 * </p>
 * 修改时间：暂无<br>
 */
package com.birdsh.chen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO 一句话描述类的主要作用<br>
 * <p>
 * TODO 该类的详细描述<br>
 * </p>
 * Time：2017年9月1日 上午9:28:50<br>
 * 
 * @author zhanglei
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
//@Profile("dev")
public class Swagger2Config{

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.birdsh.chen")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("shiro认证登录统一平台").description("shiro认证登录统一平台统一平台").termsOfServiceUrl("http://www.birdsh.com")
				.version("1.0").build();
	}

}
