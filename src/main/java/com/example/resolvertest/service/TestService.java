package com.example.resolvertest.service;

import com.example.resolvertest.dto.TestReqDTO;
import com.example.resolvertest.dto.TestResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    public TestResDTO getData(TestReqDTO reqDTO){
        TestResDTO resDTO = new TestResDTO();

        if(reqDTO.isAdmin()){
            log.info("==== admin request ====");

            resDTO.setResult1(reqDTO.getParam1()+" | admin");
            resDTO.setResult2(reqDTO.getParam2()+" | admin");
        }else{
            log.info("request user id   : "+reqDTO.getUserId());
            log.info("request user name : "+reqDTO.getUsername());

            resDTO.setResult1(reqDTO.getParam1()+" | "+reqDTO.getUsername());
            resDTO.setResult2(reqDTO.getParam2()+" | "+reqDTO.getUsername());
        }

        return resDTO;
    }
}
