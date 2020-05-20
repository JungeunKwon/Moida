package com.ssafy.moida.service.group;

import java.util.List;

import com.ssafy.moida.exception.BaseException;
import com.ssafy.moida.web.dto.group.GroupResponseDto;
import com.ssafy.moida.web.dto.group.SaveAccountGroupRequestDto;
import com.ssafy.moida.web.dto.group.SaveGroupRequestDto;

public interface GroupService {
	Long saveGroup(SaveGroupRequestDto requestDto) throws NumberFormatException, BaseException;
	Long saveAccountGroup(SaveAccountGroupRequestDto requestDto) throws NumberFormatException, BaseException;
	void deleteAccountGroup(Long groupId) throws NumberFormatException, BaseException;
	void deleteGroup(Long groupId) throws BaseException;
	List<GroupResponseDto> findAllGroup();

}
