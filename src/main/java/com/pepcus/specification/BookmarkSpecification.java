package com.pepcus.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pepcus.entities.Bookmark;

@Service
public class BookmarkSpecification  {
	
	 private BookmarkSpecification() {}
	
	public static Specification<Bookmark> bookmarkHasAcc(Long accId) {
		return new Specification<Bookmark>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Bookmark> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get("account").get("id"), accId);
			}
		};
	}
	
	
	public static Specification<Bookmark> findLessThan(Long bookId) {
		return new Specification<Bookmark>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Bookmark> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("id"), bookId);
			}
		};
	}


}
/* public static List<TeamMember> getTeamMembersForTenant(Tenant tenant) {
		return teamMemberRepository.findByTeamTenantAndIsActiveOrderByModifiedOnDesc(tenant, true);

	}*/
