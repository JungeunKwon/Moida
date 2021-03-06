package com.ssafy.moida.web.dto.group;

import com.ssafy.moida.domain.group.AccountGroup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountGroupResponseDto {
	private Long accountId;
	private String accountNickname;
	private String accountProfileImg;
	
	public AccountGroupResponseDto(AccountGroup entity) {
		this.accountId = entity.getAccount().getId();
		this.accountNickname = entity.getAccount().getNickname();
		this.accountProfileImg = entity.getAccount().getProfileImg();
	}
}
