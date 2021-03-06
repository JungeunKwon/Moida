package com.ssafy.moida.domain.habittracker;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ssafy.moida.domain.account.Account;
import com.ssafy.moida.domain.common.BaseEntity;
import com.ssafy.moida.domain.group.GroupTB;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Habittracker extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private String subject;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private LocalDateTime startDate;
	
	@Column(nullable = false)
	private LocalDateTime endDate;
	
	@Column(nullable = true)
	private LocalDateTime deleteDate;
	
	@OnDelete(action=OnDeleteAction.CASCADE) 
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@OnDelete(action=OnDeleteAction.CASCADE) 
	@ManyToOne
	@JoinColumn(name="groupTB_id")
	private GroupTB groupTB;
	
	@OneToMany(mappedBy = "habittracker")
	private List<AccountHabittracker> accountHabitList = new ArrayList<>();
	
	@OneToMany(mappedBy = "habittracker")
	private List<DoHabit> doHabitList = new ArrayList<>();
	
	public void delete(LocalDateTime deleteDate) {
		this.deleteDate=deleteDate;
	}
	
	public void updateinfo(String subject, String description, LocalDateTime startDate, LocalDateTime endDate) {
		this.subject = subject;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;	
	}
	
	@Builder
	public Habittracker(Long id, String subject, String description, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime deleteDate, Account account,
			GroupTB groupTB) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.account = account;
		this.groupTB = groupTB;
		this.deleteDate = deleteDate;
	}
	
	

}
