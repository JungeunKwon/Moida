package com.ssafy.moida.domain.follow;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.ssafy.moida.web.dto.follow.FollowingResponseDTO;

public interface FollowRepository extends JpaRepository<Follow, Long>{
	List<Follow> findByFollowerId(Long followerid);
	List<Follow> findByFollowingId(Long followingid);
	int countByFollowingIdAndFollowerId(Long followingid,Long followerid);
	Follow findByFollowerIdAndFollowingId(Long followingid,Long followerid);

}
