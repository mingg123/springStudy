package com.jps.bookmanager.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.jps.bookmanager.repository.UserHistoryRepository;
import com.jps.bookmanager.support.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityListener {

    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);

    }
}
