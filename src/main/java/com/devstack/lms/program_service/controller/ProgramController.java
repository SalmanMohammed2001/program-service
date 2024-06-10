package com.devstack.lms.program_service.controller;

import com.devstack.lms.program_service.dto.requestDto.RequestProgramDto;
import com.devstack.lms.program_service.service.ProgramService;
import com.devstack.lms.program_service.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    @PostMapping
    private ResponseEntity<StandardResponse> createProgram(@RequestBody RequestProgramDto requestProgramDto){

        programService.createProgram(requestProgramDto);
        return  new ResponseEntity<>(
                new StandardResponse(201,"program was save",requestProgramDto.getName()), HttpStatus.CREATED
        );
    }
}
