package com.devstack.lms.program_service.service;

import com.devstack.lms.program_service.dto.ResponseProgramDto;
import com.devstack.lms.program_service.dto.requestDto.RequestProgramDto;

import java.util.List;

public interface ProgramService {


    public void  createProgram(RequestProgramDto programDto);

    public List<ResponseProgramDto>findAllProgram();
}
