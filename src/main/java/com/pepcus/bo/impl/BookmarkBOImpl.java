package com.pepcus.bo.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pepcus.beans.BookmarkBean;
import com.pepcus.bo.BookmarkBO;
import com.pepcus.entities.Bookmark;
import com.pepcus.repository.BookmarkRepository;
import com.pepcus.specification.BookmarkSpecification;

@Service
public class BookmarkBOImpl implements BookmarkBO {
	
	@Autowired
	private BookmarkRepository bookmarkRepository;

	//@Override
	public List<Bookmark> findByIdAndDescription(Long id, String description) {
		List<Bookmark> list = bookmarkRepository.findByIdAndDescription(id, description);
		System.out.println("Total Size : "+list.size());
		return list;
	}

	//@Override
	public List<Bookmark> findByDescLike(String description) {
		List<Bookmark> list = bookmarkRepository.findByDescLike(description);
		System.out.println("Total Size : "+list.size());
		return list;
	}

	//@Override
	public List<Bookmark> findByIdLessThan(Long id) {
		List<Bookmark> list = bookmarkRepository.findByIdLessThan(id);
		System.out.println("Total Size : "+list.size());
		return list;
	}

	//@Override
	public List<Bookmark> findByOk(String description, Pageable pageable) {
		List<Bookmark> list = null;
		try {
			list = bookmarkRepository.findByOk(description);//, pageable);
			System.out.println("Total Size : "+list.size());
		}catch (Exception e) {
			System.out.println("Exception Occured : ");
			e.printStackTrace();
		}
		return list;
	}

	//@Override
	public Integer findCount() {
		Integer count = bookmarkRepository.findCount();
		System.out.println("Total Size : "+count);
		return count;
	}
	
	//@Override
	public Bookmark save(Bookmark bookmark) {
		return bookmarkRepository.save(bookmark);
	}

	//@Override
	public Bookmark findOneBookmark(Long id, String desc) {
		Bookmark bookmark = null;
		try {
			return bookmarkRepository.findOne((root, query, cb) -> cb.or(cb.equal(root.get("id"), id), cb.equal(root.get("description"), desc))).get();
		} catch (Exception e) {
			return bookmark;
		}
	}
	
	//@Override
	public Bookmark create(BookmarkBean bookmarkBean) {
		Bookmark bookmark = new Bookmark();
		if(bookmarkBean != null) {
			BeanUtils.copyProperties(bookmarkBean, bookmark);
		}
		return bookmarkRepository.save(bookmark);
	}
	
	//@Override
	public Bookmark update(Long id, BookmarkBean bookmarkBean) {
		bookmarkBean.setId(id);
		Bookmark bookmark2 = bookmarkRepository.findById(id).get();
		BeanUtils.copyProperties(bookmarkBean, bookmark2);
		return bookmarkRepository.save(bookmark2);
	}

	//@Override
	public List<String> findGroupBy() {
		System.out.println("Called : findGroupBy()");
		return bookmarkRepository.findGroupBy();
	}

	//@Override
	public String findByMinId() {
		Long description = (long)1;
		Bookmark bookmark = bookmarkRepository.findTopDescriptionByIdGreaterThanEqualOrderByIdAsc(description);
		System.out.println("Desc:"+bookmark.getId());
		return bookmark.getDescription();
	}
	
	//@Override
	public List<Bookmark> bookmarkHasAcc(Long accId) {
		return bookmarkRepository.findAll(BookmarkSpecification.bookmarkHasAcc(accId));
	}
	
	//@Override
	public List<Bookmark> findLessThan(Long accId, Pageable pageable) {
		return bookmarkRepository.findAll(BookmarkSpecification.findLessThan(accId), pageable).getContent();
		//return null;//bookmarkRepository.findAll);
	}
}
