/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pepcus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.bo.BookmarkBO;
import com.pepcus.repository.AccountRepository;

/**
 * @author Josh Long
 */
@RestController
@RequestMapping("/book")
class BookmarkRestController {

	private final BookmarkBO bookmarkBO;
	private final AccountRepository accountRepository;
	
	@Autowired
	BookmarkRestController(BookmarkBO bookmarkBO,
						   AccountRepository accountRepository) {
		this.bookmarkBO = bookmarkBO;
		this.accountRepository = accountRepository;
	}

	/*@GetMapping("/{bookmarkId}")
	public Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
		System.out.println("readBookmark2:"+userId);
		this.validateUser(userId);
		
		return this.bookmarkRepository.findById(bookmarkId)
			.orElseThrow(() -> new BookmarkNotFoundException(bookmarkId));
	}
*/
	private void validateUser(String userId) {
		this.accountRepository.findByUsername(userId).orElseThrow(
				() -> new UserNotFoundException(userId));
	}
}
// end::code[]