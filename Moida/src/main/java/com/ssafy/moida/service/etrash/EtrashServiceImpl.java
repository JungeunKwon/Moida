package com.ssafy.moida.service.etrash;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ssafy.moida.domain.etrash.Etrash;
import com.ssafy.moida.domain.etrash.EtrashRepository;
import com.ssafy.moida.domain.music.Music;
import com.ssafy.moida.domain.music.MusicRepository;
import com.ssafy.moida.exception.BaseException;
import com.ssafy.moida.service.account.AccountService;
import com.ssafy.moida.web.dto.etrash.EtrashAllRequestDTO;
import com.ssafy.moida.web.dto.etrash.EtrashResponseDto;
import com.ssafy.moida.web.dto.etrash.EtrashSaveRequestDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EtrashServiceImpl implements EtrashService{
	
	private final EtrashRepository etrashRepository;
	private final MusicRepository musicRepository;
	private final AccountService accountservice;
	
	
	@Transactional(readOnly = true)
	public Page<EtrashResponseDto> findByMood(EtrashAllRequestDTO requestDto) {
		
		return etrashRepository.findByMood(requestDto.getMood(),requestDto.getPageable())
				.map(EtrashResponseDto::new);
			
	}

	@Transactional(readOnly = true)
	public Page<EtrashResponseDto> findAll(EtrashAllRequestDTO requestDto) {		
		return etrashRepository.findAll(requestDto.getPageable())
				.map(EtrashResponseDto::new);
	}


	@Transactional
	public Long saveEtrash(EtrashSaveRequestDto dto) throws NumberFormatException, BaseException {
		dto.setAccount(accountservice.getAccount());
		return etrashRepository.save(dto.toEntity()).getId();
	}

	@Transactional
	public Long updateEtrashMusic(Etrash etrash, Music music) {

		return etrashRepository.findById(etrash.getId()).get().updateMusic(musicRepository.findById(music.getId()).get());
	}


	@Transactional
	public String sentimentanalysis(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Music> musicrecommend(String mood) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
