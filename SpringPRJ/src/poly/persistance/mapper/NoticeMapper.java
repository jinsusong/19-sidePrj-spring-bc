package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NoticeDTO;

@Mapper("NoticeMapper")
public interface NoticeMapper {

	public int noticeReg(NoticeDTO nDTO)throws Exception;

	public List<NoticeDTO> getNoticeList()throws Exception;

	
}
