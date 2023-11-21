package com.lib.main.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lib.main.entity.BookInfoEntity;

@Repository
public interface BookLibraryRepository extends JpaRepository<BookInfoEntity, String> {

	@Transactional
	@Modifying
	@Query(value="update book_info set published_date=:date where id=:id ",nativeQuery = true)
	int updatePublishDate(@Param("id") String id, @Param("date") String date);

}
