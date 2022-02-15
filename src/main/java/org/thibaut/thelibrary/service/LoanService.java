package org.thibaut.thelibrary.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.thibaut.thelibrary.model.LoanDTO;

@FeignClient(name = "THELIBRARY-MS-LOAN", fallback = LoanServiceFallback.class)
public interface LoanService {

}
