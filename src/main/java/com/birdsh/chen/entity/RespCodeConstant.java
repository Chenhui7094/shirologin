package com.birdsh.chen.entity;

/**
 * 返回代码 常量
 * 
 * @author
 *
 */
public enum RespCodeConstant {

	
    Success("0000","操作成功"),
    SqlError("1000","数据库查询异常"),
    InvalidUser("1001","非法的用户"),
    InvalidParameter("1002","非法的参数"),
    InvaildToken("1003","token失效"),
    SystemError("9999","非法操作"),
	QueryError("20000","名称不存在"),
	REPEATED("0001", "重复记录"),
	NULLVALUE("0002", "字段为空"),
	NOROLE("0003","用户没有绑定角色"),
	InvalidName("1004","项目名为空"),
	ParamError("0004", "参数不全"),
	Error("1111","操作失败"),
	RESNAMEREPEATED("0005","菜单名重复"),
	RESKEYREPEATED("0006","菜单标识重复"),
	SUPRESREPEATED("0007","上级菜单id不能是自己id"),
	TemplateExists("0008","模板已经存在"),
	SaveTemplateError("0009","保存模板数据失败"),
	RequiresPermission("0010","权限限制"),
	TemplateTypeError("0011","压缩包格式不正确"),
	PhotoTypeError("0012","图片格式不正确"),
	NotLogin("0302","请先登录"),
	CannotCreateCampany("0013","不能再创建企业"),
    InvalidVersion("0014","版本号异常");
	
    private RespCodeConstant(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String code;
    public String name;
	
    public String getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }


}
