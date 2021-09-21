package com.than.repository;

import com.than.model.Music;
import com.than.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
}
