package com.hwig.admin.notice;

import java.util.List;

public interface NoticeDAO {
	public List<NoticeVO> nList() throws Exception;
	public void notice_write(NoticeVO notice) throws Exception;
	public NoticeVO notice_view(int notice_id) throws Exception;
	public void notice_modify(NoticeVO notice) throws Exception;
	public void notice_delete(int notice_id) throws Exception;
	public void notice_id_d(NoticeVO notice) throws Exception;
}
