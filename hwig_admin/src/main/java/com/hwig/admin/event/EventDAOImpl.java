package com.hwig.admin.event;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO{

	@Inject
	SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.mappers.eventMapper";
	
	//이벤트 목록
	@Override
	public List<EventVO> eList() throws Exception {
		
		return sql.selectList(namespace + ".eList");
	}
	
	//이벤트 등록
	@Override
	public int event_write(EventVO event) throws Exception {
		
		return sql.insert(namespace + ".event_write", event);
	}
	
	//이벤트 조회
	@Override
	public EventVO event_view(int event_id) throws Exception {
		
		return sql.selectOne(namespace + ".event_view", event_id);
	}
	
	//이벤트 수정
	@Override
	public int event_modify(EventVO event) throws Exception {
		
		return sql.update(namespace + ".event_modify", event);
	}

	//이벤트 삭제
	@Override
	public int event_delete(int event_id) throws Exception {
		
		return sql.delete(namespace + ".event_delete", event_id);
	}
	
	//이벤트 삭제시 번호 땡김
	@Override
	public void event_id_d(EventVO event) throws Exception {
		
		sql.update(namespace + ".event_id_d", event);
	}

}
