package com.cryptocurrency.payment.dao;

import com.cryptocurrency.payment.bo.PaymentDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentDetailsRepository extends CrudRepository<PaymentDetails, Integer> {

    public Page<PaymentDetails> findByUserIdAndIsDepositOrderByTnxIdDesc(String userId,
                                                                         boolean isDeposit,Pageable pageable);

    PaymentDetails findTop1ByUserIdOrderByTnxIdDesc(String userId);
}
