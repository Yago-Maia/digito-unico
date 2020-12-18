package com.digito.unico.repository;

import com.digito.unico.domain.UniqueDigit;
import com.digito.unico.domain.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UniqueDigitRepositoryTests {

    @Autowired
    private UniqueDigitRepository uniqueDigitRepository;

    @Test
    public void AsaveTest() throws SQLException {
        UniqueDigit uniqueDigit = new UniqueDigit(null, "5489", 4, 5, null);

        UniqueDigit createdUniqueDigit = uniqueDigitRepository.save(uniqueDigit);

        assertThat(createdUniqueDigit.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest() throws SQLException {
        UniqueDigit uniqueDigit = new UniqueDigit(1L, "54891", 4, 9, null);
        UniqueDigit updatedUniqueDigit = uniqueDigitRepository.save(uniqueDigit);

        assertThat(updatedUniqueDigit.getResult()).isEqualTo(9);
    }

    @Test
    public void getById() {
        UniqueDigit uniqueDigit = uniqueDigitRepository.findById(1L).get();

        assertThat(uniqueDigit.getId()).isEqualTo(1L);
    }
}
