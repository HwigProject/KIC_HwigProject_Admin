package com.hwig.admin.notice;

import java.util.List;

public interface NoticeService {
	public List<NoticeVO> nList() throws Exception;
	public int notice_write(NoticeVO notice) throws Exception;
	public NoticeVO notice_view(int notice_id) throws Exception;
	//public int notice_hit_up(int notice_id) throws Exception;
	public int notice_modify(NoticeVO notice) throws Exception;
	public int notice_delete(int notice_id) throws Exception;
	public void notice_id_d(NoticeVO notice) throws Exception;
}
