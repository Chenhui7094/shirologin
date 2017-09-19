/**
 * 文件名：MybatisConfig.java<br>
 * 创建时间：2017年9月1日 下午12:26:40<br>
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

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * TODO 一句话描述类的主要作用<br>
 * <p>
 * TODO 该类的详细描述<br>
 * </p>
 * Time：2017年9月1日 下午12:26:40<br>
 * 
 * @author zhanglei
 * @version 1.0.0
 * @since 1.0.0
 */

@Configuration
public class MybatisConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "pageNum=page;pageSize=rows;orderBy=orderBy");
		pageHelper.setProperties(properties);

		// 添加插件
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { pageHelper });
		return sqlSessionFactoryBean.getObject();
	}
}
