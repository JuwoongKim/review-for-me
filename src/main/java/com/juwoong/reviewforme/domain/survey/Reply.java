package com.juwoong.reviewforme.domain.survey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Reply {

	@Column(name ="reply_content")
	String content;

	protected Reply(){
	}

	public Reply(String content){
		this.content = content;

	}
}
