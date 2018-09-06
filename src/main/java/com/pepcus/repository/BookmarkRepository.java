package com.pepcus.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pepcus.entities.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> , JpaSpecificationExecutor<Bookmark>{
	
	public List<Bookmark> findByIdAndDescription(Long id, String description);
	
	@Query("select b from Bookmark b where b.description like ?1%")
	public List<Bookmark> findByDescLike(String description);
	
	public List<Bookmark> findByIdLessThan(Long id);
	
	@Query("select b from Bookmark b where b.description =:description")
	public List<Bookmark> findByOk(@Param("description") String description);//, Pageable pageable);
	
	@Query("select count(b) from Bookmark b")
	public Integer findCount();
	
	@Query("select b.description from Bookmark b group by b.description")
	public List<String> findGroupBy();
	
	public Bookmark findTopDescriptionByIdGreaterThanEqualOrderByIdAsc(Long id);
	
}
