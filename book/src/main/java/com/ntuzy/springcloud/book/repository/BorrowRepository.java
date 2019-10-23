package com.ntuzy.springcloud.book.repository;

import com.ntuzy.springcloud.book.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {

}
