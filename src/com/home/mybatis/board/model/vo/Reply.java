package com.home.mybatis.board.model.vo;

import java.sql.Date;

public class Reply {
	
	private int replyNo;
	private String replayContent;
	private int refBno;
	private String replyWriter;
	private String createDate;
	private String status;

	public Reply() {
		
	}

	public Reply(int replyNo, String replayContent, int refBno, String replyWriter, String createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.replayContent = replayContent;
		this.refBno = refBno;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
		this.status = status;
	}

	public int getReplyNo() {
		return replyNo;
	}



	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}



	public String getReplayContent() {
		return replayContent;
	}



	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}



	public int getRefBno() {
		return refBno;
	}



	public void setRefBno(int refBno) {
		this.refBno = refBno;
	}



	public String getReplyWriter() {
		return replyWriter;
	}



	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}



	public String getCreateDate() {
		return createDate;
	}



	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replayContent=" + replayContent + ", refBno=" + refBno
				+ ", replyWriter=" + replyWriter + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
}
