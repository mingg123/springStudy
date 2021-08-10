package com.jps.bookmanager.domain.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.jps.bookmanager.domain.User;
import com.jps.bookmanager.domain.UserHistory;
import com.jps.bookmanager.repository.UserHistoryRepository;
import com.jps.bookmanager.support.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityListener {

    //DB에 저장한 다음 바로 userHistory에 저장한다는 의미
    @PostPersist
    @PostUpdate
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
