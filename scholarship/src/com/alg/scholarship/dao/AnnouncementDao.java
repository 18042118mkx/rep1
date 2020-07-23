package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.Announcement;
import com.alg.scholarship.bean.Student;
import com.alg.scholarship.utils.JDBCUtils;

public class AnnouncementDao {
	//jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		
	public Vector findAllAnnouncement() {
		Vector vlist= new Vector<>();
		List<Announcement> list=jt.query("select * from announcementInformation ",new BeanPropertyRowMapper<Announcement> (Announcement.class) );
		for(Announcement announcement:list){
			Vector v=new Vector();
			v.add(announcement.getAnn_id());
			v.add(announcement.getAnn_tile());
			v.add(announcement.getAnn_content());
			v.add(announcement.getAnn_date());//.toString().substring(0,10)
			v.add(announcement.getAnn_state() == 1 ?"已发布" :"未发布");
			vlist.add(v);
		}
	return vlist;
}

	public Boolean addAnnouncement(Announcement announcement) {
		int update = jt.update("INSERT INTO `scholarship`.`announcementinformation`(`ann_id`, `ann_tile`, `ann_content`, `ann_date`, `ann_state`) VALUES (?, ?, ?, ?, ?);",
				announcement.getAnn_id(),announcement.getAnn_tile(),announcement.getAnn_content(),announcement.getAnn_date(),announcement.getAnn_state());		                                       
		return update>0 ? true : false;
	}

	public  int delAnnouncementById(int ann_id) {
		return jt.update(" delete from announcementInformation where Ann_id = ? ",ann_id);
	}
	/* 
	 * 根据id查询AnnouncementDao信息
	 */
	public Announcement findAllAnnouncementById(int ann_id) {
		return jt.queryForObject(" select * from announcementInformation where Ann_id = ?", new BeanPropertyRowMapper<Announcement> (Announcement.class),ann_id);
	}
	
	// 修改执行
		public int updateAnnouncementById(Announcement announcement) {
			int update = jt
					.update("update scholarship.announcementinformation set ann_tile=?,ann_content=?,ann_date=?,ann_state=? where ann_id=?;",
							announcement.getAnn_tile(),announcement.getAnn_content(),announcement.getAnn_date(),announcement.getAnn_state(),announcement.getAnn_id());
			return update;
		}


}
