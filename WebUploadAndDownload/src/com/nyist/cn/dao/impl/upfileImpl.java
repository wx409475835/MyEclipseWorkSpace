package com.nyist.cn.dao.impl;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import com.nyist.cn.Utils.JDBCUtil_c3p0;
import com.nyist.cn.domain.upfile;
public class upfileImpl {
	/**
	private String id;										//文件ID
	private String uuidname;								//uuid文件名称
	private String filename;								//文件的真实名称
	private String savepath;								//文件的保存路径
	private Date uptime;									//文件上传时间
	private String description
	private String username;								//上传的用户 
	 */
	//添加文件
	public void addfile(upfile upfile){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
			String sql = "insert into upfile(id,uuidname,filename,savepath,uptime,description,username) values(?,?,?,?,?,?,?)";
			Object params[] = {upfile.getId(),upfile.getUuidname(),upfile.getFilename(),upfile.getSavepath(),upfile.getUptime(),upfile.getDescription(),upfile.getUsername()};
			JDBCUtil_c3p0.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//得到所有的文件
	public List<upfile> getAll(){
		List<upfile> file = null;
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
			String sql = "select * from upfile";
			Object params[]={};
			return (List<upfile>) JDBCUtil_c3p0.Query(sql, params, new BeanListHandler(upfile.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//查找一个文件
	public upfile find(String id){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
			String sql = "select * from upfile where id = ?";
			Object params[]={id};
			return (upfile) JDBCUtil_c3p0.Query(sql, params, new BeanHandler(upfile.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//删除一个文件
	public void delete(String id){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
			String sql = "delete from upfile where id =?";
			Object params[]={id};
			JDBCUtil_c3p0.Query(sql, params, new BeanHandler(upfile.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//修改一个文件
	public upfile updatefile(upfile upfile){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
			String sql = "update upfile set id =?,uuidname=?,filename=?,savepath=?,uptime=?,description=?,username=?";
			Object params[]={};
			return (upfile)JDBCUtil_c3p0.Query(sql, params, new BeanHandler(upfile.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
