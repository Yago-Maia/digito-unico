package com.digito.unico.service;

import com.digito.unico.domain.UniqueDigit;
import com.digito.unico.domain.User;
import com.digito.unico.exceptions.DataBaseOperationException;
import com.digito.unico.exceptions.FieldValidationException;
import com.digito.unico.repository.UniqueDigitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniqueDigitService {
    @Autowired
    private UniqueDigitRepository uniqueDigitRepository;

    @Autowired
    private OperationUniqueDigitService operationUniqueDigitService;

    @Autowired
    private UniqueDigitCacheService uniqueDigitCacheService;

    @Autowired
    private UserService userService;

    public int computeAndSaveUniqueDigit(UniqueDigit uniqueDigitRequest, Long userId) {

        this.checkFields(uniqueDigitRequest);
        User user = userService.find(userId);

        UniqueDigit uniqueDigit = uniqueDigitCacheService.getFromQueue(uniqueDigitRequest.getN(), uniqueDigitRequest.getK());
        if(uniqueDigit == null) {
            int result = operationUniqueDigitService.computeUniqueDigit(uniqueDigitRequest.getN(), uniqueDigitRequest.getK());

            uniqueDigit = new UniqueDigit();
            uniqueDigit.setBlobFromN(uniqueDigitRequest.getN());
            uniqueDigit.setK(uniqueDigitRequest.getK());
            uniqueDigit.setResult(result);
            uniqueDigitCacheService.insertUniqueDigit(uniqueDigit);
        }

        if(user.getId() != null) {
            uniqueDigit.setUser(user);
            try {
                uniqueDigitRepository.save(uniqueDigit);
            } catch (Exception e) {
                throw new DataBaseOperationException("An error occurred while saving unique digit.");
            }
        }

        return uniqueDigit.getResult();
    }

    public List<UniqueDigit> getAllByUser(Long userId) {
        userService.find(userId);
        try {
            return uniqueDigitRepository.findAllByUserId(userId);
        } catch (Exception e) {
            throw new DataBaseOperationException("An error occurred while getting uniques digits.");
        }
    }

    private void checkFields (UniqueDigit uniqueDigit) {

        if(uniqueDigit.getK() == null || uniqueDigit.getN() == null || uniqueDigit.getN().length() == 0) {
            throw new FieldValidationException("Fields K and N are required.");
        } else if (!uniqueDigit.getN().matches("\\d+")) {
            throw new FieldValidationException("N should contain only numbers.");
        } else if (!(uniqueDigit.getK() >= 1 && uniqueDigit.getK() <= 100000)) {
            throw new FieldValidationException("K should be greater ou equals 1 and lower or equal than 10^5.");
        } else if (uniqueDigit.getN().length() > Math.pow(10, 1000000) || uniqueDigit.getN().equals("0")) {
            throw new FieldValidationException("N should be greater ou equals 1 and lower or equal than 10^1000000.");
        }
    }
}
