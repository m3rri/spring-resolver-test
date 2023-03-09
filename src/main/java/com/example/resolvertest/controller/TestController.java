package com.example.resolvertest.controller;

import com.example.resolvertest.config.resolver.RequestUser;
import com.example.resolvertest.dto.TestReqDTO;
import com.example.resolvertest.dto.TestResDTO;
import com.example.resolvertest.dto.UserDTO;
import com.example.resolvertest.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/")
    public ResponseEntity<TestResDTO> getData(
            @RequestUser UserDTO user,
            @ModelAttribute TestReqDTO reqDTO){
        reqDTO.setUserId(user.getUserId());
        reqDTO.setUsername(user.getUsername());
        reqDTO.setAdmin(user.isAdmin());

        return ResponseEntity.ok().body(testService.getData(reqDTO));
    }
}
