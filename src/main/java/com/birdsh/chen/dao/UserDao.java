package com.birdsh.chen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import com.birdsh.chen.entity.Permission;
import com.birdsh.chen.entity.Role;
import com.birdsh.chen.entity.User;

public interface UserDao {
	@Select(" select id,username,password,role_id roleId from user where username=#{username}")
	public User getByUsername(String username);
	@SelectProvider(type = UserSqlProvider.class, method = "findRolesByName")
	public List<Role> getRoles(String username);
	@SelectProvider(type = UserSqlProvider.class, method = "findPermissionsByName")
	public List<Permission> getPermissions(String username);
	
	static class UserSqlProvider {
		public String findRolesByName(String username) {
			return new SQL() {
				{
					SELECT("role.rolename AS rolename ");
					FROM("role");
					LEFT_OUTER_JOIN("user ON role.id = user.role_id");
					if (!StringUtils.isEmpty(username)) {
						WHERE("user.username = #{username}");
					}
				}
			}.toString();
		}
		
		public String findPermissionsByName(String username) {
			return new SQL() {
				{
					SELECT("permission.permissionname  AS permissionname ");
					FROM("permission");
					LEFT_OUTER_JOIN("role ON role.id = permission.role_id");
					LEFT_OUTER_JOIN("user ON role.id = user.role_id");
					if (!StringUtils.isEmpty(username)) {
						WHERE("user.username = #{username}");
					}
				}
			}.toString();
		}
	}

}
