package com.devstack.lms.program_service.controller;

import com.devstack.lms.program_service.dto.requestDto.RequestProgramDto;
import com.devstack.lms.program_service.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/programs")
public class ProgramController {

    @PostMapping
    private ResponseEntity<StandardResponse> createProgram(@RequestBody RequestProgramDto requestProgramDto){
        return  new ResponseEntity<>(
                new StandardResponse(201,"program was save",requestProgramDto.getName()), HttpStatus.CREATED
        );
    }
}
